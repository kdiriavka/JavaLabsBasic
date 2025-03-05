package model;

public abstract class Human {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected Sex sex;

    public Human(String firstName, String lastName, String middleName, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + " (" + sex + ")";
    }
}
