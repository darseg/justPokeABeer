package com.darseg.justPokeABeer.dbo;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bar")
public class BarDBO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bid")
	private Long bid;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phones")
	private String phones;
}