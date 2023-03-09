package com.anytimedeveloper.student_management.Services.Implementation;

import com.anytimedeveloper.student_management.Model.Student;
import com.anytimedeveloper.student_management.Repository.StudentRepository;
import com.anytimedeveloper.student_management.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public ResponseEntity<Student> getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        if(student == null){
            return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList= studentRepository.findAll();
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> updateStudentById(Long studentId ,Student updatedStudent) {
        Student student = studentRepository.findById(studentId).get();
        if(student == null){
            return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
        }
        student.setFirstName(updatedStudent.getFirstName()=="" ? student.getFirstName() : updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName()=="" ? student.getLastName() : updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail()=="" ? student.getEmail() : updatedStudent.getEmail());
        student.setBranch(updatedStudent.getBranch()=="" ? student.getBranch() : updatedStudent.getBranch());
        student.setDivision(updatedStudent.getDivision()=="" ? student.getDivision() : updatedStudent.getDivision());

        studentRepository.save(student);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> addStudent(Student student) {
        Student isStudent = studentRepository.findByEmail(student.getEmail());
        if(isStudent != null){
            return new ResponseEntity<>("Student already exist" , HttpStatus.BAD_REQUEST);
        }
        studentRepository.save(student);
        return new ResponseEntity<>("Student is saved",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteStudentById(Long studentId) {
        Student isStudent = studentRepository.findById(studentId).get();
        if(isStudent == null){
            return new ResponseEntity<>("Student does't exist" , HttpStatus.BAD_REQUEST);
        }
        studentRepository.deleteById(studentId);
        return new ResponseEntity<>("Student is deleted",HttpStatus.OK);
    }
}
