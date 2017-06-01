package com.greenfox.caloriecounter.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meals")
public class Meal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Date date;
  private String type;
  private String description;
  private int calorie;

  public Meal() {
  }

  public Meal(String type, String description, int calorie) {
    this.date = new Date();
    this.type = type;
    this.description = description;
    this.calorie = calorie;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCalorie(int calorie) {
    this.calorie = calorie;
  }

  public Long getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public int getCalorie() {
    return calorie;
  }
}
