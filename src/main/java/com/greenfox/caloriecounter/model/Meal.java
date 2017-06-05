package com.greenfox.caloriecounter.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "meals")
public class Meal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String date;
  private String type;
  private String description;
  private int calorie;

  public Meal() {
  }

  public Meal(String  date, String type, String description, int calorie) {
    this.date = date;
    this.type = type;
    this.description = description;
    this.calorie = calorie;
  }

  public Meal(String type, String description, int calorie) {
    Date myDate = new Date();
    this.date = new SimpleDateFormat("yyyy-MM-dd").format(myDate);
    this.type = type;
    this.description = description;
    this.calorie = calorie;
  }
}
