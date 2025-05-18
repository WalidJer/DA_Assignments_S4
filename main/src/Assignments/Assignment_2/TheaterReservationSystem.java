import java.util.Scanner;

/**
 * Assignment 2: Movie Theater Implementation
 *
 * This program simulates a movie theater reservation system.
 * It allows users to:
 * 1. Reserve seats (with suggestion if selected seat is taken)
 * 2. Cancel reservations
 * 3. View the current seating chart
 */

public class TheaterReservationSystem {

    char[][] seats;

    public TheaterReservationSystem(int rows, int cols) {
        seats = new char[rows][cols];
    }

    /**
     * Initializes the seating chart by marking all seats as available ('o').
     */

    public void seatsLayout() {

        for (int row = 0; row< seats.length; row++) {
            for (int col = 0; col < seats[row].length; col++) {
                seats[row][col] = 'o';
            }
        }
    }

    /**
     * Displays the current seating chart.
     * Reserved seats are marked with 'x', and available seats with 'o'.
     */

    public void printSeats() {
        for (int row = 0; row < seats.length; row++) {
            System.out.print("Row"+(row + 1) + ": ");
            for (int col= 0; col < seats[row].length; col++) {
                System.out.print(seats[row][col] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Attempts to reserve the specified seat. If the seat is taken,
     * it suggests the next available seat.
     */

    public void reservedSeat(int row, int col, Scanner sc) {
        if (row >= 0 && row < seats.length && col >= 0 && col < seats[0].length) {
            if (seats[row][col] == 'o') {
                seats[row][col] = 'x';
                System.out.println("Seat reserved successfully.");
            } else {
                System.out.println("Seat already taken. Here is a suggested availble seat:");
                suggestedAvailableSeat(sc);
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    /**
     * Finds the first available seat and prompts the user to reserve it.
     */

    public void suggestedAvailableSeat(Scanner sc){

        for (int row = 0; row < seats.length; row++){
            for (int col = 0; col < seats[row].length; col++){

                if (seats[row][col] == 'o'){

                    System.out.println("Suggested seat: Row " + row + ", Column " + col);

                    System.out.print("Would you like to reserve it? (yes/no): ");
                    String response = sc.next();
                    if (response.equalsIgnoreCase("yes")) {
                        seats[row][col] = 'x';
                        System.out.println("Suggested seat reserved.");
                    } else {
                        System.out.println("No problem. the current seating chart; choose an available seat:");
                        printSeats();
                    }
                    return;
                }
            }
        }

        System.out.println("No available seats.");

    }

    /**
     * Cancels a reserved seat if it exists.
     */
    public void cancelSeat(int row, int col){
        if (row >= 0 && row < seats.length && col >= 0 && col < seats[0].length){

            if ( seats[row][col] == 'x'){
                seats[row][col] = 'o';
                System.out.println("Seat cancellation successful.");
            
            }else{
                System.out.println("That seat is not currently reserved.");
            }
        }else{
            System.out.println("Invalid seat number");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        TheaterReservationSystem movieTheater = new TheaterReservationSystem(8, 10);
        movieTheater.seatsLayout();
        System.out.println();
        System.out.println("Welcome to our Online Theater Reservation System!");
        
        movieTheater.printSeats();

        boolean running = true;

        while (running) {

            System.out.println("\nChoose an option:");
            System.out.println("1. Reserve a seat");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. View seat chart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter row number (1-8): ");
                    int row = sc.nextInt() - 1;

                    System.out.print("Enter column number (1-10): ");
                    int col = sc.nextInt() - 1;
                    movieTheater.reservedSeat(row, col,sc);      
                    break;
                case 2: 
                    System.out.println("Enter row number to cancel (1-8)");
                    int rowToCancel = sc.nextInt() - 1;

                    System.out.println("Enter column number to cancel (1-10)");
                    int columnToCancel = sc.nextInt() -1;

                    movieTheater.cancelSeat(rowToCancel, columnToCancel);
                    break;
                case 3:
                    movieTheater.printSeats();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Theater Reservation System!");
                    break;
                default:
                    System.out.println("Invalid option. Please select 1-4.");
            }

            
        }

        sc.close();
    }
}