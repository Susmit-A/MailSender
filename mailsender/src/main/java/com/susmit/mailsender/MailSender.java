package com.susmit.mailsender;

import com.susmit.mailtest.GMailSender;

public class MailSender
{
    private GMailSender sender;
    private String myID;
    public MailSender(String userEmailID, String userPassword)
    {
        myID = userEmailID;
        sender = new GMailSender(userEmailID,userPassword);
    }
    public void sendMail(String recID, String subject, String content)
    {
        try {
            sender.sendMail(subject,
                    content,
                    myID,
                    recID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendMailAsync(String recID, String subject, String content)
    {
        final String rec = recID;
        final String sub = subject;
        final String cont = content;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sender.sendMail(sub,
                            cont,
                            myID,
                            rec);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
