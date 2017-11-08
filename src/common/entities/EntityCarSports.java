package common.entities;

import common.enums.EnumCarModel;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class EntityCarSports extends EntityCar {

    /**
     * Sports Car Horse-power
     */
    private long sportsCarBrakeHorsePower;
    /**
     * Sports Car 0-60 Time
     */
    private double sportsCarTimeTo60;

    /**
     * Default Constructor for Sports Car
     */
    public EntityCarSports(EnumCarModel givenCarModel) {
        super(givenCarModel);
    }

    /**
     * Set Sports Car Brake Horse Power - Set the Brake Horse Power
     * of the Sports Car
     *
     * @param givenBrakeHorsePower - Given Brake Horse Power (long)
     */
    public void setSportsCarBrakeHorsePower(long givenBrakeHorsePower) {
        this.sportsCarBrakeHorsePower = givenBrakeHorsePower;
    }

    /**
     * Set Sports Car Time to 60 - Set the time it takes for the
     * Sports Car to reach 60MPH from 0
     *
     * @param givenTimeTo60 - Given Time (double)
     */
    public void setSportsCarTimeTo60(double givenTimeTo60) {
        this.sportsCarTimeTo60 = givenTimeTo60;
    }

    /**
     * Get Brake Horse Power - Get the Brake Horse Power of the
     * Sports Car
     *
     * @return - Given Brake Horse Power (long)
     */
    public long getBrakeHorsePower() {
        return this.sportsCarBrakeHorsePower;
    }

    /**
     * Get Time to 60 - Get the Time that it takes for the Sports
     * Car to reach 60MPH from 0
     *
     * @return - Given Time (double)
     */
    public double getTimeTo60() {
        return this.sportsCarTimeTo60;
    }

    /**
     * Get Torque - Get the Sports Car Torque
     *
     * @return - Given Torque (double)
     */
    public double getTorque() {
        return ((getBrakeHorsePower() / getTimeTo60()) + 9.55);
    }

    /**
     * Print Information based on Quotation
     */
    @Override
    public void printInfo() {
        super.printInfo();

        System.out.println(

                "\n- Time from 0-60: " + getTimeTo60()
                        + "\n- Brake Horse Power: " + getBrakeHorsePower()
                        + "\n Car Torque: " + getTorque()

        );

    }

}
