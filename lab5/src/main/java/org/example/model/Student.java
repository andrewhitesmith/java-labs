package org.example.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate birthDate;
    private String recordBookNumber;

    public Student(int id, String firstName, String lastName, String middleName, LocalDate birthDate, String recordBookNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNumber = recordBookNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + birthDate + ")";
    }

}
