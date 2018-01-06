package si.fri.rso.rlamp.lairbnb.notifications.api.v1.resources;

import si.fri.rso.rlamp.lairbnb.notifications.services.NotificationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/notify")
public class NotificationsResource {

    @Inject
    private NotificationService notificationBean;

    @POST
    @Path("/email")
    public Response sendEmail(@QueryParam("type") String type,
                              @QueryParam("addr") String emailAddress,
                              @QueryParam("name") String name,
                              @QueryParam("id")   Integer id) {
        if (type.equals("welcome")) {
            notificationBean.sendWelcomeMessage(emailAddress, name);
        }
        else if (type.equals("reservation")) {
            notificationBean.sendReservaitonConformation(emailAddress, id);
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().build();
    }

    @POST
    @Path("/sms")
    public  Response sendSms(@QueryParam("num") String phoneNumber) {
        return Response.ok().build();
    }
}
