package com.revature.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.TagJunction;
import com.revature.repository.TagJunctionRepository;

@Service
public class TagJunctionService {

	private TagJunctionRepository tjr;
	
	public TagJunctionService() {
		
	}
	
	@Autowired
	public TagJunctionService(TagJunctionRepository tjr) {
		this.tjr = tjr;
	}
	
	public String createTagJunction(Long tagId, LocalDate imageDate) {
		
		try {
			tjr.save(new TagJunction(tagId, imageDate));
			return "TagJunction created successfully";
		}catch(Exception e){
			e.printStackTrace();
			return "Error: TagJunction was not created";
		}
	}
	
	public List<TagJunction> getAllByTagId(Long id){
		return tjr.findAllByTagId(id);
	}
}
