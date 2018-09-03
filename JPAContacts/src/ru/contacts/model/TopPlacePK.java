package ru.contacts.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the top_place database table.
 * 
 */
@Embeddable
public class TopPlacePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="human_id", insertable=false, updatable=false)
	private int humanId;

	private String place;

	public TopPlacePK() {
	}
	public int getHumanId() {
		return this.humanId;
	}
	public void setHumanId(int humanId) {
		this.humanId = humanId;
	}
	public String getPlace() {
		return this.place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TopPlacePK)) {
			return false;
		}
		TopPlacePK castOther = (TopPlacePK)other;
		return 
			(this.humanId == castOther.humanId)
			&& this.place.equals(castOther.place);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.humanId;
		hash = hash * prime + this.place.hashCode();
		
		return hash;
	}
}