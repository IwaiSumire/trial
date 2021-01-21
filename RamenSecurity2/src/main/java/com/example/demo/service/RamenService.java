package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Ramen;
import com.example.demo.mapper.RamenMapper;

@Service
public class RamenService {

	@Autowired
	private RamenMapper ramenMapper;

	@Transactional
	public List<Ramen> selectAll() {
		return ramenMapper.selectAll();
	}

	@Transactional
	public Ramen selectOne(Long id) {
		return ramenMapper.selectOne(id);
	}

	@Transactional
	public void insert(Ramen ramen) {
		ramenMapper.insert(ramen);
	}

	@Transactional
	public int update(Ramen ramen) {
		return ramenMapper.update(ramen);
	}

	@Transactional
	public void delete(Long id) {
		ramenMapper.delete(id);
	}

	@Transactional
	public List<Ramen> serchShopId(String sShop) {
		return ramenMapper.serchShopId(sShop);
	}


}
