package com.petStore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petStore.entity.Cart;
import com.petStore.repository.MyPetRepository;

@Service

public class PetListService {
	@Autowired
	private MyPetRepository mypet;
	
	public void saveMyPets(Cart pets) {
		mypet.save(pets);
	}
	
	public List<Cart> getAllMyPets(){
		return mypet.findAll();
	}
	
	/*public void deleteById(int id) {
		mypet.deleteById(id);
	}*/
	
}


