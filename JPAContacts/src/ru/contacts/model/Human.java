package ru.contacts.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;


/**
 * The persistent class for the human database table.
 * 
 */
@Entity
@NamedQuery(name="Human.findAll", query="SELECT h FROM Human h")
public class Human implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="human_id")
	private int humanId;

	private String email;

	private String fname;

	private String lname;

	private BigInteger tel;

	//bi-directional many-to-one association to TopPlace
	@OneToMany(mappedBy="human")
	private List<TopPlace> topPlaces;

	public Human() {
	}

	public int getHumanId() {
		return this.humanId;
	}

	public void setHumanId(int humanId) {
		this.humanId = humanId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public BigInteger getTel() {
		return this.tel;
	}

	public void setTel(BigInteger tel) {
		this.tel = tel;
	}

	public List<TopPlace> getTopPlaces() {
		return this.topPlaces;
	}

	public void setTopPlaces(List<TopPlace> topPlaces) {
		this.topPlaces = topPlaces;
	}

	public TopPlace addTopPlace(TopPlace topPlace) {
		getTopPlaces().add(topPlace);
		topPlace.setHuman(this);

		return topPlace;
	}

	public TopPlace removeTopPlace(TopPlace topPlace) {
		getTopPlaces().remove(topPlace);
		topPlace.setHuman(null);

		return topPlace;
	}

}