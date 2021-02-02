package com.example.demo.service;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Ramen;
import com.example.demo.mapper.RamenMapper;

@SpringBootTest
class RamenServiceTest {

	List<Ramen> niseList = new ArrayList<Ramen>();
	Ramen niseRamen = new Ramen();

	@BeforeEach
	void 準備() {

		niseRamen.setId((long) 1);
		niseRamen.setShop("つけ麺舞");
		niseRamen.setType("豚骨");
		niseRamen.setPerson("すみれ");
		niseRamen.setDay("2021/12/1");
		niseRamen.setPic("xxxxxx");
		niseRamen.setStar("★★");

		niseList.add(niseRamen);

	}

	@Mock
	RamenMapper ramenMapper;//偽物のMapper

	@InjectMocks
	RamenService ramenService;//サービスに偽物を入れてもらう

	@Test
	void Ramenテーブルから全件取得したらOK() {

		//★テストの準備
		//List<Ramen> niseList = new ArrayList<Ramen>();

		//Ramen niseRamen = new Ramen();

		//niseList.add(niseRamen);//とりあえず偽リストに1件いれておく

		//もし、偽マッパーで全件取ってくると指示があれば、偽物の内容を返してください

		when(ramenMapper.selectAll()).thenReturn(niseList);
		//★テスト
		//listに探してきた全件を入れる
		List<Ramen> list = ramenService.selectAll();

		//listは１件だよね？
		assertThat(list.size(), is(1));
		assertThat(list.size(), not(0));

	}

	@Test
	void Ramenテーブルから指定した内容が取得できていたらOK() {

		when(ramenMapper.selectOne((long) 1)).thenReturn(niseRamen);


		Ramen ramenSelectOne = ramenService.selectOne((long) 1);
		assertThat(ramenSelectOne.getPerson(), is("すみれ"));
		assertThat(ramenSelectOne.getShop(), is("つけ麺舞"));



	}

	/*@Autowired
	RamenService ramenService;

	@Test
	void Ramenテーブルから全件取得したらOK() {

		List<Ramen> ramenList = ramenService.selectAll();
		assertThat(ramenList.size(), is(1));
		assertThat(ramenList.size(), not(0));//0件ではないよ
	}
	*/

}
