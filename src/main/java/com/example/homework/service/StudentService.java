package com.example.homework.service;
import com.example.homework.model.Student;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentService {
    private final Map<Long, Student>students=new HashMap<>();
    private long counter=0;

    public Student addSrudent(Student student) {
        student.setId(counter++);
        students.put(counter, student);
        return student;
    }

    public Student getStudent(Long id) {
        return students.get(id);
    }

    public Student editStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student removeStudent(Long id) {
        return students.remove(id);
    }

    public Collection<Student> getStudentByAge(int age) {
        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }
}
