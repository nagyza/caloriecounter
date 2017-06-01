package com.greenfox.caloriecounter.controller;

import com.greenfox.caloriecounter.repository.MealRepository;
import com.greenfox.caloriecounter.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @Autowired
  MealRepository mealRepository;

  @Autowired
  MealTypeRepository mealTypeRepository;

  @RequestMapping(value = "/")
  public String indexPage(Model model) {
    return "index";
  }
}
