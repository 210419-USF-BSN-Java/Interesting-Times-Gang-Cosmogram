package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Tag;

@Repository
@Transactional
public interface TagRepository extends JpaRepository<Tag, Long> {
	public Tag findTagByTagId(Integer id);
	public List<Tag> findAll();
}