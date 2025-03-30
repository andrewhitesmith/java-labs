package org.example.controller;

import org.example.model.Sex;
import org.example.model.Student;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String middleName, Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}
