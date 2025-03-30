package org.example.controller;

import org.example.model.University;
import org.example.model.Human;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
