package entity;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import java.io.IOException;
import java.io.InputStream;

public class Transfer {

    public static String input(String msg)  {
        if (msg.contains("/start") || msg.contains("/") || msg.contains("Привет") ) {
            return "Здравствуйте, хотите совершить перевод?\nВведите номер карты:";
        }
        if (msg.contains("3454646645564664") || msg.contains("68416719817981798") || msg.contains("684269898219889") || msg.contains("52987988798719")) {
            PostMethod postToken = new PostMethod("https://openapi-entry-api2.intervale.ru/api/v4/P2PCARD2CARDNET10BE51947C120CCD8/token");
            PostMethod postStart = new PostMethod("https://openapi-entry-api2.intervale.ru/api/v4/P2PCARD2CARDNET10BE51947C120CCD8/payment/start");
            NameValuePair[] data = {
                    new NameValuePair("src.pan", "3454646645564664"),
                    new NameValuePair("dsc.pan", "4454646645564664")
            };
            postToken.setRequestBody(data);
            // execute method and handle any error responses.
            try {
                InputStream in = postToken.getResponseBodyAsStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // handle response.
            return "Ok";
        }
        return msg;
    }

}
