package si.fri.rso.rlamp.lairbnb.notifications.services;

import com.kumuluz.ee.logs.LogManager;
import com.kumuluz.ee.logs.Logger;
import com.kumuluz.ee.logs.enums.LogLevel;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class NotificationService {
// Dummy service

    private Logger logger = LogManager.getLogger(NotificationService.class.getName());

    protected void sendEmail(String emailAddess, String message) {
        logger.log(LogLevel.INFO, "Sending email message \'" + message + "\' to \'" +
            emailAddess + "\'.");
    }

    public void sendWelcomeMessage (String emailAddess, String name) {
        this.sendEmail(emailAddess, String.format("Dear %s, welcome to LairBnb!", name));
        logger.log(LogLevel.TRACE, String.format("Sending welcome email to %s", emailAddess));
    }

    public void sendReservaitonConformation (String emailAddess, Integer reservationId) {
        this.sendEmail(emailAddess, String.format("Reservation %d has been successfully completed.", reservationId));
        logger.log(LogLevel.TRACE, String.format("Sending reservation conformation email to %s for " +
                "resertvation %d", emailAddess, reservationId));
    }
}
