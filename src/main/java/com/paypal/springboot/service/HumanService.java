package com.paypal.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.paypal.springboot.model.Human;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service
public class HumanService {

	List<Human> list = new ArrayList<>();
	
	{
		
		list.add(new Human("Finney", "Sadarla", 1));
		list.add(new Human("Enoch", "Prince", 2));
		list.add(new Human("Sarojini", "Milton", 3));
		list.add(new Human("George", "Milton", 4));
	}
	
	public List<Human> getAll(){
		
		return list;
	}

	public Human getById(int id) {
		
		Human human = null;
		
		for(Human h: list) {
			
			if(h.getNumber() == id) {
				
				human = h;
			}
		}
		
		return human;
	}
}
