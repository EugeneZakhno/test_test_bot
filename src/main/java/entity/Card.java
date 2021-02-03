package entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class Card {
    String srcPan;
    String desPan;
    String expDate;
    String cvc;
    String name;
    int amount;

    public Card() {

    }

    public Card(String srcPan, String desPan, String expDate, String cvc, String name) {
        this.srcPan = srcPan;
        this.desPan = desPan;
        this.expDate = expDate;
        this.cvc = cvc;
        this.name = name;
    }

    public String getSrcPan() {
        return srcPan;
    }
    public void setSrcPan(String srcPan) {
        this.srcPan = srcPan;
    }
    public void setDesPan(String srcPan) {
        this.desPan = desPan;
    }
    public String getDesPan() {
        return desPan;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
