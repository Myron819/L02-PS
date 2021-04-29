package com.example.l02_ps;

import java.io.Serializable;

public class Grade implements Serializable {
    private String grade;

    public Grade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
