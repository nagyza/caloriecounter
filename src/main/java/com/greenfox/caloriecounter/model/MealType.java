package com.greenfox.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "mealtypes")
public class MealType {

  @Id
  @Column(name = "mealtype")
  private String typeOfMeal;

  @Column(name = "ord")
  private int inDay;


  public MealType() {
  }

  public MealType(String typeOfMeal) {
    this.typeOfMeal = typeOfMeal;
  }
}
