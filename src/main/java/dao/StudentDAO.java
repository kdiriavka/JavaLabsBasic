package dao;

import model.Student;
import utils.DatabaseConnector;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public List<Student> getStudentsByMonth(int month) {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students WHERE strftime('%m', birth_date) = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, String.format("%02d", month));
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String birthDateString = rs.getString("birth_date");
                LocalDate birthDate = LocalDate.parse(birthDateString, DateTimeFormatter.ISO_LOCAL_DATE);

                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("last_name"),
                        rs.getString("first_name"),
                        rs.getString("middle_name"),
                        birthDate,
                        rs.getString("student_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
