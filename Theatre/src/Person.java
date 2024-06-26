public class Person {

    private String name;
    private String surname;
    private String email;
    //Constructor related to the Person class is created
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
    //returns name of the person relevant to each ticket
    public String getName(){
        return this.name;
    }
    //returns surname of the person relevant to each ticket
    public String getSurname() {
        return this.surname;
    }
    //returns email of the person relevant to each ticket
    public String getEmail() {
        return this.email;
    }
}
