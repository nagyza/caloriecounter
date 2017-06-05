package com.greenfox.caloriecounter.controller;

import com.greenfox.caloriecounter.model.CalorieStats;
import com.greenfox.caloriecounter.model.Meal;
import com.greenfox.caloriecounter.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainRestController {

  @Autowired
  MealRepository mealRepository;

  @Autowired
  CalorieStats calorieStats;

  @GetMapping(value = "/getmeals")
  public List<Meal> getMeals() {
    return mealRepository.findAll();
  }

  @GetMapping(value = "/getstats")
  public CalorieStats getStats() {
    calorieStats.calorieStats(mealRepository.findAll());
    return calorieStats;
  }
}
