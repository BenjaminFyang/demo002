package com.example.demo.service.servieImpl;

import com.example.demo.model.EmailSender;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <>
 *
 * @author fangyang
 * @create 2020-03-06
 * @since 1.0.0
 */
public class EmailViewer {

    private EmailSender emailSender;
    private List toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender();
    }

    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {
        // format the requestStats to HTML style.
        // send it to email toAddresses. }
    }

}
