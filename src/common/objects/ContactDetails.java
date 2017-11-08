package common.objects;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class ContactDetails {

    /**
     * Contact Name
     */
    private String contactName;
    /**
     * Contact Email Address
     */
    private String contactEmail;
    /**
     * Contact Address
     */
    private String contactAddress;
    /**
     * Contact Phone Number
     */
    private String contactPhoneNumber;

    public ContactDetails(String givenName, String givenEmail, String givenAddress, String givenPhoneNumber) {
        this.contactName = givenName;
        this.contactEmail = givenEmail;
        this.contactAddress = givenAddress;
        this.contactPhoneNumber = givenPhoneNumber;
    }

    /**
     * Get Contact Name - Get the Name of the Contact
     *
     * @return - Name (String)
     */
    public String getContactName() {
        return this.contactName;
    }

    /**
     * Set Contact Name - Set the Name of the Contact
     *
     * @param givenName - Given Contact Name (String)
     */
    public void setContactName(String givenName) {
        this.contactName = givenName;
    }

    /**
     * Get Contact Email - Get the Email of the Contact
     *
     * @return - Email (String)
     */
    public String getContactEmail() {
        return this.contactEmail;
    }

    /**
     * Set Contact Email - Set the Email of the Contact
     *
     * @param givenEmail - Given Contact Email (String)
     */
    public void setContactEmail(String givenEmail) {
        this.contactEmail = givenEmail;
    }

    /**
     * Get Contact Address - Get the Address of the Contact
     *
     * @return - Address (String)
     */
    public String getContactAddress() {
        return this.contactAddress;
    }

    /**
     * Set Contact Address - Set the Address of the Contact
     *
     * @param givenAddress - Given Contact Address (String)
     */
    public void setContactAddress(String givenAddress) {
        this.contactAddress = givenAddress;
    }

    /**
     * Get Contact Phone Number - Get the Phone Number of the Contact
     *
     * @return - Phone Number (String)
     */
    public String getContactPhoneNumber() {
        return this.contactPhoneNumber;
    }

    /**
     * Set Contact Phone Number - Set the Phone Number of the Contact
     *
     * @param givenPhoneNumber - Given Contact Phone Number (String)
     */
    public void setContactPhoneNumber(String givenPhoneNumber) {
        this.contactPhoneNumber = givenPhoneNumber;
    }

}
