package com.example.demo.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Ramen {

	private Long id;

	@NotBlank(message = "入力してください")
	@Size(min = 1, max = 10, message = "1～10文字以内で入力してください")
	private String shop;

	@NotBlank(message = "入力してください")
	@Size(min = 1, max = 10, message = "1～10文字以内で入力してください")
	private String type;


	@Pattern(regexp = "[★|★★|★★★|★★★★|★★★★★]")
	private String star;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@NotBlank(message = "入力してください")
	private String day;

	@NotBlank(message = "名前を入力してください")
	@Size(min = 1, max = 5, message = "1～5文字以内で入力してください")
	private String person;


	private String pic;

}
