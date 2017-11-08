package common.entities;

import common.enums.EnumCarManufacturer;
import common.enums.EnumCarModel;

import java.util.UUID;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class EntityCar {

    /**
     * Car Unique Identifier
     */
    private UUID carUUID = UUID.randomUUID();
    /**
     * Car Model
     */
    private EnumCarModel carModel;
    /**
     * Car Engine Size
     */
    private long carEngineSize;
    /**
     * Car Cost per Day
     */
    private double carCostPerDay;

    public EntityCar(EnumCarModel givenCarModel) {

        this.carModel = givenCarModel;

    }

    /**
     * Set Cost per Day - Set the Cost of the Car per-Day
     *
     * @param givenCostPerDay - Given Cost per-Day (double)
     */
    public void setCostPerDay(double givenCostPerDay) {
        this.carCostPerDay = givenCostPerDay;
    }

    /**
     * Get Car UUID - Get the Unique Identifier of the Car
     *
     * @return - Given Car UUID (UUID)
     */
    public UUID getCarUUID() {
        return this.carUUID;
    }

    /**
     * Get Car Manufacturer - Get the Manufacturer of the Car
     *
     * @return - Car Manufacturer (Manufacturer)
     */
    public EnumCarManufacturer getCarManufacturer() {
        return this.carModel.getCarManufacturer();
    }

    /**
     * Get Car Model - Get the Model of the Car
     *
     * @return - Car Model (EnumCarModel)
     */
    public EnumCarModel getCarModel() {
        return this.carModel;
    }

    /**
     * Set Car Model - Set the Model of the Car
     *
     * @param givenCarModel - Given Car Model (EnumCarModel)
     */
    public void setCarModel(EnumCarModel givenCarModel) {
        this.carModel = givenCarModel;
    }

    /**
     * Get Car Engine Size - Get the Size of the Car Engine
     *
     * @return - The Car Engine (int)
     */
    public long getCarEngineSize() {
        return this.carEngineSize;
    }

    /**
     * Set Car Engine Size - Set the Size of the Car Engine
     *
     * @param givenSize - Given Engine Size (long)
     */
    public void setCarEngineSize(long givenSize) {
        this.carEngineSize = givenSize;
    }

    /**
     * Get Car Cost per Day - Get the Cost of te Car per-Day
     *
     * @return - The Car Cost per Day (double)
     */
    public double getCarCostPerDay() {
        return this.carCostPerDay;
    }


    /**
     * Print Information based on Quotation
     */
    public void printInfo() {

        System.out.println("=======================================================");

        System.out.println(

                "Car ID: " + this.getCarUUID().toString()
                        + "\n- Car Model: " + getCarModel()
                        + "\n- Car Manufacturer: " + getCarManufacturer()
                        + "\n- Car Cost (Per Day): £" + getCarCostPerDay()
                        + "\n- Car Engine Size: " + getCarEngineSize()

        );

    }

}
