import common.entities.EntityCar;
import common.entities.EntityCarOffroad;
import common.entities.EntityCustomer;
import common.enums.EnumCarInsuranceCompany;
import common.enums.EnumCarModel;
import common.objects.CarInsurance;
import common.objects.ContactDetails;
import common.objects.PaymentMethod;
import common.objects.Quotation;
import common.utils.CarManager;
import common.utils.QuoteManager;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 * <p>
 * <p> Main Component - Main Class to Initialize Program </p>
 * <p>
 * <p> Car Booking Program - This program shows several examples of
 * super-classes, inheritance, instances etc. This program allows
 * the user to create a booking of a car between a client and a
 * vehicle. </p>
 * <p>
 * <p> You can find more information and projects that I have created
 * from my <a href="">Github Account</a> </p>
 * <p>
 * <p>I mportant: Dependencies </p>
 * <p> This program should come packed with Gson. This is the library
 * that I have used to save objects to disk. If you have any issues
 * with getting the supplied library .jar, contact me over Github or
 * email me @ scottehboehbusiness@gmail.com </p>
 */
public class MainComponent {

    public static boolean shouldExit = false;
    public static Scanner userInput = new Scanner(System.in);

    /**
     * Main Class - First Initialized
     *
     * @param args - Given Launch Arguments
     */
    public static void main(String[] args) {

        /** Loop until the program is told to exit */
        while (!shouldExit) {

            /** Display Count of all Cars and Quotes currently stored */
            try {
                System.out.println("Quotes: " + QuoteManager.getAllQuotesAsList().size());
                System.out.println("Cars: " + CarManager.getAllCarsAsList().size());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("=-------------------------------="
                    + "\n Please chose an Option:"
                    + "\n"
                    + "\n 1 - Create new Quote"
                    + "\n 2 - Create new Car"
                    + "\n 3 - Delete existing Quote"
                    + "\n 4 - Delete existing Car"
                    + "\n 5 - Display existing Quote"
                    + "\n 6 - Display existing Car"
                    + "\n 7 - Display all Quotes"
                    + "\n 8 - Display all Cars"
                    + "\n 9 - Exit Program"
                    + "\n"
                    + "\n=-------------------------------=");

            /** While there's no input, wait */
            while (!userInput.hasNextInt()) ;

            /** Get Answer from User */
            int givenInput = userInput.nextInt();
            System.out.println("You chose: " + givenInput);
            try {
                executeMenuSelectrion(userInput, givenInput);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public static void testRun() {

        /** Create an example object of Customer, Vehicle, Quotation, etc. */
        ContactDetails scottContactDetails = new ContactDetails(
                "Scott Roberto",
                "ScottishBoy@btinternet.com",
                "16 Downroad, Limesdale",
                "555 3434 666");

        EntityCustomer scottCustomer = new EntityCustomer(scottContactDetails);

        EntityCarOffroad offroadCar1 = new EntityCarOffroad(EnumCarModel.CITROEN_SPACETOURER);
        offroadCar1.setCostPerDay(5);
        offroadCar1.setNumberOfGears(6);

        PaymentMethod paymentMethod1 = new PaymentMethod(scottCustomer, offroadCar1.getCarCostPerDay());

        CarInsurance insurance1 = new CarInsurance(EnumCarInsuranceCompany.CHURCHILL, 5);

        Quotation quotation1 = new Quotation(offroadCar1, scottCustomer, insurance1, paymentMethod1, 5);

        try {
            QuoteManager.saveQuote(quotation1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Print Information for each Quotation */
        try {
            for (Quotation quotation : QuoteManager.getAllQuotesAsList()) {

                quotation.printInfo();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Execute Menu Selection - Execute a Menu Option with given Input (int)
     *
     * @param userInput  - Given User Input Scanner (Scanner)
     * @param givenInput - Given User Input (int)
     * @throws IOException - Given Exception
     */
    public static void executeMenuSelectrion(Scanner userInput, int givenInput) throws IOException {

        switch (givenInput) {

            case 1:
                /** CREATE NEW QUOTE */
                QuoteManager.beginNewQuote(userInput);
                break;
            case 2:
                /** CREATE NEW CAR */
                CarManager.beginNewCar(userInput);
                break;
            case 3:
                /** DELETE QUOTE */
                QuoteManager.deleteQuote(userInput);
                break;
            case 4:
                /** DELETE CAR */
                CarManager.deleteCar(userInput);
                break;
            case 5:
                /** DISPLAY SPECIFIC QUOTE */
                QuoteManager.displayQuoteInfo(userInput);
                break;
            case 6:
                /** DISPLAY SPECIFIC CAR */
                CarManager.displayCarInfo(userInput);
                break;
            case 7:
                /** GET QUOTES AS LIST */
                System.out.println("START OF QUOTES LIST");
                for (Quotation quote : QuoteManager.getAllQuotesAsList()) {
                    quote.printInfo();
                    System.out.println("=======================================================");
                }
                System.out.println("END OF QUOTES LIST");
                break;
            case 8:
                /** GET CARS AS LIST */
                System.out.println("START OF CAR LIST");
                for (EntityCar car : CarManager.getAllCarsAsList()) {
                    car.printInfo();
                    System.out.println("=======================================================");
                }
                System.out.println("END OF CAR LIST");
                break;
            case 9:
                /** EXIT PROGRAM */
                shouldExit = true;
                break;
        }

    }

}