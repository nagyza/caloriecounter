package com.greenfox.caloriecounter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mealtypes")
public class MealType {

  @Id
  @Column(name = "mealtype")
  private String typeOfMeal;

  public MealType() {
  }

  public MealType(String typeOfMeal) {
    this.typeOfMeal = typeOfMeal;
  }

  public String getTypeOfMeal() {
    return typeOfMeal;
  }

  public void setTypeOfMeal(String typeOfMeal) {
    this.typeOfMeal = typeOfMeal;
  }
}
