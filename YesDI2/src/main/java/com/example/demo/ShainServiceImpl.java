package com.example.demo;

import org.springframework.stereotype.Service;


@Service //service層
public class ShainServiceImpl implements ShainService {

	//インスタンス化みたいな感じ
	private final ShainRepository shainRepository;

	//ShainRepositoryのDI化
	public ShainServiceImpl(ShainRepository shainRepository) {
		this.shainRepository = shainRepository;
	}

	@Override //実装
	public String findByNo(String number) {
		//リポジトリから社員を検索して名前を出す
		String name = shainRepository.selectByNo(number);
		return name;
	}

}
