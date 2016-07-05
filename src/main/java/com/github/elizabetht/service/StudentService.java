package com.github.elizabetht.service;

import com.github.elizabetht.model.Student;

/**
 * Created by anjulaw on 7/5/2016.
 */
public interface StudentService {
    Student save(Student student);
    boolean findByLogin(String userName, String password);
    boolean findByUserName(String userName);
}
