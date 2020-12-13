package com.example.demo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ShainForm {

	//空でないことをチェックするアノテーション
@NotEmpty(message = " 社員Noを入れてくださいね")
@Pattern(regexp = "\\d{3}", message = "半角の数字、３桁で入力してください")
private String number;

//NOをチャックする
public String getNumber() {
return number;
}

public void setNumber(String number) {
this.number = number;
}

}