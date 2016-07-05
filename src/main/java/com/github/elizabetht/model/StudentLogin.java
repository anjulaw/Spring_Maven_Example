package com.github.elizabetht.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 * Created by anjulaw on 7/5/2016.
 */
public class StudentLogin {

    @NotEmpty
    @Size(min=4, max=20)
    private String userName;

    @NotEmpty
    @Size(min=4, max=8)
    @Column(name = "LKK")
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
