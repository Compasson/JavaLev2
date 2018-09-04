package ru.humanbook.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the top_teg database table.
 * 
 */
@Embeddable
public class TopTegPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="human_id", insertable=false, updatable=false)
	private int humanId;

	private String teg;

	public TopTegPK() {
	}
	public int getHumanId() {
		return this.humanId;
	}
	public void setHumanId(int humanId) {
		this.humanId = humanId;
	}
	public String getTeg() {
		return this.teg;
	}
	public void setTeg(String teg) {
		this.teg = teg;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TopTegPK)) {
			return false;
		}
		TopTegPK castOther = (TopTegPK)other;
		return 
			(this.humanId == castOther.humanId)
			&& this.teg.equals(castOther.teg);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.humanId;
		hash = hash * prime + this.teg.hashCode();
		
		return hash;
	}
}