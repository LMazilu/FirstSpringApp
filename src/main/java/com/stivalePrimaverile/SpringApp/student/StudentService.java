package com.stivalePrimaverile.SpringApp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalArgumentException("Student with email" + student.getEmail() + " already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalArgumentException("deleteStudent: Student with id " + studentId + " not found");
        }
        studentRepository.deleteById(studentId);
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new IllegalArgumentException("getById: Student with id " + studentId + " not found"));
    }

    public void updateStudent(Long studentId, Student student) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalArgumentException("updateStudent: Student with id " + studentId + " not found");
        }
        student.setId(studentId);
        studentRepository.save(student);
    }
}
