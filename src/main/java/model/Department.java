package model;

import java.util.List;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    public Department(String name, Human head, List<Group> groups) {
        this.name = name;
        this.head = head;
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Department: " + name + ", Head: " + head + ", Groups: " + groups.size();
    }
}
