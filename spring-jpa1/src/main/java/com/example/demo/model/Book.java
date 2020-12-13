package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity //データの入れ物であるエンティティ
public class Book {

	@Id //主キー
	@GeneratedValue //主キーの値を自動で取る
	private Long id;
	private String title;
	private String detail;

}
