import dao.StudentDAO;
import model.Students;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        System.out.print("Введіть номер місяця (1-12): ");
        int month = scanner.nextInt();

        List<Students> students = studentDAO.getStudentsByMonth(month);

        if (students.isEmpty()) {
            System.out.println("Студентів, народжених у цьому місяці, немає.");
        } else {
            System.out.println("Студенти, народжені у вибраному місяці:");
            students.forEach(System.out::println);
        }
    }
}
