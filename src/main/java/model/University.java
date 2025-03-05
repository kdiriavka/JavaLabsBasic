package model;

import java.util.List;

public class University {
    private String name;
    private Human head;
    private List<Faculty> faculties;

    public University(String name, Human head, List<Faculty> faculties) {
        this.name = name;
        this.head = head;
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "University: " + name + ", Head: " + head + ", Faculties: " + faculties.size();
    }
}
