package org.example.model;

public class Student extends Human {
    public Student(String firstName, String lastName, String middleName, Sex sex) {
        super(firstName, lastName, middleName, sex);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
