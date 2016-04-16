package com.math10.pastetext.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paste_text")
public class PasteText {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	Integer id;

	@Column(name = "username", nullable = false)
	String userName;

	@Column(name = "title", nullable = false)
	String title;

	@Column(name = "content", nullable = false)
	String text;

	public PasteText() {
	}

	public PasteText(Integer id, String userName, String title, String text) {
		this.id = id;
		this.userName = userName;
		this.title = title;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(Integer l) {
		this.id = l;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
