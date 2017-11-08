package common.enums;

import common.objects.ContactDetails;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public enum EnumCarManufacturer {

    CITROEN("Citroën",
            new ContactDetails(
                    "Citroën Marketing Staff",
                    "marketing@citroenconnect.co.uk",
                    "Pinley House, 2 Sunbeam Way, Coventry, CV3 1ND",
                    "0845 086 7070"
            )),

    VOLKSWAGEN("Volkswagen",
            new ContactDetails(
                    "Citroën Marketing Staff",
                    "paul.willis@volkswagen.co.uk",
                    "Caxton Place, Mitchelston Industrial Estate, Kirkcaldy",
                    "0800 0833 914"
            ));

    /**
     * Manufacturer Name
     */
    private String manufacturerName;
    /**
     * Manufacturer Contact Details
     */
    private ContactDetails manufacturerContactDetails;

    /**
     * Default Enum Car Manufacturer Constructor
     *
     * @param givenManufacturerName - Given Manufacturer Name
     * @param givenContactDetails   - Given Manufacturer Contact Details
     */
    EnumCarManufacturer(String givenManufacturerName, ContactDetails givenContactDetails) {
        this.manufacturerName = givenManufacturerName;
        this.manufacturerContactDetails = givenContactDetails;
    }

    /**
     * Get Contact Details - Get the Contact Details of the Manufacturer
     *
     * @return - Given Contact Details (ContactDetails)
     */
    public ContactDetails getContactDetails() {
        return this.manufacturerContactDetails;
    }

    /**
     * Get Manufacturer Name - Get the Name of the Manufacturer
     *
     * @return - Given Manufacturer Name (String)
     */
    public String getManufacturerName() {
        return this.manufacturerName;
    }

}
