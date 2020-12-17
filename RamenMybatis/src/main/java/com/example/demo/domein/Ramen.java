package com.example.demo.domein;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data

public class Ramen {

	@NotNull
	private Long id;

	@NotBlank(message = "入力してください")
	private String shop;

	@NotBlank
	private String type;

	@NotBlank
	private String star;

}
