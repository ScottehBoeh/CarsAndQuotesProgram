package common.objects;

import common.entities.EntityCustomer;

import java.util.UUID;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class PaymentMethod {

    /**
     * Payment Method Unique Identifier
     */
    private UUID paymentMethodUUID = UUID.randomUUID();
    /**
     * Payment Method Customer
     */
    private EntityCustomer paymentMethodCustomer;
    /**
     * Payment Method Cost
     */
    private double paymentMethodCost;

    public PaymentMethod(EntityCustomer givenCustomer, double givenCostPerDay) {

        this.paymentMethodCustomer = givenCustomer;
        this.paymentMethodCost = givenCostPerDay;

    }

    /**
     * Get Payment Method UUID - Get the Unique Identifier of the Payment Method
     *
     * @return - Given Payment Method Unique Identifier (UUID)
     */
    public UUID getPaymentMethodUUID() {
        return this.paymentMethodUUID;
    }

}
