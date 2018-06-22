package com.greenfox.caloriecounter.controller;

import com.greenfox.caloriecounter.model.Meal;
import com.greenfox.caloriecounter.model.MealType;
import com.greenfox.caloriecounter.repository.MealRepository;
import com.greenfox.caloriecounter.repository.MealTypeRepository;
import com.greenfox.caloriecounter.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

  MealRepository mealRepository;

  MealTypeRepository mealTypeRepository;

  WebService webService;

  @Autowired
  public MainController(MealRepository mealRepository, MealTypeRepository mealTypeRepository, WebService webService) {
    this.mealRepository = mealRepository;
    this.mealTypeRepository = mealTypeRepository;
    this.webService = webService;
  }

  @RequestMapping(value = "/")
  public String indexPage(Model model) {
    model.addAttribute("mealtypes", webService.getMealTypes());
    model.addAttribute("meals", webService.getMeals());
    return "index";
  }

  @RequestMapping(value = "/edit")
  public String editPage(Model model, @RequestParam(required = false, name = "edit_id") Long id) {
    model.addAttribute("editId", id);
    model.addAttribute("mealToEdit", mealRepository.findOne(id));
    model.addAttribute("mealtypes", mealTypeRepository.findAllByOrderByInDay());
    return "edit";
  }

  @PostMapping(value = "/add")
  public String addMeal(@RequestParam(name = "type") String type,
                        @RequestParam(required = false, name = "desc") String desc,
                        @RequestParam(required = false, name = "date") String date,
                        @RequestParam(name = "calorie") int calorie) throws Exception{
    if (date.isEmpty()) {
      mealRepository.save(new Meal(type, desc, calorie));
    } else {
      mealRepository.save(new Meal(date, type, desc, calorie));
    }
    return "redirect:/";
  }

  @PutMapping(value = "/save")
  public String saveChange(@RequestParam(name = "id") long id,
                           @RequestParam(name = "type") String type,
                           @RequestParam(required = false, name = "desc") String desc,
                           @RequestParam(required = false, name = "date") String date,
                           @RequestParam(name = "calorie") int calorie) throws Exception{
    Meal mealToUpdate = mealRepository.findOne(id);
    mealToUpdate.setDate(date);
    mealToUpdate.setType(type);
    mealToUpdate.setDescription(desc);
    mealToUpdate.setCalorie(calorie);
    mealRepository.save(mealToUpdate);
    return "redirect:/";
  }

  @DeleteMapping(value = "/delete")
  public String deleteMeal(@RequestParam(name = "delete_id") long id) {
    mealRepository.delete(id);
    return "redirect:/";
  }
}
