package com.example.demo;

public class ShainServiceImpl implements ShainService {

	@Override
	public String findByNo(String number) {
		//		repositoryから社員を選択
		//		引数のナンバーでNoに紐づいた名前をDBから引っ張ってくる
		ShainRepository shainRepository = new ShainRepositoryImpl();
		String name = shainRepository.selectByNo(number);

		return name;
	}

}
