package common.objects;

import common.entities.EntityCar;
import common.entities.EntityCustomer;

import java.util.UUID;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class Quotation {

    /**
     * Quote Unique Identifier
     */
    private UUID quoteUUID = UUID.randomUUID();
    /**
     * Quote Car
     */
    private EntityCar quoteCar;
    /**
     * Quote Customer
     */
    private EntityCustomer quoteCustomer;
    /**
     * Quote Insurance
     */
    private CarInsurance quoteInsurance;
    /**
     * Quote Payment Metod
     */
    private PaymentMethod quotePaymentMethod;
    /**
     * Days for Quotation
     */
    private int daysAmount;

    /**
     * Default Quotation Constructor
     */
    public Quotation(EntityCar givenCar, EntityCustomer givenCustomer, CarInsurance givenInsurance, PaymentMethod givenPaymentMethod, int givenDays) {

        this.quoteCar = givenCar;
        this.quoteCustomer = givenCustomer;
        this.quoteInsurance = givenInsurance;
        this.quotePaymentMethod = givenPaymentMethod;
        this.daysAmount = givenDays;

    }

    /**
     * Get Quote UUID - Get the Unique Identifier for the Quote
     *
     * @return - Given Quote (UUID)
     */
    public UUID getQuoteUUID() {
        return this.quoteUUID;
    }

    /**
     * Get Quote Car - Get the Car related to the Quote
     *
     * @return - The Car (EntityCar)
     */
    public EntityCar getQuoteCar() {
        return this.quoteCar;
    }

    /**
     * Get Quote Customer - Get the Customer related to the Quote
     *
     * @return - The Customer (EntityCustomer)
     */
    public EntityCustomer getQuoteCustomer() {
        return this.quoteCustomer;
    }

    /**
     * Get Quote Insurance - Get the Insurance of the Quote
     *
     * @return - Given Insurance (CarInsurance)
     */
    public CarInsurance getQuoteInsurance() {
        return this.quoteInsurance;
    }

    /**
     * Get Quote Payment Method - Get the Payment Method of the Quote
     *
     * @return - Given Payment Method (PaymentMethod)
     */
    public PaymentMethod getQuotePaymentMethod() {
        return this.quotePaymentMethod;
    }

    /**
     * Get Days Amount - Get the count of days in which the quota exists
     *
     * @return - Days Left (int)
     */
    public int getDaysAmount() {
        return this.daysAmount;
    }

    /**
     * Set Days Amount - Set the ammount of days in which the
     * quote exists
     *
     * @param givenDays - Given Days (int)
     */
    public void setDaysAmount(int givenDays) {
        this.daysAmount = givenDays;
    }

    /**
     * Print Information based on Quotation
     */
    public void printInfo() {

        System.out.println("=======================================================");

        System.out.println(

                "Quote ID: " + this.getQuoteUUID().toString()
                        + "\n- Customer Name: " + this.getQuoteCustomer().getContactDetails().getContactName()
                        + "\n- Customer Email: " + this.getQuoteCustomer().getContactDetails().getContactEmail()
                        + "\n- Customer Address: " + this.getQuoteCustomer().getContactDetails().getContactAddress()
                        + "\n- Customer Phone: " + this.getQuoteCustomer().getContactDetails().getContactPhoneNumber()
                        + "\n- Vehicle Name: " + this.getQuoteCar().getCarModel().getModelName()
                        + "\n- Vehicle Manufacturer: " + this.getQuoteCar().getCarModel().getCarManufacturer().getManufacturerName()
                        + "\n- Vehicle Cost (Per Day): £" + this.getQuoteCar().getCarCostPerDay()

        );

        /** IF the Quotation comes with insurance, print it to Console */
        if (this.getQuoteInsurance() != null) {

            System.out.println(

                    "Quote Insurance Information: " + this.getQuoteUUID().toString()
                            + "\n- Insurance Company Name: " + this.getQuoteInsurance().getInsuranceCompany().getInsuranceCompanyName()
                            + "\n- Insurance Cost (Monthly): " + this.getQuoteInsurance().getInsuranceCost()

            );

        }

    }

}
