package com.abhi.invoicegenerator;

/**
 * InvoiceGenerator --  Computing Fare of Cab Ride
 *
 * @author Abhishek Shigavan
 */
public class InvoiceGenerator {
    public static final double MINIMUM_FARE = 5.0;
    public final double COST_PER_KILOMETER = 10.0;
    public final int COST_PER_MINUTE = 1;

    /**
     * This method computes ride fare by using distance & time values
     * & checks computed fare with defined minimum fare
     * If computed fare is less than minimum fare then it will return
     * minimum fare else return computed fare
     *
     * @param distance - distance of ride
     * @param time  - time taken to complete ride
     * @return totalFare - total fare of ride
     */
    public double calculateFare(double distance, int time) {
        double totalFare = 0.0;
        totalFare = distance * COST_PER_KILOMETER + time * COST_PER_MINUTE;
        if(totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }
    /**
     * This method takes array containing multiple rides data as a
     * input & fetches the values from array to compute fare
     * It will compute fare & every time keep adding it to total fare to
     * get aggregate fare of all rides & return the same
     *
     * @param rideArray - array containing multiple ride data
     * @return totalFare - aggregate total fare of all rides
     */
    public double calculateFare(Ride[] rideArray) {
        double totalFare = 0.0;
        for (Ride ride : rideArray) {
            double fare = ride.distance * COST_PER_KILOMETER + ride.time * COST_PER_MINUTE;
            //assuring fare less than minimum fare
            // will not be added to total fare
            if(fare < MINIMUM_FARE){
                fare = MINIMUM_FARE;
            }
            totalFare += fare;
        }
        return totalFare;
    }
}
