import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student-service';
import { Student } from '../student';
import { ChangeDetectorRef } from '@angular/core';


@Component({
  selector: 'app-view-student',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './view-student.html',
  styleUrls: ['./view-student.css']
})
export class ViewStudent implements OnInit {

  studentId!: number;
  student!: Student;
  isLoading = false;
  errorMessage = '';

  constructor(
    private route: ActivatedRoute,
    private studentService: StudentService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.studentId = Number(this.route.snapshot.paramMap.get('id'));
    this.loadStudent();
  }

  loadStudent(): void {
    this.isLoading = true;

    this.studentService.getStudentById(this.studentId).subscribe({
      next: (response) => {
        console.log(response);
        this.student = response?.value ?? response;
        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (error) => {
        console.error(error);
        this.errorMessage = 'Student not found';
        this.isLoading = false;
        this.cdr.detectChanges(); 
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/get']);
  }

  editStudent(): void {
    this.router.navigate(['/updateById', this.studentId]);
  }
}
