package controller;

import model.Department;
import model.Group;
import model.Human;

import java.util.List;

public class DepartmentCreator {
    public static Department createDepartment(String name, Human head, List<Group> groups) {
        return new Department(name, head, groups);
    }
}
