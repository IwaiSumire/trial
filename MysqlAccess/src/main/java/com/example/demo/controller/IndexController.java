package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoMapper;

@Controller
public class IndexController {

	@Autowired
	UserInfoMapper userInfoMapper;

	@RequestMapping
	public String index(Model model) {
		List<UserInfo> list = userInfoMapper.selectAll();
		model.addAttribute("userInfo", list);
		return "index";
	}
}