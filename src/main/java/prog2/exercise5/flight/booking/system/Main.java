package prog2.exercise5.flight.booking.system;

/**
 * Hello world!
 *
 */

import java.time.LocalDate;
import java.util.Scanner;

public class Main 
{

    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter how may ticket do you want");
       /*  Scanner input = new Scanner(System.in);
            System.out.println("Please enter your full name: ");
            String passengerFullName = input.nextLine();
            System.out.println("Please enter your year of departure: ");
            int dYear = input.nextInt();
            System.out.println("Please enter your month of departure: ");
            int dMonth = input.nextInt();
            System.out.println("Please enter your day of departure: ");
            int dDay = input.nextInt();
            System.out.println("Please enter your year of return: ");
            int rYear = input.nextInt();
            System.out.println("Please enter your month of return: ");
            int rMonth = input.nextInt();
            System.out.println("Please enter your day of return: ");
            int rDay = input.nextInt();
            System.out.println("Please enter how many children tickets do you need: ");
            int childPassengers = input.nextInt();
            System.out.println("Please enter how many adult tickets do you need: ");
            int adultPassengers = input.nextInt(); */

            //Below are from exercise4
            /* 
            input.nextLine();
            System.out.println("Please enter the source of your trip: ");
            String  tripSource = input.nextLine();
            System.out.println("Please enter the destination of your trip: ");
            String  tripDestination = input.nextLine();
            System.out.println("Please enter the type of your trip: ");
            String  tripType = input.nextLine();*/
            

            /*LocalDate departureDate =  LocalDate.of(dYear, dMonth, dDay);
            LocalDate returnDate =  LocalDate.of(rYear, rMonth, rDay);*/

            //Below are from E3

            //FlightBooking family1 = new FlightBooking(passengerFullName, departureDate, returnDate, childPassengers, adultPassengers);
            /*family1.setTotalPassengers(childPassengers, adultPassengers);
            family1.setTotalTicketPrice(childPassengers, adultPassengers);*/

                  /*   System.out.print("Dear " + passengerFullName + ". Thank you for booking your flight with " + 
                    family1.getFlightCompany()  + ". Following are the details of your booking and the trip:" + "\n" + 
                    "Ticket Number: " + family1.getTicketNumber() + "\n" + 
                    "From " + family1.getTripSource() + " to " + family1.getTripDestination() + "\n" +
                    "Date of departure: " + departureDate + "\n" +
                    "Date of return: " + returnDate + "\n" +
                    "Total passengers: " + family1.getTotalPassengers() + "\n" +
                    "Total ticket price in Euros: " + family1.getTotalTicketPrice());*/

            
            //System.out.println(family1);

            //Below are from E3

           /*family1.setTripSource("1");
            family1.setTripDestination("1", "2");
            family1.setReturnDate(returnDate);
            family1.setTripType("2");
            family1.setBookingClass("1");

            family1.setDepartingTicketPrice(2, 5);
            family1.setReturnTicketPrice();

            family1.setTotalTicketPrice();
        
        System.out.println(family1.StringOption1());*/

        //Below are from E5
        int number = in.nextInt();
        FlightBooking family1 = new FlightBooking(number);
        family1.reserveTicket();
        in.close();
    }


}
