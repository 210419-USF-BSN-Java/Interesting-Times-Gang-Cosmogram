package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.TagJunction;


@Repository
@Transactional
public interface TagJunctionRepository extends JpaRepository<TagJunction, Long> {
	public List<TagJunction> findAllByTagId(Long id);
}