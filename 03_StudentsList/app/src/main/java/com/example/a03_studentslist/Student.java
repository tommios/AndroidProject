package com.example.a03_studentslist;

public class Student {
    private String name; // Имя
    private String surname; // Фамилия
    private String group;  // Группа
    private int flagResource; // ресурс флага
    Boolean box;

    public Student(String name, String surname, String group, int flag, Boolean box) {

        this.name = name;
        this.surname = surname;
        this.group = group;
        this.flagResource = flag;
        this.box = box;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }

    public Boolean getBox(){return this.box;}

    public void setBox(Boolean box) {
        this.box = box;
    }

}
