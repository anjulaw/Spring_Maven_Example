package com.github.elizabetht.service;

import com.github.elizabetht.model.Student;
import com.github.elizabetht.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by anjulaw on 7/5/2016.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public boolean findByLogin(String userName, String password) {
        Student stud = studentRepository.findByUserName(userName);

        if(stud != null && stud.getPassword().equals(password)) {
            return true;
        }

        return false;
    }

    public boolean findByUserName(String userName) {
        Student stud = studentRepository.findByUserName(userName);

        if(stud != null) {
            return true;
        }

        return false;
    }
}
