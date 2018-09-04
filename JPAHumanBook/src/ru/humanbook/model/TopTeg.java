package ru.humanbook.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the top_teg database table.
 * 
 */
@Entity
@Table(name="top_teg")
@NamedQuery(name="TopTeg.findAll", query="SELECT t FROM TopTeg t")
public class TopTeg implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TopTegPK id;

	//bi-directional many-to-one association to Human
	@ManyToOne
	@JoinColumn(name="human_id")
	private Human human;

	public TopTeg() {
	}

	public TopTegPK getId() {
		return this.id;
	}

	public void setId(TopTegPK id) {
		this.id = id;
	}

	public Human getHuman() {
		return this.human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

}