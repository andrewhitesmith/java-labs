package org.example;

import org.example.controller.*;
import org.example.model.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        Human rector = humanCreator.createHuman("Іван", "Іванов", "Іванович", Sex.MALE);
        University university = universityCreator.createUniversity("Університет Технологій", rector);

        Human facultyHead = humanCreator.createHuman("Олена", "Петренко", "Олександрівна", Sex.FEMALE);
        Faculty faculty = facultyCreator.createFaculty("Факультет інформатики", facultyHead);

        Human deptHead = humanCreator.createHuman("Микола", "Коваленко", "Сергійович", Sex.MALE);
        Department department = departmentCreator.createDepartment("Кафедра програмування", deptHead);

        Human groupHead = humanCreator.createHuman("Світлана", "Литвин", "Ігорівна", Sex.FEMALE);
        Group group = groupCreator.createGroup("ПЗ-21", groupHead);

        Student student = studentCreator.createStudent("Андрій", "Сарібекян", "Арменович", Sex.MALE);
        group.addStudent(student);
        department.addGroup(group);
        faculty.addDepartment(department);
        university.addFaculty(faculty);

        System.out.println(university);
    }
}
