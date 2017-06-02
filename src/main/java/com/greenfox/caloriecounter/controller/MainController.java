package com.greenfox.caloriecounter.controller;

import com.greenfox.caloriecounter.model.Meal;
import com.greenfox.caloriecounter.repository.MealRepository;
import com.greenfox.caloriecounter.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  MealRepository mealRepository;

  @Autowired
  MealTypeRepository mealTypeRepository;

  @RequestMapping(value = "/")
  public String indexPage(Model model) {
    model.addAttribute("mealtypes", mealTypeRepository.findAllByOrderByInDay());
    model.addAttribute("meals", mealRepository.findAll());
    return "index";
  }

  @RequestMapping(value = "/edit")
  public String editPage(Model model) {
    model.addAttribute("mealtypes", mealTypeRepository.findAllByOrderByInDay());
    return "edit";
  }

  @RequestMapping(value = "/save")
  public String saveEdit(@RequestParam String type, @RequestParam String desc, @RequestParam int calories) {
    mealRepository.save(new Meal(type, desc, calories));
    return "redirect:/";
  }
}
