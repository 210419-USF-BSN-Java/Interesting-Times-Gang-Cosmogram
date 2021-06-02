///*
package com.revature.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Image;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Image, Long>{
	public Image findImageByDate(Date date);
}
//*/