import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String dateOfBirth;
    private String gender;
    private Person spouse;
    private List<Person> children;
    public Person(String name, String dateOfBirth, String gender) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        children = new ArrayList<>();
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "[Person( Name: " +  getName() + ", Date of Birth: " + getDateOfBirth()
                + ", Gender: " + getGender() + ")]";
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
        spouse.spouse = this.spouse;
    }

    public void addChild(Person child) {
        getChildren().add(child);
        if (isMarried()) {
            getSpouse().getChildren().add(child);
        }
    }

    public boolean isMarried() {
        return getSpouse() != null;
    }
    public Person getSpouse() {
        return spouse;
    }

    public boolean hasTwoChildren() {
        return getChildren().size() == 2;
    }
}

class FamilyTree {
    List<Person> members;
    public FamilyTree() {
        members = new ArrayList<>();
    }

    public void addMembers(Person member) {
        members.add(member);
    }
    public List<Person> getCouplesHaveTwoChildren() {
        List<Person> couples = new ArrayList<>();
        for (Person person : members) {
            if (person.hasTwoChildren() && person.isMarried()) {
                couples.add(person);
            }
        }
        return couples;
    }

    public List<Person> getUnmarriedPerson() {
        List<Person> individual = new ArrayList<>();
        for (Person person : members) {
            if (!person.isMarried()) {
                individual.add(person);
            }
        }
        return individual;
    }

    public List<Person> getLastGeneration() {
        List<Person> generation = new ArrayList<>();
        for (Person person : members) {
            if (person.getChildren().isEmpty()) {
                generation.add(person);
            }
        }
        return generation;
    }



    public static void main(String []args) {
        Person james = new Person("James", "01/01/1965", "Male");
        Person hana = new Person("Hana","01/04/1997","Female");
        Person ryan = new Person("Ryan", "01/01/1990", "Male");
        Person kai = new Person("Kai", "01/02/1995", "Male");
        Person jenifer = new Person("Jennifer", "01/03/1998", "Female");
        Person child1 = new Person("Child1", "03/05/2006", "Male");
        Person child2 = new Person("Child2", "05/09/2003", "Male");
        Person child3 = new Person("Child3", "13/10/2002", "Female");
        Person child4 = new Person("Child4", "30/05/2004", "Female");
        james.setSpouse(hana);
        james.addChild(ryan);
        james.addChild(kai);
        kai.setSpouse(jenifer);
        kai.addChild(child1);
        kai.addChild(child2);
        kai.addChild(child3);
        kai.addChild(child4);
        FamilyTree family = new FamilyTree();
        family.addMembers(james);
        family.addMembers(hana);
        family.addMembers(ryan);
        family.addMembers(kai);
        family.addMembers(jenifer);
        family.addMembers(child1);
        family.addMembers(child2);
        family.addMembers(child3);
        family.addMembers(child4);
        for (Person person : family.getLastGeneration()) {
            System.out.println(person.toString());
        }
    }
}
