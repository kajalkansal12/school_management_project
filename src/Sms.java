import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import java.util.Random;


public class Sms {

    public static final String ACCOUNT_SID = "ACa2215a26f2f28879a4c0caa01d00fc53";
    public static final String AUTH_TOKEN = "2cfd101e186bffaa8aa184b2ee87e207";

    public static void sendMessage(String text,String phoneNumber) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:+91"+phoneNumber),
                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
                text
        ).create();

        System.out.println(message.getSid());
    }
}