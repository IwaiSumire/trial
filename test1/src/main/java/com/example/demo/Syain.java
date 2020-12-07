package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Syain {

	@Id
	private Integer id;
	private String last_name;
	private String first_name;


}
