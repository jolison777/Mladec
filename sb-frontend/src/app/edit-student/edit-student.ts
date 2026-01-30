import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student-service';
import { Student } from '../student';
import { ChangeDetectorRef } from '@angular/core';


@Component({
  selector: 'app-edit-student',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './edit-student.html',
  styleUrls: ['./edit-student.css']
})
export class EditStudent implements OnInit {

  studentForm!: FormGroup;
  studentId!: number;
  isLoading = false;
  isSubmitting = false;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private studentService: StudentService,
    private router: Router,
    private cdr: ChangeDetectorRef
  ) {}

  ngOnInit(): void {
    this.studentId = Number(this.route.snapshot.paramMap.get('id'));
    this.buildForm();
    this.loadStudent();
  }

  buildForm(): void {
    this.studentForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      department: ['', Validators.required],
      college: ['', Validators.required]
    });
  }

  loadStudent(): void {
    this.isLoading = true;

    this.studentService.getStudentById(this.studentId).subscribe({
      next: (response) => {
        // because backend returns Optional<Student>
        const student: Student = response?.value ?? response;

        this.studentForm.patchValue({
          name: student.name,
          department: student.department,
          college: student.college
        });

        this.isLoading = false;
        this.cdr.detectChanges();
      },
      error: (error) => {
        console.error(error);
        this.errorMessage = 'Failed to load student';
        this.isLoading = false;
        this.cdr.detectChanges();
      }
    });
  }

  get f() {
    return this.studentForm.controls;
  }

  onSubmit(): void {
    if (this.studentForm.invalid) {
      this.studentForm.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;

    const student: Student = {
      id: this.studentId,
      ...this.studentForm.value
    };

    this.studentService.updateStudentById(this.studentId, student).subscribe({
      next: () => {
        this.isSubmitting = false;
        this.router.navigate(['/get']);
      },
      error: (error) => {
        console.error(error);
        this.errorMessage = 'Failed to update student';
        this.isSubmitting = false;
      }
    });
  }

  onCancel(): void {
    this.router.navigate(['/get']);
  }
}
