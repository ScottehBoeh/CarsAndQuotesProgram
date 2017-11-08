package common.enums;

import common.objects.ContactDetails;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public enum EnumCarInsuranceCompany {

    CHURCHILL("Churchill",
            new ContactDetails(
                    "Churchill UK Insurance Limited",
                    "motor.customer.service@ churchill.com",
                    "The Wharf, Little Neville St, Leeds LS1 4AZ",
                    "0800 032 4829"
            ));

    /**
     * Insurance Company Name
     */
    private String insuranceCompanyName;
    /**
     * Insurance Company Contact Details
     */
    private ContactDetails insuranceCompanyContactDetails;

    /**
     * Default Enum Car Insurance Company Constructor
     *
     * @param givenInsuranceCompanyName           - Given Insurance Company Name
     * @param givenInsuranceCompanyContactDetails - Given Insurance Company Contact Details
     */
    EnumCarInsuranceCompany(String givenInsuranceCompanyName, ContactDetails givenInsuranceCompanyContactDetails) {
        this.insuranceCompanyName = givenInsuranceCompanyName;
        this.insuranceCompanyContactDetails = givenInsuranceCompanyContactDetails;
    }

    /**
     * From String - Get a Car Insurance Company Enum from a given String
     *
     * @param givenString - Given Car Insurance Company as String
     * @return - Returned Car Insurance Company as Enum from String (EnumCarInsuranceCompany)
     */
    public static EnumCarInsuranceCompany fromString(String givenString) {

        /** For each EnumCarInsuranceCompany */
        for (EnumCarInsuranceCompany model : values()) {

            System.out.println(model.getInsuranceCompanyName() + "/" + givenString);
            /** If the Car Insurance Company as String equals the given User Input */
            if (model.getInsuranceCompanyName().toLowerCase().equals(givenString.toLowerCase())) {
                return model;
            }

        }

        return null;

    }

    /**
     * Get Contact Details - Get the Contact Details of the Insurance Company
     *
     * @return - Given Contact Details (ContactDetails)
     */
    public ContactDetails getContactDetails() {
        return this.insuranceCompanyContactDetails;
    }

    /**
     * Get Insurance Company Name - Get the Name of the Insurance Company
     *
     * @return - Given Insurance Company Name (String)
     */
    public String getInsuranceCompanyName() {
        return this.insuranceCompanyName;
    }

}
