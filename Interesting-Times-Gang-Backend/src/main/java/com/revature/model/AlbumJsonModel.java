package com.revature.model;

import java.time.LocalDate;
import java.util.List;

public class AlbumJsonModel {
	private Album album;
	private List<LocalDate> imageDates;

	public AlbumJsonModel() {
		super();
	}

	public AlbumJsonModel(Album album, List<LocalDate> imageDates) {
		super();
		this.album = album;
		this.imageDates = imageDates;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public List<LocalDate> getImageDates() {
		return imageDates;
	}

	public void setImageDates(List<LocalDate> imageDates) {
		this.imageDates = imageDates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((album == null) ? 0 : album.hashCode());
		result = prime * result + ((imageDates == null) ? 0 : imageDates.hashCode());
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
		AlbumJsonModel other = (AlbumJsonModel) obj;
		if (album == null) {
			if (other.album != null)
				return false;
		} else if (!album.equals(other.album))
			return false;
		if (imageDates == null) {
			if (other.imageDates != null)
				return false;
		} else if (!imageDates.equals(other.imageDates))
			return false;
		return true;
	}

}
