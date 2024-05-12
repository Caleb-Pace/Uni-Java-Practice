package unijavapractice.banking;

public class Person {
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }


    //-/ Gets & Sets
    // Retrieves the person's age.
    public int getAge() { return age; }
    
    // Updates the person's age.
    //     {age} should be between 0 and 969 (Inclusive).
    //     If the age is invalid -1 will be used.
    public void setAge(int age) {
        if (age >= 0 && age <= 969)
            this.age = age;
        else
            this.age = -1; // Invalid age
    }

    // Retrieves the person's first name.
    public String getFirstName() { return firstName; }
    
    // Updates the person's first name.
    public void setFirstName(String firstName) { this.firstName = firstName; }

    // Retrieves the person's last name.
    public String getLastName() { return lastName; }

    // Updates the person's last name.
    public void setLastName(String lastName) { this.lastName = lastName; }


    //-/ Methods
    // Returns the Person with the older age (this person or {otherPerson}).
    public Person oldest(Person otherPerson) {
        if (this.age > otherPerson.age)
            return this;
        return otherPerson;
    }

    public String toString() {
        return "First Name = " + firstName + "\n"
             + "Last Name = " + lastName + "\n"
             + "Age = " + age;
    }
}
