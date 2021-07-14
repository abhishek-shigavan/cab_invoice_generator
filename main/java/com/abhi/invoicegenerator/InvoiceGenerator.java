package com.abhi.invoicegenerator;

/**
 * InvoiceGenerator --  Calculating Fare of Ride
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
}
