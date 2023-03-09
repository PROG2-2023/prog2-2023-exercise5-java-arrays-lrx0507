package prog2.exercise5.flight.booking.system;

import java.util.Random;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class FlightBooking {
    public String getRandomString(int length) {
        String range = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            str.append(range.charAt(number));
        }
        return str.toString();
    }
    //The code before is used to make a random String.
    
    //attributes
    //Below from Exercise 3

    private static final String flightCompany = "Flights-of-Fancy";
    private String flightID = getRandomString(9);
    private String passengerFullName;
    private static final String tripSource = "NANJING";  //From E4 it became sourceOfTrip
    private static final String sourceAirport = "NANJING LUKOU INTERNATIONAL AIRPORT";
    private static final String tripDestination = "OULU";  //From E4 it become destinationOfTrip
    private static final String destinationAirport = "OULU AIRPORT";
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int childPassengers;
    private int adultPassengers;
    private int totalPassengers;
    //private static final double departingTicketPrice = 400;
    //private static final double returnTicketPrice = 400;
    private double departingTicketPrice = 400;
    private double returnTicketPrice = 400;
    private double totalTicketPrice;
    private String ticketNumber = getRandomString(4);//Changed in exercise4 setter "getTicketNumber()"

    //Below from Exercise 4


    public enum BookingClass {
        FIRST, BUSINESS, ECONOMY;
    }

    public enum  TripType{
        ONE_WAY, RETURN;
    }

    public enum TripSource {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;
    }

    public enum TripDestination {
        NANJING, BEIJING, SHANGHAI, OULU, HELSINKI, PARIS;;
    }

    public enum SourceAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    public enum DestinationAirport {
        Nanjing_Lukou_International_Airport, Beijing_Capital_International_Airport, Shanghai_Pudong_International_Airport, Oulu_Airport, Helsinki_Airport, Paris_Charles_de_Gaulle_Airport;
    }

    private BookingClass bookingClass;
    private TripType typeOfTrip;
    private TripSource sourceOfTrip;
    private TripDestination destinationOfTrip;
    private SourceAirport airportOfSource;
    private DestinationAirport airportOfDestination;

    private int flag1;

    //Below from Exercise 5

    int size;
    String[] passengerFullNames = new String [size];
    String[] passengerGenders = new String [size];
    int[] passengerAges = new int [size];
    String[] ticketNumbers = new String [size];
    


    //Below is the constractor of E3 and E4

    /*public FlightBooking(String passengerFullName, LocalDate departureDate, LocalDate returnDate, int childPassengers, int adultPassengers) {
        this.passengerFullName = passengerFullName;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.childPassengers = childPassengers;
        this.adultPassengers = adultPassengers;
    } */

    //Below is the constractor of E5

    public FlightBooking(int size) {
        String[] passengerFullNames = new String [size];
        String[] passengerGenders = new String [size];
        int[] passengerAges = new int [size];
        String[] ticketNumbers = new String [size];
        this.passengerFullNames = passengerFullNames;
        this.passengerGenders = passengerGenders;
        this.passengerAges = passengerAges;
        this.ticketNumbers = ticketNumbers;
    }

    //setters and getters
    //Below from Exercise 3

    public String getFlightCompany() {
        return flightCompany;
    }

    public String getFlightID()  {
        return flightID;
    }

    /*public String getPassengerFullName() {
        return passengerFullName;
    }*/ //Overwrote by E5

    /*public String getTripSource() {
        return tripSource;
    }*/  //been overwrote by E4

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getTripDestination() {
        return tripDestination;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public int getChildrenPassengers() {
        return childPassengers;
    }

    public int getAdultPassengers() {
        return adultPassengers;
    }

    /*public String getTicketNumber() {
        return ticketNumber;
    } */  //been overWrote by E4

    public int getTotalPassengers() {
        return childPassengers + adultPassengers;
    }

   /*  public double getTotalTicketPrice() {
        return  (childPassengers + adultPassengers) * (departingTicketPrice + returnTicketPrice);
    } */  //been overWrote by E4


    /*public LocalDate getDepartingDate() {
        return departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }*/  //been overWrote by E4

    public void setChildPassenger(int childPassengers) {
        this.childPassengers = childPassengers;
    }
    public void adultPassenger(int adultPassengers) {
        this.adultPassengers = adultPassengers;
    }

    public void setTotalPassengers(int childPassengers, int adultPassengers) {
        this.totalPassengers = childPassengers + adultPassengers;
    }

    /*public void setTotalTicketPrice(int childPassengers, int adultPassengers) {
        this.totalTicketPrice = (childPassengers + adultPassengers) * (departingTicketPrice + returnTicketPrice);
    }*/ //been overWrote by E4


    //Below from Exercise 4

   

    public LocalDate getDepartingDate() {
        return departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

     public TripSource getTripSource() {
        return sourceOfTrip;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        long dayDifference = ChronoUnit.DAYS.between(departureDate, returnDate);
        if(dayDifference == 1) {
            System.out.println("If departure date is " + departureDate + "and the return date is " + returnDate + " , Then the program should automatically change the return date to " + departureDate.plusDays(2) + ".");
            this.returnDate = departureDate.plusDays(2);
            this.flag1 = 1;
        } else if(dayDifference == 0) {
            System.out.println("If both the departure date and return date are " + departureDate + " , " + "Then the program should automatically change the return date to " + departureDate.plusDays(2) + ".");
            this.returnDate = departureDate.plusDays(2);
            this.flag1 = 2;
        } else {
            this.returnDate = returnDate;
            this.flag1 = 0;
       }
        
    }

    public void setBookingClass(String classType) {
        int choice = Integer.parseInt(classType);
        switch(choice) {
            case 1:
            bookingClass = BookingClass.FIRST;
            break;
            case 2:
            bookingClass = BookingClass.BUSINESS;
            break;
            case 3:
            bookingClass = BookingClass.ECONOMY;
            break;
            default :
            System.out.println("Error input.");
        }
    }
    
    public void setTripType(String type) {    
        int choice = Integer.parseInt(type);
        switch(choice) {
            case 1:
            typeOfTrip = TripType.ONE_WAY;
            break;
            case 2:
            typeOfTrip = TripType.RETURN;
            break;
            default :
            System.out.println("Error input.");
        }
    }

    public void setTripSource(String tripSource) {   //Only one parameter
        int choice = Integer.parseInt(tripSource);
        switch(choice) {
            case 1:
            sourceOfTrip = TripSource.NANJING;
            break;
            case 2:
            sourceOfTrip = TripSource.BEIJING;
            break;
            case 3:
            sourceOfTrip = TripSource.SHANGHAI;
            break;
            case 4:
            sourceOfTrip = TripSource.OULU;
            break;
            case 5:
            sourceOfTrip = TripSource.HELSINKI;
            break;
            case 6:
            sourceOfTrip = TripSource.PARIS;
            break;
            default :
            System.out.println("Error input.");
        }
    }

    public void setTripDestination(String tripSource, String tripDestination) {
        int srcChoice = Integer.parseInt(tripSource);
        int desChoice = Integer.parseInt(tripDestination);
        if(srcChoice != desChoice) {
            switch(desChoice) {
            case 1:
            destinationOfTrip = TripDestination.NANJING;
            break;
            case 2:
            destinationOfTrip = TripDestination.BEIJING;
            break;
            case 3:
            destinationOfTrip = TripDestination.SHANGHAI;
            break;
            case 4:
            destinationOfTrip = TripDestination.OULU;
            break;
            case 5:
            destinationOfTrip = TripDestination.HELSINKI;
            break;
            case 6:
            destinationOfTrip = TripDestination. PARIS;
            break;
            default :
            System.out.println("Error input.");
            }
        } else {
            System.out.println("The trip source and the trip destination should not be the same!");
        }
        
    }

    /*public String getTicketNumber() {
        String ticketNum;
        if(typeOfTrip == TripType.ONE_WAY) {
            ticketNum = "11";
            if(bookingClass == BookingClass.FIRST){
                ticketNum = ticketNum + "F" + ticketNumber;
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true; 
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + ticketNumber;
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + ticketNumber;
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            }
        } else {
            ticketNum = "22";
            if(bookingClass == BookingClass.FIRST){
                ticketNum = ticketNum + "F" + ticketNumber;
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + ticketNumber;
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + ticketNumber;
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                   // flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                   // flag1 = true;
                }
            }
        }

        return ticketNum;
    } */ //Overwrote by E5

    /*public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        double departingTicketPrice = 0.0;
        if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU) || ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI))) {
            departingTicketPrice = 300 * (1 + 0.05 + 0.1);
        } else  {
            departingTicketPrice = 300 * (1 + 0.15 + 0.1);
        }
        if(bookingClass == BookingClass.FIRST) {
            this.departingTicketPrice = departingTicketPrice * (childPassengers + adultPassengers) + 250;
        } else if(bookingClass == BookingClass.BUSINESS) {
            this.departingTicketPrice = departingTicketPrice * (childPassengers + adultPassengers) + 150;
        } else if(bookingClass == BookingClass.ECONOMY) {
            this.departingTicketPrice = departingTicketPrice * (childPassengers + adultPassengers) + 50;
        }
    }*/

    public void setDepartingTicketPrice(int childPassengers, int adultPassengers) {
        double departingTicketPrice = 0.0;
        if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU) || ((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI))) {
            departingTicketPrice = (300  + 0.1 * 300) + 0.05 * 300;
        } else  {
            departingTicketPrice = (300  + 0.15 * 300) + 0.1 * 300;
        }
        if(bookingClass == BookingClass.FIRST) {
            this.departingTicketPrice = (departingTicketPrice + 250) * childPassengers + (departingTicketPrice + 250) * adultPassengers ;
        } else if(bookingClass == BookingClass.BUSINESS) {
            this.departingTicketPrice = (departingTicketPrice + 150) * childPassengers + (departingTicketPrice + 150) * adultPassengers;
        } else if(bookingClass == BookingClass.ECONOMY) {
            this.departingTicketPrice = (departingTicketPrice + 50) * childPassengers + (departingTicketPrice + 50)* adultPassengers;
        }
    }

    public void setReturnTicketPrice() {
        if(typeOfTrip == TripType.ONE_WAY) {
            this.returnTicketPrice = 0;
        } else {
            this.returnTicketPrice = this.departingTicketPrice;
        }
    }

    public void setTotalTicketPrice() {
        this.totalTicketPrice = this.departingTicketPrice + this.returnTicketPrice;
    }

    public double getTotalTicketPrice() {
        return this.totalTicketPrice;
    }

    //Below are from E5

    public String getPassengerFullName(int index) {
        return passengerFullNames[index];
    }

    String getPassengerGender(int index) {
        return passengerGenders[index];
    }

    int getPassengerAge(int index) {
        return passengerAges[index];
    }

    public void setSourceAirport(String source) {   //Only one parameter
        int choice = Integer.parseInt(source);
        switch(choice) {
            case 1:
            airportOfSource = SourceAirport.Nanjing_Lukou_International_Airport;
            break;
            case 2:
            airportOfSource = SourceAirport.Beijing_Capital_International_Airport;
            break;
            case 3:
            airportOfSource = SourceAirport.Shanghai_Pudong_International_Airport;
            break;
            case 4:
            airportOfSource = SourceAirport.Oulu_Airport;
            break;
            case 5:
            airportOfSource = SourceAirport.Helsinki_Airport;
            break;
            case 6:
            airportOfSource = SourceAirport.Paris_Charles_de_Gaulle_Airport;
            break;
            default :
            System.out.println("Error input.");
        }
    }

    public void setDestinationAirport(String source, String destination) {   //Only one parameter
        int choice1 = Integer.parseInt(source);
        int choice2 = Integer.parseInt(destination);
        if(choice1 != choice2){
            switch(choice2) {
            case 1:
            airportOfDestination = DestinationAirport.Nanjing_Lukou_International_Airport;
            break;
            case 2:
            airportOfDestination = DestinationAirport.Beijing_Capital_International_Airport;
            break;
            case 3:
            airportOfDestination = DestinationAirport.Shanghai_Pudong_International_Airport;
            break;
            case 4:
            airportOfDestination = DestinationAirport.Oulu_Airport;
            break;
            case 5:
            airportOfDestination = DestinationAirport.Helsinki_Airport;
            break;
            case 6:
            airportOfDestination = DestinationAirport.Paris_Charles_de_Gaulle_Airport;
            break;
            default :
            System.out.println("Error input.");
            }
        }

        
    }


    public void setPassengerFullName(int index, String passengerFullName) {
        passengerFullNames[index] = passengerFullName;
    }

    public void setPassengerGender(int index, String passengerGender) {
        passengerGenders[index] = passengerGender;
    }

    public void setPassengerAge(int index, int passengerAge) {
        passengerAges[index] = passengerAge;
    }

    public void setTicketNumber(int index) {
        String ticketNum;
        if(typeOfTrip == TripType.ONE_WAY) {
            ticketNum = "11";
            if(bookingClass == BookingClass.FIRST){
                ticketNum = ticketNum + "F" + getRandomString(4);
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true; 
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + getRandomString(4);
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + getRandomString(4);
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            }
        } else {
            ticketNum = "22";
            if(bookingClass == BookingClass.FIRST){
                ticketNum = ticketNum + "F" + getRandomString(4);
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.BUSINESS) {
                ticketNum = ticketNum + "B" + getRandomString(4);
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                    //flag1 = true;
                }
            } else if(bookingClass == BookingClass.ECONOMY) {
                ticketNum = ticketNum + "E" + getRandomString(4);
                if(sourceOfTrip == TripSource.PARIS || destinationOfTrip == TripDestination. PARIS) {
                    ticketNum = ticketNum + "INT";
                   // flag1 = true;
                } else if((sourceOfTrip == TripSource.OULU &&  destinationOfTrip == TripDestination.HELSINKI) || (sourceOfTrip == TripSource.HELSINKI &&  destinationOfTrip == TripDestination.OULU)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else if((sourceOfTrip == TripSource.NANJING || sourceOfTrip == TripSource.BEIJING || sourceOfTrip == TripSource.SHANGHAI) && (destinationOfTrip == TripDestination.NANJING || destinationOfTrip == TripDestination.BEIJING || destinationOfTrip == TripDestination.SHANGHAI)) {
                    ticketNum = ticketNum + "DOM";
                    //flag1 = false;
                } else {
                    ticketNum = ticketNum + "INT";
                   // flag1 = true;
                }
            }
        }

        ticketNumbers[index] = ticketNum;
    }



    //toStrings

    //Below from exercise 3
    
    /*public String toString() {
        return "Dear " + passengerFullName + ". Thank you for booking your flight with " + 
        flightCompany  + ". Following are the details of your booking and the trip:" + "\n" + 
        "Ticket Number: " + ticketNumber + "\n" + 
        "From " + tripSource + " to " + tripDestination + "\n" +
        "Date of departure: " + departureDate + "\n" +
        "Date of return: " + returnDate + "\n" +
        "Total passengers: " + getTotalPassengers() + "\n" +
        "Total ticket price in Euros: " + getTotalTicketPrice();
    }*/

    /*public String StringOption1(int size) {
        if(flag1 == 1 || flag1 == 2) {
            return "Thank you for booking your flight with " + getFlightCompany() + ". Following are the details of your bookingand the trip:\n\n" + 
            "Ticket Number: " + ticketNumber + "\n" + 
            "Passenger Name: " + passengerFullName + "\n" +
            "From " + sourceOfTrip + "\n" + 
            "To " + destinationOfTrip + "\n" +
            "Date of departure: " + departureDate + "\n" +
            "Date of return: " + returnDate + " (Changed from old " + returnDate.minusDays(flag1) +  " to new " + returnDate +  ")" + "\n" + 
            "Total ticket price in Euros: " + totalTicketPrice + "\n\n" + 
            "IMPORTANT NOTICE: As per our policy, the returnDate was changed because it was less than two days apart from your departure date.";
        } else {
            return "Thank you for booking your flight with " + getFlightCompany() + ". Following are the details of your bookingand the trip:\n\n" + 
            "Ticket Number: " + ticketNumber + "\n" + 
            "Passenger Name: " + passengerFullName + "\n" +
            "From " + sourceOfTrip + " to " + destinationOfTrip + "\n" +
            "Date of departure: " + departureDate + "\n" +
            "Date of return: " + returnDate + "\n" + 
            "Total ticket price in Euros: " + totalTicketPrice + "\n";
        }  
    }*/

    public String StringOption2(int i) {
        if(flag1 == 1 || flag1 == 2) {
            return "Ticket Number: " + ticketNumber + "\n" + 
            "Passenger's Name: " + passengerFullNames[i] + "\n" +
            "Passenger's Age: " + passengerAges[i] + "\n" +
            "From " + sourceOfTrip + " ("  + airportOfSource + ")" + "\n" + 
            "To " + destinationOfTrip + " ("  + airportOfDestination + ")" + "\n" +
            "The flight departs on " + departureDate + "\n" +
            "And the return flight is on: " + returnDate + " (Changed from old " + returnDate.minusDays(flag1) +  " to new " + returnDate +  ")" + "\n";
        
        } else {
            return ". Following are the details of your bookingand the trip:\n\n" + 
            "Ticket Number: " + ticketNumbers[i] + "\n" + 
            "Passenger Name: " + passengerFullNames[i] + "\n" +
            "Passenger's Age: " + passengerAges[i] + "\n" +
            "From " + sourceOfTrip + " ("  + airportOfSource + ")" + "\n" + 
            "To " + destinationOfTrip + " ("  + airportOfDestination + ")" + "\n" +
            "The flight departs on " + departureDate + "\n" +
            "And the return flight is on: " + returnDate + "\n";
        }  
    }

    public void reserveTicket() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your full name: ");
        String passengerFullName = input.nextLine();
        System.out.println("Please enter the number of the ticket you want to book: ");
        int size = input.nextInt();
        input.nextLine();
        System.out.println("Please enter how many children tickets do you need: ");
        int childPassengers = input.nextInt();
        System.out.println("Please enter how many adult tickets do you need: ");
        int adultPassengers = input.nextInt();
        input.nextLine();
        System.out.println("Please enter the source of your trip: ");
        String  tripSource = input.nextLine();
        System.out.println("Please enter the destination of your trip: ");
        String  tripDestination = input.nextLine();
        System.out.println("Please enter the type of your trip: ");
        String tripType = input.nextLine();
        System.out.println("Please enter the srcAirport of your trip: ");
        String srcAirport = input.nextLine();
        System.out.println("Please enter the desAirport of your trip: ");
        String desAirport = input.nextLine();
        System.out.println("Please enter the type of your class: ");
        String classType = input.nextLine();
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
            
        input.nextLine();
        LocalDate departureDate =  LocalDate.of(dYear, dMonth, dDay);
        LocalDate returnDate =  LocalDate.of(rYear, rMonth, rDay);
            
        for(int i = 0; i < size; i ++) {
            System.out.println("Please enter passenger' full name: ");
            String passengersFullName = input.nextLine();
            System.out.println("Please enter the gender of the passenger: ");
            String gender = input.nextLine();
            System.out.println("Please enter the age of the passenger: ");
            int age = input.nextInt();
            input.nextLine();
            
            setPassengerFullName(i,passengersFullName);
            setPassengerGender(i, gender);
            setPassengerAge(i, age);
            setTripSource(tripSource);
            setSourceAirport(srcAirport);

            setTripDestination(tripSource, tripDestination);
            setDestinationAirport(srcAirport, desAirport);

            setTripType(tripType);

            setBookingClass(classType);
            setTicketNumber(i);
        }
        setDepartureDate(departureDate);
        setReturnDate(returnDate);
        setDepartingTicketPrice(childPassengers, adultPassengers);
        setReturnTicketPrice();
        setTotalTicketPrice();
        System.out.println("Thank you for booking your flight with " + getFlightCompany() + "\n" +
        "You reserved a total of " +  size + " tickets." + "\n");

        for(int i = 0; i < size; i++) {
            System.out.format("Here are the trip details for Passenger No.%d \n", i + 1);
            System.out.println(StringOption2(i));
           
        }

        System.out.println("Total ticket price is: " + totalTicketPrice + "\n\n");

        if(flag1 == 1 || flag1 == 2) {
            System.out.println("IMPORTANT NOTICE: As per our policy, the returnDate was changed because it was less than two days apart from your departure date." + "\n");
        }
        input.close();
        
    }

    

}
