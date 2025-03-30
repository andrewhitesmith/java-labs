package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String name;
    private Human head;
    private List<Student> students = new ArrayList<>();

    public Group(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + "', " +
                "head=" + head + ", " +
                "students=" + students +
                '}';
    }
}
