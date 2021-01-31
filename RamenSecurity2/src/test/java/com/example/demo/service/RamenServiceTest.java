package com.example.demo.service;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Ramen;
import com.example.demo.mapper.RamenMapper;

@SpringBootTest
class RamenServiceTest {

	@Mock
	RamenMapper ramenMapper;//偽物のMapper

	@InjectMocks
	RamenService ramenService;//サービスに偽物を入れてもらう

	@Test
	void Ramenテーブルから全件取得したらOK() {

		//★テストの準備
		List<Ramen> niseList = new ArrayList<Ramen>();

		Ramen niseRamen = new Ramen();

		Long id = (long) 1;

		niseList.set(1, id);
		niseList.set(niseRamen.getShop(), "つけ麺舞");


		niseList.add(niseRamen);//とりあえず偽リストに1件いれておく

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
	void  Ramenテーブルから指定した内容が取得できていたらOK() {

		List<Ramen> niseRamen = ramenService.selectOne(1);
		assertThat(niseRamen.size(), is(1));


	}

	/*@Autowired
	RamenService ramenService;

	@Test
	void Ramenテーブルから全件取得したらOK() {

		List<Ramen> ramenList = ramenService.selectAll();
		assertThat(ramenList.size(), is(1));
		assertThat(ramenList.size(), not(0));//0件ではないよ
	}

	@Test
	void Ramenテーブルから指定した内容が取得できていたらOK() {

		Ramen ramen = ramenService.selectOne((long) 1);

		assertThat(ramen.getId(), is((long) 1));
		assertThat(ramen.getShop(), is("つけ麺舞"));
		assertThat(ramen.getPerson(), is("すみれ"));

	}
	*/

}
