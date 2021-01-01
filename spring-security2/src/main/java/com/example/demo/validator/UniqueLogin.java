package com.example.demo.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
//このアノテーションが使える場所を指定。メソッドをフィールとして使うことができる

@Retention(RetentionPolicy.RUNTIME)
//このアノテーションの保持機関を指定。RUNTIME＝いつでも使える

@Constraint(validatedBy = UniqueLoginValidator.class)
//インターフェースにつける。名前をインターフェースとして使える。
//バリデータクラスを指定

public @interface UniqueLogin {

	String message() default "このユーザ名は既に登録されています";//or{unique.message}

	Class<?>[] groups() default {};//自作validationを作るときの必須定義

	Class<? extends Payload>[] payload() default {};//自作validationを作るときの必須定義

}
