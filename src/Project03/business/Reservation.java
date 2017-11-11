/*
 * Written By: Curtis Hempstead
 * Project 03
 * Date Written: 7/11/2017
 * 
 * Purpose: Provides getters and setters for the arrival and departure dates.
 * Also contains the methods to format and calculate the price, dates, and number
 * of night by implementing the IReservationConstants interface.
 * 
 */
package Project03.business;

import Project03.database.IReservationConstants;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Reservation implements IReservationConstants{ //implements constant interface
    private LocalDate arrivalDate; //arrival date
    private LocalDate departureDate; //departure date
    DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG); //formatter object
    NumberFormat currecny = NumberFormat.getCurrencyInstance(); //fomatter object

    public LocalDate getArrivalDate() { //get arrival date
        return arrivalDate;
    }
    
    public void setArrivalDate(LocalDate arrivalDate) { //set arrival date
        this.arrivalDate = arrivalDate;
    }
    
    public String getArrivalDateFormatted(){; //format and get arrival date
        return dtf.format(arrivalDate);
    }

    public LocalDate getDepartureDate() { //get departure date
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) { //set arrival date
        this.departureDate = departureDate;
    }
    
    public String getDepartureDateFormatted(){ //format and get arrival date
        return dtf.format(departureDate);
    }
    
    public int getNumberOfNights(){ //calculate difference of days from Jan. 1, 1970.
        long arrivalNights=arrivalDate.toEpochDay(); //arrival date into number of days since 1/1/1970
        long departureNights=departureDate.toEpochDay(); //departure date into number of days since 1/1/1970
        int numberOfNights=(int)departureNights-(int)arrivalNights; //arithmetic operator to determine total number of days between the two dates
        return numberOfNights;
    }
    
    public String getPricePerNightFormatted(){
        return currecny.format(NIGHTLY_RATE);
    }
    
    public double getTotalPrice(){ //calculate total price
        double totalPrice=NIGHTLY_RATE*getNumberOfNights(); //takes NIGHTLY_RATE constant from IReservationConstants interface and multiplies by Number of Nights getter
        return totalPrice;
    }
    
    public String getTotalPriceFormatted(){ //formats and gets total price
        return currecny.format(getTotalPrice());
    }
}
