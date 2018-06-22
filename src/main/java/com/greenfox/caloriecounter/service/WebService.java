package com.greenfox.caloriecounter.service;

import com.greenfox.caloriecounter.model.Meal;
import com.greenfox.caloriecounter.model.MealType;
import com.greenfox.caloriecounter.repository.MealRepository;
import com.greenfox.caloriecounter.repository.MealTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService {

    MealRepository mealRepository;
    MealTypeRepository mealTypeRepository;

    @Autowired
    public WebService(MealRepository mealRepository, MealTypeRepository mealTypeRepository) {
        this.mealRepository = mealRepository;
        this.mealTypeRepository = mealTypeRepository;
    }

    public Iterable<MealType> getMealTypes() {
        return mealTypeRepository.findAllByOrderByInDay();
    }

    public List<Meal> getMeals() {
        return mealRepository.findAll();
    }
}
