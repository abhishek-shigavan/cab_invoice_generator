package com.abhi.invoicegenerator;

import java.util.List;
/**
 * InvoiceGenerator --  Cab Invoice Generator
 *                      i) Computing Single as well as multiple Ride Fare
 *                      ii) Generating Fare Invoice
 *                      iii) Storing UserId along with its all invoices
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

    /**
     * This method checks if the given array empty / not
     * If not empty then computes total fare, avg fare per ride, total ride
     * & assign this values as invoice properties & returns invoice object
     *
     * @param rideArray - Array containing multiple rides data
     * @return invoice - Object of EnhancedInvoice containing properties of invoice
     */
    public EnhancedInvoice getEnhancedInvoice(Ride[] rideArray) {
        //checking rideArray is not empty
        boolean isRidePresent = rideArray != null;
        EnhancedInvoice invoice = new EnhancedInvoice();
        if(isRidePresent){
            int totalNoOfRides = rideArray.length;
            double totalFare = calculateFare(rideArray);
            double avgFarePerRide = totalFare / totalNoOfRides;
            invoice.setTotalNoOfRides(totalNoOfRides);
            invoice.setTotalFare(totalFare);
            invoice.setAvgFarePerRide(avgFarePerRide);
        }
        else{
            System.out.println("No ride to compute fare");
        }
        return invoice;
    }

    /**
     * This method checks if the given userId is present in ride repository
     * If present then returns ride list of userId
     * else prints the message
     *
     * @param userId  - Id of user
     * @return userRidesList -- list of rides of given userId
     */
    public List<EnhancedInvoice> getListOfRidesByUserId(int userId) {
        RideRepository rideRepository = new RideRepository();
        boolean isUserIdPresent = RideRepository.userRideRepository.containsKey(userId);
        if(isUserIdPresent){
            List<EnhancedInvoice> userRidesList = rideRepository.getUserRidesList(userId);
            return userRidesList;
        }
        else{
            System.out.println("No Such UserId Present In UserRidesRepository");
        }
        return null;
    }
}
