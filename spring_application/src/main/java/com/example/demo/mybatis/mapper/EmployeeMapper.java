package com.example.demo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Employee;

@Mapper
public interface EmployeeMapper {

	@Select("select * from employee where name = #{name} limit 1")
	Employee selectByName(String name);


}
