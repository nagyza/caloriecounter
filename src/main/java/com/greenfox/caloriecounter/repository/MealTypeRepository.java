package com.greenfox.caloriecounter.repository;

import com.greenfox.caloriecounter.model.MealType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTypeRepository extends CrudRepository<MealType, Long> {
  public Iterable<MealType> findAllByOrderByInDay();
}
