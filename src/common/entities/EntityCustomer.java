package common.entities;

import common.objects.ContactDetails;
import common.objects.Passport;

import java.util.UUID;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class EntityCustomer {

    /**
     * Customer Unique Identifier
     */
    private UUID customerUUID = UUID.randomUUID();
    /**
     * Contact Details
     */
    private ContactDetails contactDetails;
    /**
     * Customer Passport
     */
    private Passport customerPassport;

    /**
     * Default EntityCustomer Constructor
     */
    public EntityCustomer(ContactDetails givenContactDetails) {
        this.contactDetails = givenContactDetails;
        this.customerPassport = new Passport();
    }

    /**
     * Get Customer UUID - Get the Unique Identifier of the Customer
     *
     * @return - Unique Identifier (String)
     */
    public UUID getCustomerUUID() {
        return this.customerUUID;
    }

    /**
     * Get Contact Details - Get the Customer Contact Details
     *
     * @return - Contact Details (ContactDetails)
     */
    public ContactDetails getContactDetails() {
        return this.contactDetails;
    }

    /**
     * Get Customer Passport - Get the Customers Passport
     *
     * @return - Given Passport (Passport)
     */
    public Passport getCustomerPassport() {
        return this.customerPassport;
    }

}
