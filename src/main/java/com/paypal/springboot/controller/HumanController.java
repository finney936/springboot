package com.paypal.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.paypal.springboot.model.Human;
import com.paypal.springboot.service.HumanService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HumanController {

	@Autowired
	HumanService service;
	
	@RequestMapping("/")
	@ResponseBody
	public ResponseEntity<Human> index() {
		
		int random = (int)(Math.random()*100);
		
		if(random<50) {
			
			return ResponseEntity.ok().header("Object-Type", "Human.class")
		              .body(new Human("Finney", "Sadarla", 1));
		}
		else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@RequestMapping("/human")
	@ResponseBody
	public Human human() {
		
		Human human = new Human("Finney", "Sadarla", 1);
		
		human.add(linkTo(methodOn(HumanController.class).human()).withSelfRel());
		
		return human;
	}
	
	@ResponseBody
	@RequestMapping("/human/{id}")
	public Human getHuman(@PathVariable int id) {
		
		Human human = service.getById(id);
		
		human.add(linkTo(methodOn(HumanController.class).getHuman(id)).withSelfRel());
		
		return human;
	}
	
}
