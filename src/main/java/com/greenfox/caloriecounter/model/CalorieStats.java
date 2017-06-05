package com.greenfox.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class CalorieStats {

  private long numberOfMeals;
  private long totalCalories;

  public CalorieStats() {
  }

  public void calorieStats(List<Meal> meals) {
    this.numberOfMeals = meals.size();
    for (Meal meal : meals) {
      this.totalCalories += meal.getCalorie();
    }
  }
}
