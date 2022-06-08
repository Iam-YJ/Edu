//package com.nhnacademy.edu.springboot.student;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class NhnStudentService implements StudentService{
//
//    private final StudentRepository studentRepository;
//
//    @Override
//    public List<Student> getStudents() {
//        return studentRepository.findAll();
//    }
//
//    @Override
//    public Student getStudent(Long id) {
//        return studentRepository.findById(id).orElseThrow();
//    }
//
//    @Override
//    public Student createStudent(Student student) {
//        if(studentRepository.findById(student.getId()).isPresent()){
//            throw new IllegalStateException("already exists " + student.getId());
//        }
//        return studentRepository.save(student);
//    }
//
//    @Override
//    public void deleteStudent(Long id) {
//        studentRepository.deleteById(id);
//    }
//}
