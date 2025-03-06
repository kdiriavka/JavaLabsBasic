import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        Human rector = new Human("Іван", "Петров", "Олександрович", Gender.MALE) {};

        // Створюємо студентів
        List<Student> students = new ArrayList<>();
        students.add(StudentCreator.createStudent("Олексій", "Іванов", "Сергійович", Gender.MALE));
        students.add(StudentCreator.createStudent("Марія", "Петренко", "Володимирівна", Gender.FEMALE));

        // Створюємо групу
        Human groupHead = students.get(0);
        Group group = GroupCreator.createGroup("ІП-22", groupHead, students);

        // Створюємо кафедру
        Human departmentHead = new Human("Олег", "Сидоренко", "Петрович", Gender.MALE) {};
        Department department = DepartmentCreator.createDepartment("Кафедра ІТ", departmentHead, List.of(group));

        // Створюємо факультет
        Human facultyHead = new Human("Андрій", "Коваленко", "Ігорович", Gender.MALE) {};
        Faculty faculty = FacultyCreator.createFaculty("Факультет Комп'ютерних Наук", facultyHead, List.of(department));

        // Створюємо університет
        University university = UniversityCreator.createUniversity("Національний Технічний Університет", rector, List.of(faculty));

        // Вивід
        System.out.println(university);
    }
}