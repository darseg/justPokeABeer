package com.darseg.justPokeABeer.dbo;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "bar")
public class BarDBO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid")
	private Long bid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;

	@OneToMany(mappedBy = "bar")
	private List<BarContactDBO> contacts = new ArrayList<>();

	@OneToMany(mappedBy = "bar")
	private List<BarImagesDBO> images = new ArrayList<>();;

	@OneToMany(mappedBy = "bar")
	private List<BarScheduleDBO> schedules = new ArrayList<>();;
}