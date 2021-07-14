package com.abhi.invoicetest;

import com.abhi.invoicegenerator.InvoiceGenerator;
import com.abhi.invoicegenerator.Ride;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
/**
 * TU_InvoiceGenerator  --  Defining Test Cases for all operations performed
 *
 * @author Abhishek Shigavan
 */
public class TU_InvoiceGenerator {
    /**
     * This method passes distance & time values to calculate fare &
     * check the return fare matches with expected fare / not
     */
    @Test
    void whenDistanceAndTimeIsGiven_ShouldReturnCalculatedFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 5.0;
        int time = 10;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(60,fare,0.0);
    }
    /**
     * This method passes distance & time values in a way that calculated fare will
     * be less that MINIMUM FARE & check the return fare is MINIMUM FARE / not
     */
    @Test
    void whenCalculatedFareIsLessThanMinimumFare_ShouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(invoiceGenerator.MINIMUM_FARE, fare,0.0);
    }

    /**
     * This method passes array containing multiple ride data to get
     * the aggregate total fare of all rides & checks the fare return
     * by compute method matches with expected total fare / not
     */
    @Test
    void whenMultipleRidesAreGiven_ShouldReturnTotalFareOfAllRides() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        Ride[] rideArray = { new Ride(5.0,10),
                            new Ride(0.1,1)};
        double fare = invoiceGenerator.calculateFare(rideArray);
        Assert.assertEquals(65,fare,0.0);
    }
}
