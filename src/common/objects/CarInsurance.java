package common.objects;

import common.enums.EnumCarInsuranceCompany;

import java.util.UUID;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class CarInsurance {

    /**
     * Insurance UUID
     */
    private UUID insuranceUUID;
    /**
     * Car Insurance Company
     */
    private EnumCarInsuranceCompany insuranceCompany;
    /**
     * Insurance Cost
     */
    private double insuranceCost;

    /**
     * Default Car Insurance Constructor
     *
     * @param givenInsuranceCompany - Given Insurance Company
     * @param givenInsuranceCost    - Given Insurance Cost
     */
    public CarInsurance(EnumCarInsuranceCompany givenInsuranceCompany, double givenInsuranceCost) {
        this.insuranceCompany = givenInsuranceCompany;
        this.insuranceCost = givenInsuranceCost;
    }

    /**
     * Get Insurance UUID - Get the Unique Identifier of the Insurance
     *
     * @return - The Insurance Unique Identifier (UUID)
     */
    public UUID getInsuranceUUID() {
        return this.insuranceUUID;
    }

    /**
     * Get Insurance Company - Get the Insurance Company of the Insurance
     *
     * @return - The Insurance Company (EnumCarInsuranceCompany)
     */
    public EnumCarInsuranceCompany getInsuranceCompany() {
        return this.insuranceCompany;
    }

    /**
     * Get Insurance Cost - Get the Cost of Insurance
     *
     * @return - The Cost of Insurance (double)
     */
    public double getInsuranceCost() {
        return this.insuranceCost;
    }

}
