package ru.web.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the courses database table.
 * 
 */
@Entity
@NamedQuery(name="Courses.findAll", query="SELECT c FROM Courses c")
public class Courses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Lob
	private String description;

	private int length;

	private String title;

	public Courses() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}