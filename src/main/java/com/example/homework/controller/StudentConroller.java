package com.example.homework.controller;
import com.example.homework.model.Student;
import com.example.homework.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentConroller {

    private final StudentService studentService;

    public StudentConroller(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentId")
    public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
        Student foundStudent = studentService.getStudent(studentId);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @GetMapping("/age/{studentAge}")
    public ResponseEntity<Collection<Student>> getStudentByAge(@PathVariable Integer studendAge) {
        Collection<Student> result = studentService.getStudentByAge(studendAge);
        if (result.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
     }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addSrudent(student);
        return ResponseEntity.ok(addedStudent);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student editedStudent = studentService.editStudent(student);
        if (editedStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(editedStudent);
    }

    @DeleteMapping
    public ResponseEntity<Student> removeStudent(@PathVariable Long studentId) {
        Student removeStudent = studentService.removeStudent(studentId);
        if (removeStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(removeStudent);
    }
}
