package com.mb.projektarbete.cardealership.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mb.projektarbete.cardealership.cars.Car;
import com.mb.projektarbete.cardealership.repositories.CarRepo;

@Controller
public class CarController {
	
	private CarRepo carRepo;
	
	@Autowired
	public void setCarRepo(CarRepo carRepo) {
		this.carRepo = carRepo;
	}
	
	@RequestMapping("/admin")
	public String loginAdmin(Model model) {
		List<Car> allCars = (List<Car>) carRepo.findAll();
		if(allCars != null)
			model.addAttribute("allCars", allCars);
		return "admin";
	}
	
	@RequestMapping("admin/edit/{id}")
	public String editCar(@PathVariable Long id, Model model){
		model.addAttribute(carRepo.findOne(id));
		
		return "/edit";
	}
	
	@RequestMapping(value = "admin/delete/{id}")
	public String deleteCar(@PathVariable Long id) {
		carRepo.delete(id);
		
		return "index";
	}
	@RequestMapping("admin/add")
	public String addCar(Model model) {
		Car car = new Car();
		model.addAttribute("car", car);
		return "/edit";
	}
	
	//called from html form in edit.html
	@RequestMapping(value = "edit", method = RequestMethod.POST)
    public String saveProduct(Car car){
        carRepo.save(car);
        return "redirect:/admin";
    }
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/browse")
	public String browseCars(Model model) {
		List<Car> allCars = (List<Car>) carRepo.findAll();
		if(allCars != null)
			model.addAttribute("allCars", allCars);
		
		return "/browse";
	}

}
