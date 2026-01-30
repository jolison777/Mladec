import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterModule } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student-service';
import { ChangeDetectorRef } from '@angular/core';

@Component({
  selector: 'app-list-student',
  imports: [CommonModule, RouterLink, RouterModule],
  templateUrl: './list-student.html',
  styleUrls: ['./list-student.css'],
})
export class ListStudent implements OnInit {
  students: Student[] = [];
  isLoading = false;
  errorMessage = '';

  constructor(private studentService: StudentService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.loadStudents();
  }

  loadStudents(): void {
    this.isLoading = true;

    this.studentService.getAllStudents().subscribe({
      next: (data) => {
        console.log(data);
        console.log('Is array:', Array.isArray(data));
        this.students = data;
        this.isLoading = false;
        this.cdr.detectChanges();
        
      },
      error: (error) => {
        console.error(error);
        this.errorMessage = 'Failed to load students';
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }

  deleteStudent(id: number | undefined): void {
    if (!id) return;

    if (confirm('Are you sure you want to delete this student?')) {
      this.studentService.deleteStudentById(id).subscribe({
        next: () => {
          this.loadStudents();
          console.log('Student with ID ' + id + ' deleted successfully');
        },
        error: (error) => {
          console.error(error);
          alert('Failed to delete student');
        }
      });
    }
  }

}
