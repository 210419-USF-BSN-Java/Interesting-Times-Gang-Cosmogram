package com.revature.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.AlbumJunction;

@Repository
@Transactional
public interface AlbumJunctionRepository extends JpaRepository<AlbumJunction, Long> {
	public List<AlbumJunction> findAll();
	public List<AlbumJunction> findAlbumJunctionsByAlbumId(Integer id);
	public Long deleteByAlbumIdAndImageDate(Integer albumId, LocalDate imageDate);
}