package com.koby.schoolmanager;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Students {
    private int id;
    private String name;
    private String grade;
    private String email;
    private double gpa;
    private static int count = 1;

    Students(String name, String grade, double gpa) {
        setId(count++);
        this.name = name;
        name = name.replaceAll("\\s", "");
        email = name + new String(String.valueOf(id)) + "@schoolmail.com";
        this.grade = grade;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

}
