package com.example.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.SiteUserRepository;


/*このクラスは、新規登録の時に同じ名前を登録できないようにするクラス。
同じ名前を登録しようとすると、注意メッセージを表示する*/

//自作でvalidationを作成する場合、ConstraintValidatorインターフェースを実装する
public class UniqueLoginValidator implements ConstraintValidator<UniqueLogin, String> {

	private final SiteUserRepository userRepository;//リポシトリの中にあるか

	public UniqueLoginValidator() {
		this.userRepository = null;//nullを入れておく
	}

	@Autowired//上にコンストラクタが１こあるので@Autowired必須
	public UniqueLoginValidator(SiteUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override //チェックエラーの場合、falseを返すようにしている
	//isValidの引数には、Formクラスが渡される
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return userRepository == null || userRepository.findByUsername(value) == null;
	}

}
