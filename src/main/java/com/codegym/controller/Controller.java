package com.codegym.controller;

import com.codegym.model.Cities;
import com.codegym.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

;import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    ICityService cityService;


    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("cities", new Cities());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute("city") Cities cities) {
        cityService.save(cities);
        ModelAndView modelAndView = new ModelAndView("/city/create");
        modelAndView.addObject("cities", new Cities());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/show")
    public ModelAndView listCity() {
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cityService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Cities> cities = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute("cities") Cities cities) {
        cityService.save(cities);
        ModelAndView modelAndView = new ModelAndView("/city/edit");
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
            Optional<Cities> cities = cityService.findById(id);
            ModelAndView modelAndView = new ModelAndView("/city/delete");
            modelAndView.addObject("cities", cities);
            return modelAndView;
    }

    @PostMapping("/delete-city")
    public ModelAndView deleteCity(@ModelAttribute("cities") Cities cities) {
        cityService.delete(cities.getId());
        return new ModelAndView("/city/list") ;
    }

}
