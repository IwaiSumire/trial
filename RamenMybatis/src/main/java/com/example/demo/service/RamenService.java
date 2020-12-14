package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domein.Ramen;
import com.example.demo.mapper.RamenMapper;

@Service
public class RamenService {

	@Autowired
	private RamenMapper ramenMapper;

	@Transactional
	public List<Ramen> findAll() {
		return ramenMapper.findAll();
	}

	@Transactional
	public Ramen findOne(Long id) {
		return ramenMapper.findOne(id);
	}

	@Transactional
	public void save(Ramen ramen) {
		ramenMapper.save(ramen);
	}

	@Transactional
	public void update(Ramen ramen) {
		ramenMapper.update(ramen);
	}

	@Transactional
	public void delete(Long id) {
		ramenMapper.delete(id);
	}
}
