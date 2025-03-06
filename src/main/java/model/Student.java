package model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String studentId;

    public Student(int id, String lastName, String firstName, String middleName, LocalDate birthDate, String studentId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return id + ": " + lastName + " " + firstName + " " + middleName + ", " +
                "Дата народження: " + birthDate + ", Залікова: " + studentId;
    }
}
