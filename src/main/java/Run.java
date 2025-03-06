import controller.*;
import model.*;
import utils.JsonManager;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        String filePath = "university.json";

        // Створюємо університет
        University university = createTypicalUniversity();
        System.out.println("Original University:");
        System.out.println(university);

        // Записуємо в JSON
        JsonManager.saveToJson(university, filePath);
        System.out.println("University saved to JSON.");

        // Зчитуємо з JSON
        University loadedUniversity = JsonManager.loadFromJson(filePath);
        System.out.println("Loaded University:");
        System.out.println(loadedUniversity);

        // Перевіряємо еквівалентність
        System.out.println("Universities are equal: " + university.equals(loadedUniversity));
    }

    public static University createTypicalUniversity() {
        Human rector = new Human("Іван", "Петров", "Олександрович", Gender.MALE) {};

        // Створюємо студентів
        List<Student> students1 = new ArrayList<>();
        students1.add(StudentCreator.createStudent("Олексій", "Іванов", "Сергійович", Gender.MALE));
        students1.add(StudentCreator.createStudent("Марія", "Петренко", "Володимирівна", Gender.FEMALE));

        List<Student> students2 = new ArrayList<>();
        students2.add(StudentCreator.createStudent("Антон", "Гаврилюк", "Ігорович", Gender.MALE));
        students2.add(StudentCreator.createStudent("Наталія", "Семенюк", "Андріївна", Gender.FEMALE));

        // Створюємо групи
        Group group1 = GroupCreator.createGroup("ІП-22", students1.get(0), students1);
        Group group2 = GroupCreator.createGroup("ІП-23", students2.get(0), students2);

        // Створюємо кафедри
        Human departmentHead = new Human("Олег", "Сидоренко", "Петрович", Gender.MALE) {};
        Department department1 = DepartmentCreator.createDepartment("Кафедра ІТ", departmentHead, List.of(group1, group2));

        Human departmentHead2 = new Human("Олександр", "Мельник", "Олегович", Gender.MALE) {};
        Department department2 = DepartmentCreator.createDepartment("Кафедра Програмування", departmentHead2, List.of(group1, group2));

        // Створюємо факультет
        Human facultyHead = new Human("Андрій", "Коваленко", "Ігорович", Gender.MALE) {};
        Faculty faculty = FacultyCreator.createFaculty("Факультет Комп'ютерних Наук", facultyHead, List.of(department1, department2));

        // Створюємо університет
        return UniversityCreator.createUniversity("Національний Технічний Університет", rector, List.of(faculty));
    }
}
