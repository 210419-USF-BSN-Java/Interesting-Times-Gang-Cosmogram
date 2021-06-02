///*
package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Album;
import com.revature.model.Image;

@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Album, Long>{
	public List<Album> findAlbumsByUserId(Integer id);
}
//*/
