package com.petStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.petStore.entity.Cart;
import com.petStore.entity.Pet;
import com.petStore.service.PetListService;
import com.petStore.service.PetService;

@Controller
public class PetController {
	
	@Autowired
	private PetService service;
	
	
	@Autowired
	private PetListService mypetservice;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/about_us")
	public String aboutus() {
		return "aboutus";
	}
	@GetMapping("/category")
	public String category() {
		return "category";
	}
	@GetMapping("/news_events")
	public String newsandevents() {
		return "newsandevents";
	}
	@GetMapping("/contact_us")
	public String contactsus() {
		return "contactsus";
	}
	@GetMapping("/shp")
	public String shop() {
		return "shop";
	}
	
	
	/*@GetMapping("/shp")
	public ModelAndView getAllPet() {
		List<Pet>list=service.getAllPet();
		
		return new ModelAndView("cart","carts",list);
	}*/
	
	@PostMapping("/save")
	public String addPet(@ModelAttribute Pet p) {
		service.save(p);
		return "redirect:/cart";
	}
	
	/*@RequestMapping("/cart/{id}")
	public String getMyList(@PathVariable("id")int Long) {
		Pet p=service.getPetById(Long);
		Cart mp=new Cart(p.getId(),p.getType(),p.getCategory(),p.getPrice());
		mypetservice.addItemToCart(mp);
		return "redirect:/cart";
	}*/
	
	@GetMapping("/cart")
	public String getMyPets(Model model){
		List<Cart>list=mypetservice.getAllMyPets();
		model.addAttribute("pet",list);
		return "cart";
	
		
	}
	
	
	

}
