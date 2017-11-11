/*
 * Written By: Curtis Hempstead
 * Project 03
 * Date Written: 7/11/2017
 * 
 * Purpose: Runs reservation constructor and object, allowing for input for both
 * arrival and departure dates while checking if the input is valid.  Then
 * prints to the user the formatted dates, price, and number of nights.
 * 
 * Description; Project was to create a program that allowed for a user to input
 * a set of dates using the LocalDate method for both arrival and departure
 * dates.  The inputted dates are then converted to a number of days past
 * 1/1/1970 using the toEpochDay method and calculated with the NIGHTLY_RATE
 * constant contained in the IReservationConstants interface.  Finally, the
 * main method prints out the formatted Arrival and Departure dates the 
 * formatted constant price, the formatted total price with the number of nights
 * from the Reservation class.  Main method, prompts user if they wish to
 * continue before ending.
 */
package Project03.presentation;

import Project03.business.Reservation;
import java.time.LocalDate;
import java.util.Scanner;


public class ReservationApp {
    public static void main(String args[]) {
        System.out.println("Reservation Calculation System Startup");
        
        Scanner sc = new Scanner(System.in);
        Reservation reservation = new Reservation();
        String continueReservation = "y"; //sets first instance of continue to "y"
        while (continueReservation.equalsIgnoreCase("y") || continueReservation.equalsIgnoreCase("Y")){
            while (true){
                System.out.print("\nEnter the arrival month (1-12): ");
                int arrivalMonth;
                try { //try and catches if user doesn't input a number
                    arrivalMonth = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please put in the number representing the month-e.g., May = 5");
                    continue;
                }
                if (arrivalMonth<1 || arrivalMonth>12){ //if user doesn't input number from range, reject and print
                    System.out.println("Invalid input, please put in a number representing the month-e.g., May = 5");
                    continue;
                }

                System.out.print("Enter the arrival day (1-31): ");           
                int arrivalDay;
                try { //try and catches if user doesn't input a number
                    arrivalDay = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please put in the number representiing the day-e.g., 12th = 12");
                    continue;
                }
                if (arrivalDay<1 || arrivalDay>31){ //if user doesn't input number from range, reject and print
                    System.out.println("Invalid input, please put in the number representiing the day-e.g., 12th = 12");
                    continue;
                }

                System.out.print("Enter the arrival year: ");
                int arrivalYear;
                try { //try and catches if user doesn't input a number
                    arrivalYear = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please put in the year-e.g., 2017");
                    continue;
                }
                if (arrivalYear<LocalDate.now().getYear()){ //checks if arrival year isn't from the past
                    System.out.println("Invalid input, please input a year after " +LocalDate.now().getYear()+"\n");
                    continue;
                }
                reservation.setArrivalDate(LocalDate.of(arrivalYear, arrivalMonth, arrivalDay));
                if (reservation.getArrivalDate().isBefore(LocalDate.now())){ //checks if arrival date isnt from the past 
                    System.out.println("Please input an arrival date that hasn't already passed.");
                    continue;
                }
                break;
            }

            while (true){
            System.out.print("\nEnter the departure month (1-12): ");
            int departureMonth;
            try { //try and catches if user doesn't input a number
                    departureMonth = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please put in the number representing the month-e.g., May = 5");
                    continue;
                }
                if (departureMonth<1 || departureMonth>12){ //if user doesn't input number from range, reject and print
                    System.out.println("Invalid input, please put in a number representing the month-e.g., May = 5");
                    continue;
                }
                System.out.print("Enter the departure day (1-31): ");
                int departureDay;
                try { //try and catches if user doesn't input a number
                    departureDay = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please put in the number representiing the day-e.g., 12th = 12");
                    continue;
                }
                if (departureDay<1 || departureDay>31){ //if user doesn't input number from range, reject and print
                    System.out.println("Invalid input, please put in the number representiing the day-e.g., 12th = 12");
                    continue;
                }
                System.out.print("Enter the departure year: ");
                int departureYear;
                try { //try and catches if user doesn't input a number
                    departureYear = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please put in the year-e.g., 2017");
                    continue;
                }
                if (departureYear<reservation.getArrivalDate().getYear()){ //checks if departure year isn't before arrival year
                    System.out.println("Invalid input, please input a year after your arrival year " +reservation.getArrivalDate().getYear()+"\n");
                    continue;
                }
                reservation.setDepartureDate(LocalDate.of(departureYear, departureMonth, departureDay));
                if (reservation.getDepartureDate().isBefore(reservation.getArrivalDate())){ //checks if departure year isn't before arrival date
                    System.out.println("Your departure date is before your arrival date, please check and input your fields again.");
                    continue;
                }
                break;
            }
            System.out.println("\nArrival Date: "+reservation.getArrivalDateFormatted()); //print formatted arrival date
            System.out.println("Departure Date: "+reservation.getDepartureDateFormatted());  //print formatted departure date
            System.out.println("Price: "+reservation.getPricePerNightFormatted()+" per night"); //print formatted price per night
            System.out.println("Total price: "+reservation.getTotalPriceFormatted()+" for "+reservation.getNumberOfNights()+" nights"); //print calculated price and number of nights
            System.out.print("\nContinue? (y/n): "); //prompt user for continuation
            continueReservation = sc.nextLine();
        }
    }
}
       

