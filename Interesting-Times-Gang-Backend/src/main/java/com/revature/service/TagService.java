package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Tag;
import com.revature.repository.TagRepository;

@Service
public class TagService {

	private TagRepository tagRepo;
	private UserService userService;

	public TagService() {

	}

	@Autowired
	public TagService(TagRepository tagRepo, UserService userService) {
		this.tagRepo = tagRepo;
		this.userService = userService;
	}

	public String createTag(String tagName) {
		try {
			Tag tag = new Tag(tagName);
			tagRepo.save(tag);
			return "Tag created successfully";
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed to create tag";
		}
	}
	public List<Tag> getAll() {
		return tagRepo.findAll();
	}
}
