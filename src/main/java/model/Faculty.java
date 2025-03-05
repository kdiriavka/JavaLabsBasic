package model;

import java.util.List;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments;

    public Faculty(String name, Human head, List<Department> departments) {
        this.name = name;
        this.head = head;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Faculty: " + name + ", Head: " + head + ", Departments: " + departments.size();
    }
}
