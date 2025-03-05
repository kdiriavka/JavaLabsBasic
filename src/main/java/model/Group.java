package model;

import java.util.List;

public class Group {
    private String name;
    private Human head;
    private List<Student> students;

    public Group(String name, Human head, List<Student> students) {
        this.name = name;
        this.head = head;
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group: " + name + ", Head: " + head + ", Students: " + students.size();
    }
}
