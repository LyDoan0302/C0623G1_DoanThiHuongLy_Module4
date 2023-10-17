package com.codegym.mailbox.repository;

import com.codegym.mailbox.model.MailBox;
import org.springframework.stereotype.Repository;

@Repository
public class MailBoxRepository implements IMailBoxRepository{
    private static MailBox mailBox;
    static {
        mailBox = new MailBox();
    }
    @Override
    public MailBox selectMailBox() {
        return mailBox;
    }

    @Override
    public MailBox updateMailBox(MailBox newMailBox) {
        mailBox.setLanguage(newMailBox.getLanguage());
        mailBox.setPageSize(newMailBox.getPageSize());
        mailBox.setSpamsFilter(newMailBox.getSpamsFilter());
        mailBox.setSignature(newMailBox.getSignature());
        return mailBox;
    }
}
