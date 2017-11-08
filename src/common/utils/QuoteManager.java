package common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.entities.EntityCustomer;
import common.enums.EnumCarInsuranceCompany;
import common.objects.CarInsurance;
import common.objects.ContactDetails;
import common.objects.PaymentMethod;
import common.objects.Quotation;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Scott L. Robertson on 03/11/2017.
 * <p>
 * Quote Manager
 * The Quote Manager is used to create, read and store all Quotes
 * created by the application. All quotes are stored as .quote files.
 * All methods are fairly well named so it shouldn't be hard to
 * understand what each method is used for.
 */
public class QuoteManager {

    /**
     * Get Quotes Directory - Get the Directory in which all
     * quotes are stored
     *
     * @return - Quotes Directory (File)
     */
    public static File getQuoteDirectory() {
        return new File("quotes/");
    }

    /**
     * Get Quote as File - Get the Quote as a File from Quote ID
     *
     * @param givenQuoteID - Given Quote ID
     * @return - Quote File made using given Quote ID (File)
     */
    public static File getQuoteAsFile(UUID givenQuoteID) {

        /** If the Quote File does not exist */
        if (!getQuoteDirectory().exists()) {
            /** Create the Quotes Directory */
            getQuoteDirectory().mkdir();
        }

        /** Cast quote ID to file */
        return new File("quotes/" + givenQuoteID.toString() + ".quote");

    }

    /**
     * Get Quote From ID (Get a Quotation Object from the given Quote ID)
     *
     * @param givenQuoteID - Given Quote ID (String)
     * @return - Quote Object with affiliated ID (Quotation)
     * @throws IOException - Null (Quote doesn't exist)
     */
    public static Quotation getQuoteFromID(UUID givenQuoteID) throws IOException {

        /** Cast quote ID to file */
        File quoteFile = getQuoteAsFile(givenQuoteID);

        /** If the quote file and object exist */
        if (quoteFile.exists() && doesQuoteExistWithID(givenQuoteID)) {

            /** Create new buff reader instance */
            BufferedReader br = new BufferedReader(new FileReader(quoteFile));
            /** Get quote object from file name */
            Quotation theQuote = new Gson().fromJson(br, Quotation.class);
            /** CLose buff reader instance */
            br.close();

            return theQuote;
        } else {
            return null;
        }

    }

    /**
     * Does Quote Exist With ID - Does a Quote exist with the given Quote ID
     *
     * @param givenQuoteID - Given Quote ID (String)
     * @return - True/False (Quote Exists or Doesn't Exist)
     * @throws IOException
     */
    public static boolean doesQuoteExistWithID(UUID givenQuoteID) throws IOException {

        /** Cast quote ID to file */
        File quoteFile = getQuoteAsFile(givenQuoteID);

        return quoteFile.exists() && quoteFile.length() > 0;

    }

    /**
     * Save Quote - Save a Quote Object as a file
     *
     * @param givenQuote - Given Quote Object (Quotation)
     * @throws IOException - IOException (exception)
     */
    public static void saveQuote(Quotation givenQuote) throws IOException {

        System.out.println("Saving quote " + givenQuote.getQuoteUUID() + "...");

        /** Check if the Quote already exists in storage */
        if (!doesQuoteExistWithID(givenQuote.getQuoteUUID())) {

            /** Get Gson builder and Car Object */
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            if (!getQuoteAsFile(givenQuote.getQuoteUUID()).exists()) {
                getQuoteAsFile(givenQuote.getQuoteUUID()).createNewFile();
            }

            /** Write the Quote Object to file */
            Writer writer = new FileWriter(getQuoteAsFile(givenQuote.getQuoteUUID()));
            writer.write(gson.toJson(givenQuote));
            writer.close();

        } else {
            System.out.println("A quote with the ID " + givenQuote.getQuoteUUID() + " already exists! Cannot create/overwrite!");
        }

        System.out.println("Quote saved Successfully!");

    }

    /**
     * Get All Quotes - Get an Array List of all stored Quotes
     *
     * @return - Array List of Quotes (ArrayList<Quotation>)
     */
    public static ArrayList<Quotation> getAllQuotesAsList() throws IOException {

        /** Create new list of Quotes (ArrayList) */
        ArrayList<Quotation> quoteList = new ArrayList<Quotation>();

        /** For each file in Quotes Directory */
        for (final File fileEntry : getQuoteDirectory().listFiles()) {
            /** If file in fileEntry list is not a directory */
            if (!fileEntry.isDirectory()) {
                /** Get file name without file extention */
                String fileName = fileEntry.getName().replace(".quote", "");
                /** If a quotation exists with the given UUID from the File */
                if (doesQuoteExistWithID(UUID.fromString(fileName))) {
                    /** Add the Quote from the given ID to the Quote Array List */
                    quoteList.add(getQuoteFromID(UUID.fromString(fileName)));
                }
            }

        }

        return quoteList;

    }

