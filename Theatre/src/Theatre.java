import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Theater {
    static {
        System.out.println("Welcome to the New Theater");
    }
    // Declaring arrays for rows and an arraylist for tickets
    static int[] row1 = new int[12];
    static int[] row2 = new int[16];
    static int[] row3 = new int[20];
    static ArrayList<Ticket> ticket_info_arraylist = new ArrayList<>();

    /*main method
     * User will select an option to progress*/
    public static void main(String[] args) {
        while (true) {
            System.out.println("-------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1.Buy a ticket");
            System.out.println("2.Print seating area");
            System.out.println("3.Cancel ticket");
            System.out.println("4.List available seats");
            System.out.println("5.Save to file");
            System.out.println("6.Load from file");
            System.out.println("7.Print ticket information and total price");
            System.out.println("8.Sort tickets by price");
            System.out.println("0.Quit");
            System.out.println("------------------------------------------");

            Scanner userInput = new Scanner(System.in);
            System.out.println("Enter Option:");
            try {
                int option = userInput.nextInt();
                switch (option) {
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        Save();
                        break;
                    case 6:
                        load();
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid number. Please try again.");
                }
            }catch (Exception invalidInput){
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }
    /*buy_ticket method includes two other methods to check for row and seat given by the user
     * Row number and seat number are checked initially*/
    static void buy_ticket() {
        int rowSelected, seatSelected;
        double ticketPrice;
        while (true) {
            rowSelected = row_check();
            seatSelected = seat_check(rowSelected);
            if (rowSelected == 1) {
                if (row1[seatSelected - 1] == 0){
                    row1[seatSelected - 1] = 1;
                    ticketPrice = 20.0;
                    break;
                } else {
                    System.out.println("Seat is not available.Please select a different seat.");
                }
            }else if(rowSelected == 2) {
                if (row2[seatSelected - 1] == 0) {
                    row2[seatSelected - 1] = 1;
                    ticketPrice = 15.0;
                    break;
                } else {
                    System.out.println("Seat is not available.Please select a different seat.");
                }
            }else{
                if (row3[seatSelected - 1] == 0) {
                    row3[seatSelected - 1] = 1;
                    ticketPrice = 10.0;
                    break;
                }else{
                    System.out.println("Seat is not available.Please select a different seat.");
                }
            }
        }
        //Taking user's information once the row and seat numbers are validated
        Scanner inputName = new Scanner(System.in);
        Scanner inputSurname = new Scanner(System.in);
        Scanner inputEmail = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = inputName.next();
        System.out.println("Enter your surname :");
        String surname = inputSurname.next();
        System.out.println("Enter your email:");
        String email = inputEmail.next();

        //Adding user's information to the arraylist
        Ticket ticketObject = new Ticket(rowSelected, seatSelected, ticketPrice, new Person(name, surname, email));
        ticket_info_arraylist.add(ticketObject);
        System.out.println("Your seat is booked.");
    }
    /*row_check method used to allow only an integer to pass to methods buy_ticket and cancel_ticket
     * This method is used twice when buying and cancelling a ticket*/
    private static int row_check(){
        int optionRow;
        while (true) {
            Scanner ticketRow = new Scanner(System.in);
            System.out.println("Select a row(1-3):");
            if (ticketRow.hasNextInt()) {
                optionRow = ticketRow.nextInt();
                if(optionRow<4 &&optionRow>0){
                    break;}
                else{
                    System.out.println("Invalid seat row. Please try again.");
                }
            }else{
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return optionRow;
    }
    /*seat_check method is also used to allow only an integer to pass to methods buy_ticket and cancel_ticket
     * This method is used twice when buying and cancelling a ticket*/
    private static int seat_check(int rowSelected){
        int optionSeat;
        while(true){
            Scanner ticketNumber = new Scanner(System.in);
            if (rowSelected == 1) {
                System.out.println("Select the seat number(1-12).");
                if(ticketNumber.hasNextInt()){
                    optionSeat = ticketNumber.nextInt();
                    if(optionSeat <= 12 && optionSeat>0){
                        break;
                    }else{
                        System.out.println("Invalid seat number.Please try again.");
                    }
                }else{
                    System.out.println("Invalid input.Please enter an integer.");
                }
            }else if (rowSelected == 2) {
                System.out.println("Select the seat number(1-16).");
                if(ticketNumber.hasNextInt()){
                    optionSeat = ticketNumber.nextInt();
                    if(optionSeat<=16 && optionSeat>0){
                        break;
                    }else{
                        System.out.println("Invalid seat number.Please try again.");
                    }
                }else{
                    System.out.println("Invalid input.Please enter an integer.");
                }
            }else{
                System.out.println("Select the seat number(1-20).");
                if(ticketNumber.hasNextInt()){
                    optionSeat = ticketNumber.nextInt();
                    if(optionSeat<=20 && optionSeat>0){
                        break;
                    }else{
                        System.out.println("Invalid seat number.Please try again.");
                    }
                }else{
                    System.out.println("Invalid input.Please enter an integer.");
                }
            }
        }
        return optionSeat;
    }
    /*print_seating_area method is used to print the seats and booked seats will be marked as "X" and remaining seats as "O"*/
    static void print_seating_area(){
        System.out.println("              ***********");
        System.out.println("              *  STAGE  *");
        System.out.println("              ***********");
        System.out.print("        ");
        for (int displayRow1 = 0; displayRow1 <row1.length ; displayRow1++) {
            if(row1[displayRow1] == 1){
                System.out.print("X"+" ");
            }else{
                System.out.print("O"+" ");}
            if(displayRow1 == 5){
                System.out.print(" ");
            }
        }
        System.out.print("\n    ");
        for (int displayRow2 = 0; displayRow2 <row2.length ; displayRow2++) {
            if (row2[displayRow2] == 1){
                System.out.print("X"+" ");
            }else{
                System.out.print("O"+" ");
            }if (displayRow2 == 7 ){
                System.out.print(" ");
            }
        }
        System.out.println(" ");
        for (int displayRow3 = 0; displayRow3 < row3.length; displayRow3++) {
            if (row3[displayRow3] == 1) {
                System.out.print("X"+" ");
            }else{
                System.out.print("O"+" ");}
            if (displayRow3 == 9){
                System.out.print(" ");
            }
        }
        System.out.println("\n");
    }
    /*cancel_ticket method is used to cancel a ticket*/
    static void cancel_ticket(){
        int rowCancel,seatCancel;
        while(true) {
            rowCancel=row_check();
            seatCancel = seat_check(rowCancel);
            if (rowCancel == 1) {
                if (row1[seatCancel - 1] == 1) {
                    row1[seatCancel - 1] = 0;
                    break;
                }else{
                    System.out.println("Seat is not booked.Please select a different seat you want to cancel.");}
            }else if(rowCancel == 2) {
                if (row2[seatCancel - 1] == 1) {
                    row2[seatCancel - 1] = 0;
                    break;
                }else{
                    System.out.println("Seat is not booked.Please select a different seat you want to cancel.");}
            }else{
                if(row3[seatCancel - 1] == 1) {
                    row3[seatCancel - 1] = 0;
                    break;
                }else{
                    System.out.println("Seat is not not booked.Please select a different seat you want to cancel.");}
            }
        }
        /*Deleting the ticket from the arraylist*/
        try {
            for (Ticket cancelTicket : ticket_info_arraylist){
                if(cancelTicket.getRow() == rowCancel && cancelTicket.getSeat() == seatCancel){
                    ticket_info_arraylist.remove(cancelTicket);
                    break;}
            }
        }
        catch(Exception e){
            System.out.println("cancelError");
            e.printStackTrace();
        }
        System.out.println("Your seat is cancelled\n");
        main(new String[0]);
    }
    /*show_available method will print the seats which are not booked*/
    static void show_available() {
        System.out.print("Seats available in row 1: ");
        for (int row1_count = 0; row1_count < row1.length; row1_count++) {
            if (row1[row1_count] == 0) {
                System.out.print((row1_count+1)+ ", ");
            }
        }
        System.out.print("\nSeats available in row 2: ");
        for (int row2_count = 0; row2_count < row2.length; row2_count++) {
            if (row2[row2_count] == 0) {
                System.out.print ((row2_count+1) + ", ");
            }
        }
        System.out.print("\nSeats available in row 3: ");
        for (int row3_count = 0; row3_count < row3.length; row3_count++) {
            if (row3[row3_count] == 0) {
                System.out.print((row3_count+1)+ ", ");
            }
        }
        System.out.println(" ");
    }
    /*Save method is used to save the rows to the file */
    static void Save(){
        try {
            FileWriter rowInfoFile = new FileWriter("Row Information.txt");
            rowInfoFile.write("Row 1 -");
            rowInfoFile.write(Arrays.toString(row1));
            rowInfoFile.write("\nRow 2 -");
            rowInfoFile.write(Arrays.toString(row2));
            rowInfoFile.write("\nRow 3 -");
            rowInfoFile.write(Arrays.toString(row3));
            rowInfoFile.close();
            System.out.println("Information saved to the file successfully.");
        }
        catch (IOException e){
            System.out.println("There is a file error");
            e.printStackTrace();
        }
    }
    /*load method will print the information of rows from the file */
    static void load(){
        try {
            File readFile = new File ("Row Information.txt");
            Scanner readRowInfo = new Scanner(readFile);
            while(readRowInfo.hasNextLine()) {
                String info = readRowInfo.nextLine();
                System.out.println(info);
            }
            readRowInfo.close();
        }
        catch (FileNotFoundException e){
            System.out.println("No file found");
            e.printStackTrace();
        }
    }
    /*show_tickets_info method will print the details of each booked ticket
     * This will include information such as name,surname,email,row number,seat number and the price of the ticket*/
    static void show_tickets_info(){
        double total_ticketPrices = 0;
        int ticket_Count = 1;
        for(Ticket ticket:ticket_info_arraylist){
            System.out.println("Ticket information of number:"+ticket_Count);
            ticket.print();
            ticket_Count++;
            total_ticketPrices += ticket.getPrice();
        }
        System.out.println("Total price of Tickets :"+total_ticketPrices);
    }
    /*sort_tickets method will arrange and print the tickets in ascending order based on each ticket price */
    static void sort_tickets(){
        ArrayList<Ticket> sortedArray = new ArrayList<>(ticket_info_arraylist);
        sortedArray.sort(Comparator.comparingInt(o -> (int) o.getPrice()));
        for (Ticket sortedTicket_prices: sortedArray){
            sortedTicket_prices.print();
            System.out.println(" ");
        }
    }
}

