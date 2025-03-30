package org.example;

import org.example.controller.*;
import org.example.model.*;
import org.example.util.JsonManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityJsonTest {

    @Test
    public void testJsonSerialization() {
        HumanCreator humanCreator = new HumanCreator();
        StudentCreator studentCreator = new StudentCreator();
        GroupCreator groupCreator = new GroupCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        UniversityCreator universityCreator = new UniversityCreator();

        University oldUniversity = universityCreator.createUniversity("Test University",
                humanCreator.createHuman("Ректор", "Тестовий", "Іванович", Sex.MALE));

        for (int f = 1; f <= 2; f++) {
            Faculty faculty = facultyCreator.createFaculty("Факультет " + f,
                    humanCreator.createHuman("Декан", "Ф" + f, "М", Sex.FEMALE));
            for (int d = 1; d <= 2; d++) {
                Department department = departmentCreator.createDepartment("Кафедра " + d,
                        humanCreator.createHuman("Завкафедри", "Д" + d, "І", Sex.MALE));
                for (int g = 1; g <= 2; g++) {
                    Group group = groupCreator.createGroup("Група " + g,
                            humanCreator.createHuman("Куратор", "Г" + g, "О", Sex.FEMALE));
                    for (int s = 1; s <= 2; s++) {
                        Student student = studentCreator.createStudent("Студент" + s, "Прізвище" + s, "Батькович", Sex.MALE);
                        group.addStudent(student);
                    }
                    department.addGroup(group);
                }
                faculty.addDepartment(department);
            }
            oldUniversity.addFaculty(faculty);
        }

        JsonManager jsonManager = new JsonManager();
        String filename = "university.json";
        jsonManager.writeToFile(oldUniversity, filename);
        University newUniversity = jsonManager.readFromFile(filename);

        assertEquals(oldUniversity, newUniversity);
    }
}