    /**
     * Begin New Quote - Create a new Quote
     *
     * @param userInput - Given User Input (Scanner)
     * @throws IOException - Handled Exception (IOException)
     */
    public static void beginNewQuote(Scanner userInput) throws IOException {

        /** CONTACT DETAILS */
        System.out.println("First, we'll need the Contact Details of the Customer."
                + "\nPlease Enter the Customers First Name:");
        while (!userInput.hasNext()) ;
        String fullName = userInput.next();
        System.out.println("Please enter the Customers Second Name:");
        fullName = fullName + " " + userInput.next();
        System.out.println("Full Name is " + fullName);

        System.out.println("Please Enter the Customer Email Address:");
        String givenEmail = userInput.next();
        System.out.println("Given Email is " + givenEmail);

        System.out.println("Please enter the Customer Home Address:");
        String givenAddress = userInput.next();
        System.out.println("Given Address is " + givenAddress);

        System.out.println("Please enter the Customers Phone Number:");
        String givenPhoneNumber = userInput.next();
        System.out.println("Given Phone Number was " + givenPhoneNumber);

        System.out.println("Customer " + fullName + " complete!");
        ContactDetails contactDetails = new ContactDetails(fullName, givenEmail, givenAddress, givenPhoneNumber);
        EntityCustomer newCustomer = new EntityCustomer(contactDetails);

        /** INSURANCE */
        System.out.println("How much will the Car Insurance Cost? (Monthly)");
        int insuranceCost = userInput.nextInt();

        System.out.println("Please enter the Car Insurance Company from the following available companies:"
                + "\n(Example Input: Churchill)");
        for (EnumCarInsuranceCompany models : EnumCarInsuranceCompany.values()) {
            System.out.println(models + " - '" + models.getInsuranceCompanyName() + "'");
        }

        CarInsurance givenCarInsurance = new CarInsurance(EnumCarInsuranceCompany.fromString(userInput.next()), insuranceCost);
        System.out.println("You've chosen the Car Insurance from " + givenCarInsurance.getInsuranceCompany().getInsuranceCompanyName()
                + " costing " + givenCarInsurance.getInsuranceCost());

        /** DAYS OF RENT */
        System.out.println("How many days will the car be rented for:");
        int givenDays = userInput.nextInt();

        /** CAR OBJECT */
        System.out.println("Please Enter the Car Unique Identifier (UUID):");
        while (!userInput.hasNext()) ;
        UUID givenUUID = UUID.fromString(userInput.next());
        if (CarManager.doesCarExistWithID(givenUUID)) {

            PaymentMethod paymentMethod = new PaymentMethod(newCustomer, 10);
            Quotation newQuote = new Quotation(CarManager.getCarFromID(givenUUID), newCustomer, givenCarInsurance, paymentMethod, givenDays);

            QuoteManager.saveQuote(newQuote);

        } else {
            System.out.println("That car does not exist!");
        }

    }

    /**
     * Delete Quote - Delete an Existing Quote
     *
     * @param userInput - Given User Input (Scanner)
     * @throws IOException - Handled Exception (IOException)
     */
    public static void deleteQuote(Scanner userInput) throws IOException {

        /** Used to determine whether or not the program will loop prompt */
        boolean shouldAskAgain = true;

        /** While the Program should ask again, prompt the user for a Quote UUID */
        while (shouldAskAgain) {
            System.out.println("Please enter the ID (UUID) of the Quote that you wish to delete:");

            while (!userInput.hasNext()) ; /** Pause until user has entered an input */
            String givenUUID = userInput.next(); /** Cast given input to UUID as String */

            /** If a Quote with the given UUID exists, delete it */
            if (doesQuoteExistWithID(UUID.fromString(givenUUID))) {
                shouldAskAgain = false;

                /** If the Quote File Exists, delete the file */
                if (getQuoteAsFile(UUID.fromString(givenUUID)).exists()) {
                    getQuoteAsFile(UUID.fromString(givenUUID)).delete();
                    /** Inform the User that the Quote was deleted successfully */
                    System.out.println(getQuoteAsFile(UUID.fromString(givenUUID)).getName() + " was deleted successfully!");
                    /** Else, inform the User that the Quote File does not exist */
                } else {
                    System.out.println("The Quote File does not exist! Cannot delete!");
                }

                /** Else, inform the user that the given input was wrong and repeat prompt */
            } else {
                System.out.println("No Quotes exist with that UUID! (" + givenUUID + ")");
                shouldAskAgain = true;
            }
        }
    }

    /**
     * Display Quote Info - Display the Information of a Specific Quote
     * @param userInput - Given User Input
     * @throws IOException - Handled Exception (IOException)
     */
    public static void displayQuoteInfo(Scanner userInput) throws IOException {

        /** Used to determine whether or not the program will loop prompt */
        boolean shouldAskAgain = true;

        /** While the Program should ask again, prompt the user for a Quote UUID */
        while (shouldAskAgain) {
            System.out.println("Please enter the ID (UUID) of the Quote that you wish to display:");

            while (!userInput.hasNext()) ; /** Pause until user has entered an input */
            String givenUUID = userInput.next(); /** Cast given input to UUID as String */

            /** If a Quote with the given UUID exists, get it's information */
            if (doesQuoteExistWithID(UUID.fromString(givenUUID))) {
                shouldAskAgain = false;

                /** If the Quote File Exists, display it's information */
                if (getQuoteAsFile(UUID.fromString(givenUUID)).exists()) {
                    getQuoteFromID(UUID.fromString(givenUUID)).printInfo();
                    /** Else, inform the User that the Quote File does not exist */
                } else {
                    System.out.println("The Quote File does not exist! Cannot display!");
                }

                /** Else, inform the user that the given input was wrong and repeat prompt */
            } else {
                System.out.println("No Quotes exist with that UUID! (" + givenUUID + ")");
                shouldAskAgain = true;
            }
        }
    }

}
