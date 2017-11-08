package common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.entities.EntityCar;
import common.entities.EntityCarOffroad;
import common.entities.EntityCarPeoplecarrier;
import common.entities.EntityCarSports;
import common.enums.EnumCarModel;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Scott L. Robertson on 03/11/2017.
 * <p>
 * Car Manager
 * This class is used to create new Car Instances, check if
 * a car is availabe, and save/load car information from Storage
 */
public class CarManager {

    /**
     * Get Cars Directory - Get the Directory in which all
     * cars are stored
     *
     * @return - Cars Directory (File)
     */
    public static File getCarDirectory() {
        return new File("cars/");
    }

    /**
     * Get Car as File - Get the Car as a File from Car ID
     *
     * @param givenCarID - Given Car ID
     * @return - Car File made using given Car ID (File)
     */
    public static File getCarAsFile(UUID givenCarID) {

        /** If the Car File does not exist */
        if (!getCarDirectory().exists()) {
            /** Create the Cars Directory */
            getCarDirectory().mkdir();
        }

        /** Cast car ID to file */
        return new File("cars/" + givenCarID.toString() + ".car");

    }

    /**
     * Get Car From ID (Get a Car Object from the given Car ID)
     *
     * @param givenCarID - Given Car ID (String)
     * @return - Car Object with affiliated ID (EntityCar)
     * @throws IOException - Null (Car doesn't exist)
     */
    public static EntityCar getCarFromID(UUID givenCarID) throws IOException {

        /** Cast car ID to file */
        File carFile = getCarAsFile(givenCarID);

        /** If the car file and object exist */
        if (carFile.exists() && doesCarExistWithID(givenCarID)) {

            /** Create new buff reader instance */
            BufferedReader br = new BufferedReader(new FileReader(carFile));
            /** Get car object from file name */
            EntityCar theCar = new Gson().fromJson(br, EntityCar.class);
            /** Close buff reader instance */
            br.close();

            return theCar;
        } else {
            return null;
        }

    }

    /**
     * Does Car Exist With ID - Does a Car exist with the given Car ID
     *
     * @param givenCarID - Given Car ID (String)
     * @return - True/False (Car Exists or Doesn't Exist)
     * @throws IOException
     */
    public static boolean doesCarExistWithID(UUID givenCarID) throws IOException {

        /** Cast car ID to file */
        File carFile = getCarAsFile(givenCarID);

        return carFile.exists() && carFile.length() > 0;

    }

    /**
     * Save Car - Save a Car Object as a file
     *
     * @param givenCar - Given Car Object (EntityCar)
     * @throws IOException - IOException (exception)
     */
    public static void saveCar(EntityCar givenCar) throws IOException {

        System.out.println("Attempting to save " + givenCar.getCarManufacturer().getManufacturerName() + " " + givenCar.getCarModel().getModelName() + "...");

        /** Check if the Cars already exists in storage */
        if (!doesCarExistWithID(givenCar.getCarUUID())) {

            /** Get Gson builder and Car Object */
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            if (!getCarAsFile(givenCar.getCarUUID()).exists()) {
                getCarAsFile(givenCar.getCarUUID()).createNewFile();
            }

            Writer writer = new FileWriter(getCarAsFile(givenCar.getCarUUID()));
            writer.write(gson.toJson(givenCar));
            writer.close();
            System.out.println("Car Saved Successfully!");

        } else {
            System.out.println("A car with the ID " + givenCar.getCarCostPerDay() + " already exists! Cannot create/overwrite!");
        }

    }

    /**
     * Get All Cars - Get an Array List of all stored Cars
     *
     * @return - Array List of Cars (ArrayList<EntityCar>)
     */
    public static ArrayList<EntityCar> getAllCarsAsList() throws IOException {

        /** Create new list of Cars (ArrayList) */
        ArrayList<EntityCar> carList = new ArrayList<>();

        /** For each file in Cars Directory */
        for (final File fileEntry : getCarDirectory().listFiles()) {
            /** If file in fileEntry list is not a directory */
            if (!fileEntry.isDirectory()) {
                /** Get file name without file extention */
                String fileName = fileEntry.getName().replace(".car", "");
                /** If a car exists with the given UUID from the File */
                if (doesCarExistWithID(UUID.fromString(fileName))) {
                    /** Add the Car from the given ID to the Car Array List */
                    carList.add(getCarFromID(UUID.fromString(fileName)));
                }
            }

        }

        return carList;

    }

