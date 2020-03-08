package com.example.demo.service.servieImpl;

import com.example.demo.model.EmailSender;
import com.example.demo.service.StatViewer;

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
public class EmailViewer implements StatViewer {

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

    @Override
    public void output(Map requestStats, long startTimeInMillis, long endTimeInMills) {

        System.out.println("EmailViewer.....");
        // format the requestStats to HTML style.
        // send it to email toAddresses. }
    }

}
