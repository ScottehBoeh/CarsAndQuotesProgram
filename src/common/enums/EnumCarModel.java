package common.enums;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public enum EnumCarModel {

    CITROEN_SPACETOURER("Spacetourer", EnumCarManufacturer.CITROEN),
    VOLKSWAGEN_GTI_GOLF("GTI Golf", EnumCarManufacturer.VOLKSWAGEN);

    /**
     * Car Model Name
     */
    private String carModelName;
    /**
     * Car Manufacturer
     */
    private EnumCarManufacturer carModelManufacturer;

    /**
     * Default Enum Car Model Constructor
     *
     * @param givenCarModelName    - Given Name of Model
     * @param givenCarManufacturer - Given Manufacturer of Model
     */
    EnumCarModel(String givenCarModelName, EnumCarManufacturer givenCarManufacturer) {
        this.carModelManufacturer = givenCarManufacturer;
        this.carModelName = givenCarModelName;
    }

    /**
     * From String - Get a Car Model Enum from a given String
     *
     * @param givenString - Given Car Model as String
     * @return - Returned Car Model as Enum from String (EnumCarModel)
     */
    public static EnumCarModel fromString(String givenString) {

        /** For each EnumCarModel */
        for (EnumCarModel model : values()) {

            System.out.println(model.getModelName() + "/" + givenString);
            /** If the Car Model as String equals the given User Input */
            if (model.getModelName().toLowerCase().equals(givenString.toLowerCase())) {
                return model;
            }

        }

        return null;

    }

    /**
     * Get Car Manufacturer - Get the Manufacturer of the Car
     *
     * @return - The Manufacturer of the Car (EnumCarManufacturer)
     */
    public EnumCarManufacturer getCarManufacturer() {
        return this.carModelManufacturer;
    }

    /**
     * Get Model Name - Get the Name of the Model
     *
     * @return - The Model Name (String)
     */
    public String getModelName() {
        return this.carModelName;
    }

}