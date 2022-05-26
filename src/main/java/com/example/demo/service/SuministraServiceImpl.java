package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.SuministraDAO;
import com.example.demo.dto.Suministra;

public class SuministraServiceImpl implements SuministraService{
	// Utilizar metodos DAO heredados de JPA
	@Autowired
	SuministraDAO suministraDao;

	@Override
	public List<Suministra> listarSuministra() {
		return suministraDao.findAll();
	}

	@Override
	public Suministra crearSuministra(Suministra suministra) {
		return suministraDao.save(suministra);
	}

	@Override
	public Suministra modificarSuministra(Suministra suministra) {
		return suministraDao.save(suministra);
	}

	@Override
	public void eliminarSuministra(Long id) {
		suministraDao.deleteById(id);
		
	}

	@Override
	public Suministra buscarSuministra(Long id) {
		return suministraDao.findById(id).get();
	}
}
