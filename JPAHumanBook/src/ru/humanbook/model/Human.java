package ru.humanbook.model;

import java.io.Serializable;
import javax.persistence.*;
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
	@SequenceGenerator(name="HUMAN_HUMANID_GENERATOR", sequenceName="ORDER_SEQUENCE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HUMAN_HUMANID_GENERATOR")
	@Column(name="human_id")
	private int humanId;

	private String email;

	private String fname;

	private String lname;

	private String tel;

	//bi-directional many-to-one association to TopTeg
	@OneToMany(mappedBy="human")
	private List<TopTeg> topTegs;

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

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public List<TopTeg> getTopTegs() {
		return this.topTegs;
	}

	public void setTopTegs(List<TopTeg> topTegs) {
		this.topTegs = topTegs;
	}

	public TopTeg addTopTeg(TopTeg topTeg) {
		getTopTegs().add(topTeg);
		topTeg.setHuman(this);

		return topTeg;
	}

	public TopTeg removeTopTeg(TopTeg topTeg) {
		getTopTegs().remove(topTeg);
		topTeg.setHuman(null);

		return topTeg;
	}

}