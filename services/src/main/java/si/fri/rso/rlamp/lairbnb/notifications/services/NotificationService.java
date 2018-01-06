package si.fri.rso.rlamp.lairbnb.notifications.services;

import org.glassfish.jersey.process.internal.RequestScoped;

@RequestScoped
public class NotificationService {
// Dummy service

    protected void sendEmail(String emailAddess, String message) {
        System.out.println("Sending email message \'" + message + "\' to \'" +
            emailAddess + "\'.");
    }

    public void sendWelcomeMessage (String emailAddess, String name) {
        this.sendEmail(emailAddess, String.format("Dear %s, welcome to LairBnb!", name));
    }

    public void sendReservaitonConformation (String emailAddess, Integer reservationId) {
        this.sendEmail(emailAddess, String.format("Reservation %d has been successfully completed.", reservationId));
    }
}