    public static void beginNewCar(Scanner userInput) throws IOException {

        /** CAR MODEL */
        System.out.println("Please enter the Car Model from the following available models:"
                + "\n(Example Input: GTI Golf)");
        for (EnumCarModel models : EnumCarModel.values()) {
            System.out.println(models + " - '" + models.getModelName() + "'");
        }

        while (!userInput.hasNext()) ;

        EnumCarModel givenCarModel = EnumCarModel.fromString(userInput.next());
        System.out.println("You've chosen the Car Model " + givenCarModel.getModelName()
                + " from " + givenCarModel.getCarManufacturer().getManufacturerName());

        /** CAR TYPE */
        int carInput = 0;
        System.out.println("Please enter the Type of Vehicle from the following available types:"
                + "\n(Example Input: 2)"
                + "\n1 - Offroad Car"
                + "\n2 - People Carrier"
                + "\n3 - Sports Car");
        while (!userInput.hasNextInt()) ;
        carInput = userInput.nextInt();
        switch (carInput) {
            case 1:
                System.out.println("Setting car type to Offroad");
                EntityCarOffroad offroadCar = new EntityCarOffroad(givenCarModel);
                System.out.println("Please enter the Number of Gears on the Offroad:");
                while (!userInput.hasNextInt()) ;
                offroadCar.setNumberOfGears(userInput.nextInt());
                saveCar(offroadCar);
                break;
            case 2:
                System.out.println("Setting car type to People Carrier");
                EntityCarPeoplecarrier peopleCarrier = new EntityCarPeoplecarrier(givenCarModel);
                System.out.println("Please enter the Number of Seats on the People Carrier:");
                while (!userInput.hasNextInt()) ;
                peopleCarrier.setMaxCapacity(userInput.nextInt());
                saveCar(peopleCarrier);
                break;
            case 3:
                System.out.println("Setting car type to Sports Car");
                EntityCarSports sportsCar = new EntityCarSports(givenCarModel);
                System.out.println("Please enter the Sports Cars Time from 0-60:");
                while (!userInput.hasNextInt()) ;
                sportsCar.setSportsCarTimeTo60(userInput.nextInt());
                System.out.println("Please enter the Brake Horse Power of the Sports Car:");
                while (!userInput.hasNextInt()) ;
                sportsCar.setSportsCarBrakeHorsePower(userInput.nextInt());
                saveCar(sportsCar);
                break;
        }

    }


    /**
     * Delete Car - Delete an Existing Car
     *
     * @param userInput - Given User Input (Scanner)
     * @throws IOException - Handled Exception (IOException)
     */
    public static void deleteCar(Scanner userInput) throws IOException {

        /** Used to determine whether or not the program will loop prompt */
        boolean shouldAskAgain = true;

        /** While the Program should ask again, prompt the user for a Car UUID */
        while (shouldAskAgain) {
            System.out.println("Please enter the ID (UUID) of the Car that you wish to delete:");

            while (!userInput.hasNext()) ; /** Pause until user has entered an input */
            String givenUUID = userInput.next(); /** Cast given input to UUID as String */

            /** If a Car with the given UUID exists, delete it */
            if (doesCarExistWithID(UUID.fromString(givenUUID))) {
                shouldAskAgain = false;

                /** If the Car File Exists, delete the file */
                if (getCarAsFile(UUID.fromString(givenUUID)).exists()) {
                    getCarAsFile(UUID.fromString(givenUUID)).delete();
                    /** Inform the User that the Car was deleted successfully */
                    System.out.println(getCarAsFile(UUID.fromString(givenUUID)).getName() + " was deleted successfully!");
                    /** Else, inform the User that the Car File does not exist */
                } else {
                    System.out.println("The Car File does not exist! Cannot delete!");
                }

                /** Else, inform the user that the given input was wrong and repeat prompt */
            } else {
                System.out.println("No Cars exist with that UUID! (" + givenUUID + ")");
                shouldAskAgain = true;
            }
        }
    }

    /**
     * Display Car Info - Display Information about a Specific Car
     *
     * @param userInput - Given User Input (Scanner)
     * @throws IOException - Handled Exception (IOException)
     */
    public static void displayCarInfo(Scanner userInput) throws IOException {

        /** Used to determine whether or not the program will loop prompt */
        boolean shouldAskAgain = true;

        /** While the Program should ask again, prompt the user for a Car UUID */
        while (shouldAskAgain) {
            System.out.println("Please enter the ID (UUID) of the Car that you wish to display:");

            while (!userInput.hasNext()) ; /** Pause until user has entered an input */
            String givenUUID = userInput.next(); /** Cast given input to UUID as String */

            /** If a Car with the given UUID exists, get it's information */
            if (doesCarExistWithID(UUID.fromString(givenUUID))) {
                shouldAskAgain = false;

                /** If the Car File Exists, display its information */
                if (getCarAsFile(UUID.fromString(givenUUID)).exists()) {
                    getCarFromID(UUID.fromString(givenUUID)).printInfo();
                    /** Else, inform the User that the Car File does not exist */
                } else {
                    System.out.println("The Car File does not exist! Cannot display information!");
                }

                /** Else, inform the user that the given input was wrong and repeat prompt */
            } else {
                System.out.println("No Cars exist with that UUID! (" + givenUUID + ")");
                shouldAskAgain = true;
            }
        }
    }

}
