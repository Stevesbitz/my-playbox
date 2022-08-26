import com.sendgrid.*;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class MSendGrid {
    static final String SENDGRID_API_KEY ="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";

    public static void main(String[] args) throws IOException {
        send();
    }

    static void send() throws IOException {
        Email from = new Email("stepheniadebayo@gmail.com");
        String subject = "Sending with Twilio SendGrid is Fun";
        Email to = new Email("asafeadey@gmail.com");
        Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
        Mail mail = new Mail(from, subject, to, content);

        SendGrid sg = new SendGrid(SENDGRID_API_KEY);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            throw ex;
        }
    }

    static void sendMail() throws IOException {

        try (Client client = new Client()) {
            Request request = new Request();
            request.setBaseUri("api.test.com");
            request.addHeader("Authorization", SENDGRID_API_KEY);
            request.addQueryParam("limit", "100");
            request.addQueryParam("offset", "0");
// Will be parsed to categories=cake&categories=pie&categories=baking
            request.addQueryParam("categories", "cake&pie&baking");
            request.setBody("{\"name\": \"My Request Body\"}");
            request.setMethod(Method.POST);
            String param = "param";
            request.setEndpoint("/your/api/" + param + "/call");

            Response response = client.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }


    }

}
