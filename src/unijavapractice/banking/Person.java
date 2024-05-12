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
    public int getAge() { return age; }
    
    public void setAge(int age) {
        if (age >= 0 && age <= 969)
            this.age = age;
        else
            this.age = -1; // Invalid age
    }

    public String getFirstName() { return firstName; }
    
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }


    //-/ Methods
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
