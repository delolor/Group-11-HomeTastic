/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hometastic;

/**
 *
 * @author user
 */
class Booking {
    
    private int bookingID;
    private String userID;
    private int propertyID;
    private String paymentID;
    private String fromDate;
    private String toDate;
    private int numDays;
    private String status;
    private int guestNum;
    private String bookDate;
    
    Booking(int bookingID, String userID, int propertyID, String paymentID, 
            String fromDate, String toDate, int numDays, String status, int guestNum, String bookDate){
        this.bookingID=bookingID;
        this.userID=userID;
        this.propertyID=propertyID;
        this.paymentID=paymentID;
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.numDays=numDays;
        this.status=status;
        this.guestNum=guestNum;
        this.bookDate=bookDate;
    }
    
    Booking(int bookingID, String fromDate, String toDate, int numDays, int guestNum, String bookDate){
        this.bookingID=bookingID;
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.numDays=numDays;
        this.guestNum=guestNum;
        this.bookDate=bookDate;
    }
    
    public void setBookingID(int bookingID){this.bookingID=bookingID;}
    int getBookingID(){return bookingID;}
    String getFromDate(){return fromDate;}
    String getToDate(){return toDate;}
    int getNumDays(){return numDays;}
    String getStatus(){return status;}
    int getGuestNum(){return guestNum;}
    String getBookDate(){return bookDate;}
    
}
