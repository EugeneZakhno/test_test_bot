package entity;

import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;


public class Transfer {

    public static String input(String msg)  {
        if (msg.contains("Hi") || msg.contains("Hello") || msg.contains("Привет") || msg.contains("Как дела?")) {
            return "Здравствуйте, хотите совершить перевод? \n Введите номер карты";
        }
        if (msg.contains("3454646645564664") || msg.contains("68416719817981798") || msg.contains("684269898219889") || msg.contains("52987988798719")) {

            PostMethod post = new PostMethod("https://openapi-entry-api2.intervale.ru/api/v4/P2PCARD2CARDNET10BE51947C120CCD8/token");
            NameValuePair[] data = {
                    new NameValuePair("src.pan", "3454646645564664"),
                    new NameValuePair("dsc.pan", "bloggs")
            };
            post.setRequestBody(data);
            // execute method and handle any error responses.
            try {
                InputStream in = post.getResponseBodyAsStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // handle response.
            return "Ok";
        }
        return msg;
    }

}
