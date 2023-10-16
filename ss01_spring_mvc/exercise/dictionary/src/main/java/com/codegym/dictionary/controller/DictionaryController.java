package com.codegym.dictionary.controller;

import com.codegym.dictionary.service.IDicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping()
public class DictionaryController {
  @Autowired
  private IDicService dicService;

  @GetMapping
    public ModelAndView showFormSearching() {
      return new ModelAndView("index");
  }
  @PostMapping
  public ModelAndView searchWord(@RequestParam String english) {
    String vietnamese = dicService.findWord(english);
      return new ModelAndView("index", "vietnamese", vietnamese);
  }
}