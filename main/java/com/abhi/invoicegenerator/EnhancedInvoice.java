package com.abhi.invoicegenerator;

/**
 * EnhancedInvoice -- Defining properties of invoice of rides fare
 *                    & methods to get & set properties
 *
 * @author Abhishek Shigavan
 */
public class EnhancedInvoice {
    //defining properties of invoice
    public int totalNoOfRides;
    public double totalFare;
    public double avgFarePerRide;

    public EnhancedInvoice() {
    }

    public EnhancedInvoice(int totalNoOfRides, double totalFare, double avgFarePerRide) {
        this.totalNoOfRides = totalNoOfRides;
        this.totalFare = totalFare;
        this.avgFarePerRide = avgFarePerRide;
    }

    public int getTotalNoOfRides() {
        return totalNoOfRides;
    }

    public void setTotalNoOfRides(int totalNoOfRides) {
        this.totalNoOfRides = totalNoOfRides;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getAvgFarePerRide() {
        return avgFarePerRide;
    }

    public void setAvgFarePerRide(double avgFarePerRide) {
        this.avgFarePerRide = avgFarePerRide;
    }
}
