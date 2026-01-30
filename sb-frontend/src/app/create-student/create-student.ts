import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { StudentService } from '../student-service';
import { Student } from '../student';


@Component({
  selector: 'app-create-student',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './create-student.html',
  styleUrls: ['./create-student.css']
})
export class CreateStudent {

  studentForm: FormGroup;
  isSubmitting = false;
  errorMessage = '';

  constructor(
    private fb: FormBuilder,
    private studentService: StudentService,
    private router: Router
  ) {
    this.studentForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      department: ['', Validators.required],
      college: ['', Validators.required]
    });
  }

  // Easy access to form controls
  get f() {
    return this.studentForm.controls;
  }

  onSubmit(): void {
    if (this.studentForm.invalid) {
      this.studentForm.markAllAsTouched();
      return;
    }

    this.isSubmitting = true;

    const student: Student = this.studentForm.value;

    this.studentService.createStudent(student).subscribe({
      next: () => {
        this.isSubmitting = false;
        this.router.navigate(['/get']);
      },
      error: (error) => {
        console.error(error);
        this.errorMessage = 'Failed to create student';
        this.isSubmitting = false;
      }
    });
  }

  onCancel(): void {
    this.router.navigate(['/get']);
  }
}
