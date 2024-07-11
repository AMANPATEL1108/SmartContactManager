package com.smart.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 7163995774342352692L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Ensure this is set to IDENTITY
	private int id;

	@Size(max = 500, message = "About can be at most 500 characters long")
	private String about;

	@NotBlank(message = "Email is required")
	@Email(message = "Email should be valid")
	@Column(unique = true)
	private String email;

	@Column(name = "enabled") // Map to the 'enabled' column in your database
	private boolean enabled;

	@Column(name = "image_url") // Map to the 'image_url' column in your database
	private String imageUrl;

	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
	private String name;

	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password should be at least 6 characters long")
	private String password;

	private String role;

	@Column(name = "enable") // Map to the 'enable' column in your database
	private boolean enable;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contact> contacts = new ArrayList<>();

	// Default constructor
	public User() {}

	// Parameterized constructor
	public User(int id, String name, String email, String password, String role, boolean enable, String imageUrl, String about) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.enable = enable;
		this.imageUrl = imageUrl;
		this.about = about;
	}

	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role=" + role
				+ ", enable=" + enable + ", imageUrl=" + imageUrl + ", about=" + about + ", contacts=" + contacts + "]";
	}
}
