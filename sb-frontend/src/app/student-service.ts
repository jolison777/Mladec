import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';
import { Student } from './student';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  private API_URL = 'http://localhost:7777/student/v1/api';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  }

  constructor(private http: HttpClient) { }

  getAllStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(
      `${this.API_URL}/get`,
      this.httpOptions
    ).pipe(
      catchError(this.errorHandler)
    );  
  }

  getStudentById(id: number): Observable<any> {
    return this.http.get<any>(
      `${this.API_URL}/getbyId/${id}`,
      this.httpOptions
    ).pipe(
      catchError(this.errorHandler)
    );
  }

createStudent(student: Student): Observable<Student> {
  return this.http.post<Student>(
    `${this.API_URL}/create`,
    student,
    this.httpOptions
  );
}


  updateStudentById(id: number, student: Student): Observable<Student> {
    return this.http.put<Student>(
      `${this.API_URL}/updateById/${id}`,
      JSON.stringify(student),
      this.httpOptions
    ).pipe(
      catchError(this.errorHandler)
    );
  }

  deleteStudentById(id: number): Observable<Student[]> {
    return this.http.delete<Student[]>(
      `${this.API_URL}/deleteById/${id}`,
      this.httpOptions
    ).pipe(
      catchError(this.errorHandler)
    );
  }

  errorHandler(error: any) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = error.error.message;
    } else {
      // Server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error('An error occurred:', error);
    return throwError(() => {
      return errorMessage;
    });
  }
}
