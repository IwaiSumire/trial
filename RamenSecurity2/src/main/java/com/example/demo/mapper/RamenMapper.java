package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Ramen;

@Mapper
public interface RamenMapper {
	//インターフェース具体的な処理を書かない

	//全件取得
	@Select("select * from ramen")
	List<Ramen> selectAll();

	@Select("select * from ramen where id = #{id}")
	Ramen selectOne(Long id);

	@Insert("insert into ramen (shop, type, star,day,pic,person) values (#{shop}, #{type}, #{star},#{day},#{pic},#{person})")
	@Options(useGeneratedKeys = true)
	void insert(Ramen ramen);

	@Update("update ramen set shop = #{shop}, type = #{type}, star = #{star} , day = #{day} , pic = #{pic}, pserson = #{person} where id = #{id}")
	int update(Ramen ramen);

	@Delete("delete from ramen where id = #{id}")
	void delete(Long id);

	@Select("select * from ramen where shop collate utf8_unicode_ci like '%${sShop}%'")
	List<Ramen> serchShopId(String sShop);

}
