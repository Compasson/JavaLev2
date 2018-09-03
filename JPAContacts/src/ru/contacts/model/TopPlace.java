package ru.contacts.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the top_place database table.
 * 
 */
@Entity
@Table(name="top_place")
@NamedQuery(name="TopPlace.findAll", query="SELECT t FROM TopPlace t")
public class TopPlace implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TopPlacePK id;

	//bi-directional many-to-one association to Human
	@ManyToOne
	@JoinColumn(name="human_id")
	private Human human;

	public TopPlace() {
	}

	public TopPlacePK getId() {
		return this.id;
	}

	public void setId(TopPlacePK id) {
		this.id = id;
	}

	public Human getHuman() {
		return this.human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

}