package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import java.util.Date;



@Entity
@Component
@Table(name="album")
public class Album {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="album_id", unique=true, nullable=false)
	private Integer albumId;
	@Column(name="album_name", unique=true, nullable=false)
	private String albumName;
	@Column(name="user_id", unique=true, nullable=false)
	private Integer userId;
	
	
	
	public Album() {
		super();
	}
	public Album(String albumName, Integer userId) {
		super();
		this.albumName = albumName;
		this.userId = userId;
	}
	public Album(Integer albumId, String albumName, Integer userId) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.userId = userId;
	}
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((albumId == null) ? 0 : albumId.hashCode());
		result = prime * result + ((albumName == null) ? 0 : albumName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		if (albumId == null) {
			if (other.albumId != null)
				return false;
		} else if (!albumId.equals(other.albumId))
			return false;
		if (albumName == null) {
			if (other.albumName != null)
				return false;
		} else if (!albumName.equals(other.albumName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Album [albumId=" + albumId + ", albumName=" + albumName + ", userId=" + userId + "]";
	}
}
