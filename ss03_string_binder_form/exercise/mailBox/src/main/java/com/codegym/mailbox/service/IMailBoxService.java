package com.codegym.mailbox.service;

import com.codegym.mailbox.model.MailBox;

public interface IMailBoxService {
    MailBox selectMailBox();
    MailBox updateMailBox(MailBox newMailBox);
}
