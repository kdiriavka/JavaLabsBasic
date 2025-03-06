package model;
import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(HumanAdapter.class)
public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Gender gender;

    public Human(String firstName, String lastName, String middleName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + gender + ")";
    }
}
