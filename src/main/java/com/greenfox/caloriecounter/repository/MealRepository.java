package com.greenfox.caloriecounter.repository;

import com.greenfox.caloriecounter.model.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
  @Override
  public List<Meal> findAll();
}
