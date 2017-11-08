package common.objects;

import java.util.UUID;

/**
 * Created by Scott L. Robertson on 01/11/2017.
 */
public class Passport {

    /**
     * Passport Information
     */
    private UUID passportInformation = UUID.randomUUID();

    /**
     * Get Passport Information
     *
     * @return
     */
    public UUID getPassportInformation() {
        return this.passportInformation;
    }

}
