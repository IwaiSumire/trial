package com.example.demo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

//validation
@Data
public class ShainForm {

	@NotEmpty(message = " 社員Noを入れてくださいね")
	@Pattern(regexp = "\\d{3}", message = "半角数字３桁で入力してください")
	private String number;

}