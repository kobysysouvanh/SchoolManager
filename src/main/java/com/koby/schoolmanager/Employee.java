package com.koby.schoolmanager;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String job;
    public static int count = 1;

    Employee(String name, String job) {
        setId(count++);
        this.name = name;
        name = name.replaceAll("\\s", "");
        this.job = job;
        email = (name + new String(String.valueOf(id)) + "@schoolworker.com");
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
