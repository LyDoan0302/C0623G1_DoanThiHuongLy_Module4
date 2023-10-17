package com.codegym.mailbox.controller;

import com.codegym.mailbox.model.MailBox;
import com.codegym.mailbox.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MailBoxController {
    @Autowired
    IMailBoxService mailBoxService;
    @GetMapping
    public String settingPage(Model model) {
        MailBox mailBox = new MailBox();

        List<String> languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        model.addAttribute("languageList", languageList);

        List<Integer> pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
        model.addAttribute("pageSizeList", pageSizeList);

        model.addAttribute("mailBox", mailBox);

        return "setting";
    }
    @PostMapping("/update")
    public String updateSetting(@ModelAttribute MailBox mailBox, Model model) {
//        mailBoxService.updateMailBox(mailBox);
        model.addAttribute("mailBox", mailBox);
        return "index";
    }

}
