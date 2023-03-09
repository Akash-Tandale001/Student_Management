package com.anytimedeveloper.student_management.Services;

import com.anytimedeveloper.student_management.Model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {
    ResponseEntity<Student> getStudentById(Long studentId);
    ResponseEntity<List<Student>> getAllStudent();
    ResponseEntity<Student> updateStudentById(Long studentId , Student student);
    ResponseEntity<String> addStudent(Student student);
    ResponseEntity<String> deleteStudentById(Long studentId);
}
