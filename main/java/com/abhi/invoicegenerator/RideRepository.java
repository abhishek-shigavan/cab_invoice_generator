package com.abhi.invoicegenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * RideRepository -- Defining methods to store userId along with its rides
 *                   & to get rides list through userId
 *
 * @author Abhishek Shigavan
 */
public class RideRepository {
    //storing userId & its rides data
    static HashMap<Integer, List<EnhancedInvoice>> userRideRepository = new HashMap<>();
    /**
     * This method checks given userId is present in ride repository / not
     * If present then get its associated ride list & returns it
     * else return empty list
     *
     * @param usersId -- Id of user
     * @return ridesList -- If userId present then existing list
     *                      Else empty list
     */
    public List<EnhancedInvoice> getUserRidesList(int usersId) {
        List<EnhancedInvoice> ridesList = new ArrayList<>();
        boolean isUserIdPresent = userRideRepository.containsKey(usersId);
        //checking userId is already present / not
        if(isUserIdPresent){
            //getting existing list
            ridesList = userRideRepository.get(usersId);
            return ridesList;
        }
        return ridesList;
    }
    /**
     * This method passes the ride data to get invoice & stores this invoice
     * into users rides list & stores this list along with userId in ride repository
     * (i.e userRideRepository)
     *
     * @param userId  -- Id of user
     * @param ridesOfUserId  -- array of rides data of user
     */
    public void addUserToRideRepository(int userId, Ride[] ridesOfUserId) {
        InvoiceGenerator invoice = new InvoiceGenerator();
        List<EnhancedInvoice> userRideList = getUserRidesList(userId);
        EnhancedInvoice allRidesDetails = invoice.getEnhancedInvoice(ridesOfUserId);
        userRideList.add(allRidesDetails);
        userRideRepository.put(userId, userRideList);
    }
}
