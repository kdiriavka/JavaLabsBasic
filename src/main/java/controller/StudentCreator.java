package controller;

import model.Gender;
import model.Student;

public class StudentCreator {
    public static Student createStudent(String firstName, String lastName, String middleName, Gender gender) {
        return new Student(firstName, lastName, middleName, gender);
    }
}
