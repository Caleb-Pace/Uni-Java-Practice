public class Person {
    private String firstName, lastName;
    private int age;

    Person(String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }


    //-/ Gets & Sets
    int getAge() { return age; }
    
    void setAge(int age) {
        if (age >= 0 && age <= 969)
            this.age = age;
        else
            this.age = -1; // Invalid age
    }

    String getFirstName() { return firstName; }
    
    void setFirstName(String firstName) { this.firstName = firstName; }

    String getLastName() { return lastName; }

    void setLastName(String lastName) { this.lastName = lastName; }


    //-/ Methods
    Person oldest(Person otherPerson) {
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
