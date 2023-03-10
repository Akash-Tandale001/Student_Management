package com.anytimedeveloper.student_management.Controller;

import com.anytimedeveloper.student_management.Model.Student;
import com.anytimedeveloper.student_management.Services.Implementation.StudentServiceImpl;
import com.anytimedeveloper.student_management.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId){
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/getAllStudent")
    public ResponseEntity<List<Student>> getAllStudent(){
        return studentService.getAllStudent();
    }
    @PostMapping("/addStudent")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }
    @PostMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId ,@RequestBody Student student){
        return studentService.updateStudentById(studentId,student);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long studentId){
        return studentService.deleteStudentById(studentId);
    }
}
