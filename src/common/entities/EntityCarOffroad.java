package common.entities;

import common.enums.EnumCarModel;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class EntityCarOffroad extends EntityCar {

    /**
     * Number of Gears in Car
     */
    private int numberOfGears;

    /**
     * Default Constructor of Off-road Car
     */
    public EntityCarOffroad(EnumCarModel givenCarModel) {
        super(givenCarModel);
    }

    /**
     * Get Number of Gears - Get the Number of Gears in the Off-road
     *
     * @return - Returns the Number of Gears (int)
     */
    public int getNumberOfGears() {
        return this.numberOfGears;
    }

    /**
     * Set Number of Gears - Set the Number of Gears in the Off-road
     *
     * @param givenGearsCount - Given Gears Count (int)
     */
    public void setNumberOfGears(int givenGearsCount) {
        this.numberOfGears = givenGearsCount;
    }

    /**
     * Get Max Hill Ratio - Get the Maximum Ratio of a Hill that the
     * Off-road can Manage
     *
     * @return - Returns Max Hill Ratio (double)
     */
    public double getMaxHillRatio() {
        return (this.getCarEngineSize() / 100 / this.getNumberOfGears());
    }

    /**
     * Print Information based on Quotation
     */
    @Override
    public void printInfo() {
        super.printInfo();

        System.out.println(
                "\n- Car Gear Count: " + getNumberOfGears()
                        + "\n- Car Max Hill Ratio: " + getMaxHillRatio()
        );

    }

}
