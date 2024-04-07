public class Ticket {
    private int row;
    private int seat;
    private double price;
    private Person Person;

    //Constructor related to the Ticket class is created
    public Ticket(int row, int seat, double price, Person Person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.Person = Person;
    }
    //returns row number relevant to each ticket
    public int getRow() {
        return this.row;
    }
    //returns seat number relevant to each ticket
    public int getSeat() {
        return this.seat;
    }
    //returns price relevant to each ticket
    public double getPrice() {
        return this.price;
    }
    void print(){
        System.out.println("Person name :"+Person.getName());
        System.out.println("Person surname:"+Person.getSurname());
        System.out.println("Person email:"+Person.getEmail());
        System.out.println("Row number:"+getRow());
        System.out.println("Seat number:"+getSeat());
        System.out.println("Price of the ticket:"+getPrice());
        System.out.println(" ");
    }
}
