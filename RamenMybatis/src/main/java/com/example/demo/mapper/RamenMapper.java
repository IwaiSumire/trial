package com.example.demo.mapper;

import java.util.List

import com.example.demo.domein.Ramen;

@Mapper
public interface RamenMapper {

	//全件取得
	@Select("select * froms ramen")
	List<Ramen> findAll();

	@Select("select * from ramen where id = #{id}")
	Ramen findOne(Long id);

	@Insert("insert into ramen (shop, type, star) values (#{shop}, #{type}, #{star})")
	@Options(useGeneratedKeys = true)
	void save(Ramen ramen);

	@Update("update ramen set shop = #{shop}, type = #{type}, star = #{star} where id = #{id}")
	void update(Ramen ramen);

	@Delete("delete from ramen where id = #{id}")
	void delete(Long id);

}
