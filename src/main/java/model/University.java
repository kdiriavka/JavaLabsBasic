package model;

import com.google.gson.annotations.JsonAdapter;

import java.util.List;
import java.util.Objects;

public class University {
    private String name;
    @JsonAdapter(HumanAdapter.class)
    private Human head;
    private List<Faculty> faculties;

    public University(String name, Human head, List<Faculty> faculties) {
        this.name = name;
        this.head = head;
        this.faculties = faculties;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        University that = (University) obj;
        return Objects.equals(name, that.name) &&
                Objects.equals(head, that.head) &&
                Objects.equals(faculties, that.faculties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, faculties);
    }

    @Override
    public String toString() {
        return "University: " + name + ", Head: " + head + ", Faculties: " + faculties.size();
    }
}
