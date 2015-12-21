/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ivan
 */
public class Message extends MySql {

    private String sender;
    private String receiver;
    private String message;
    private java.sql.Timestamp datetime ;

    public Message() {
    }

    public Message(String sender, String receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    //here we set the datetime
    public void setDateTime(java.sql.Timestamp datetime) {
        this.datetime = datetime;
    }

    //here we return the time of the message sent
    public java.sql.Timestamp getDateTime() {
        return datetime;
    }

    public void recordMessage() {
        super.recordMessage(sender, receiver, message);
    }

}
