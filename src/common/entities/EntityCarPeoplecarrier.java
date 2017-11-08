package common.entities;

import common.enums.EnumCarModel;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class EntityCarPeoplecarrier extends EntityCar {

    /**
     * Max Capacity in Peoples Carrier
     */
    public int maxCapacity;
    /**
     * Tax Benefit Percentage
     */
    public int taxBenefitPercent;

    /**
     * Default Entity Car People Carrier Constructor
     */
    public EntityCarPeoplecarrier(EnumCarModel givenCarModel) {
        super(givenCarModel);
    }

    /**
     * Get Max Capacity
     *
     * @return - Max Capacity of people carrier (int)
     */
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    /**
     * Set Max Capacity - Set the Maximum Capacity of the People Carrier
     *
     * @param givenCapacity - Given Max Capacity
     */
    public void setMaxCapacity(int givenCapacity) {
        this.maxCapacity = givenCapacity;
    }

    /**
     * Get Tax Benefit Percentage - Get the Tax Benefit Percentage
     *
     * @return - Tax Benefit Percentage (int)
     */
    public int getTaxBenefitPercent() {
        return this.taxBenefitPercent;
    }

    /**
     * Set Tax Benefit Percent - Set the percentage of tax benefit
     *
     * @param givenPercentage - Given tax benefit percentage
     */
    public void setTaxBenefitPercent(int givenPercentage) {
        this.taxBenefitPercent = givenPercentage;
    }

    /**
     * Print Information based on Quotation
     */
    @Override
    public void printInfo() {
        super.printInfo();

        System.out.println(

                "\n- Tax Benefit Percent: %" + getTaxBenefitPercent()
                        + "\n- Max Capacity: " + getMaxCapacity()

        );

    }

}
