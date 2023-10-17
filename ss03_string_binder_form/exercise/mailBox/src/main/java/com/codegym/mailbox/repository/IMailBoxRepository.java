package com.codegym.mailbox.repository;

import com.codegym.mailbox.model.MailBox;

public interface IMailBoxRepository {
    MailBox selectMailBox();
    MailBox updateMailBox(MailBox newMailBox);
}
