package com.example.exampractice.model;

public class Person {

    private String name;
    private String age;
    private String job;

    public Person(String name, String age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
