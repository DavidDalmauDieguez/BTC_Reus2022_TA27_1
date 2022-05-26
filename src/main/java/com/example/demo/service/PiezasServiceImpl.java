package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PiezasDAO;
import com.example.demo.dto.Piezas;

@Service
public class PiezasServiceImpl implements PiezasService{
	// Utilizar metodos DAO heredados de JPA
	@Autowired
	PiezasDAO piezasDao;

	@Override
	public List<Piezas> listarPiezas() {
		return piezasDao.findAll();
	}

	@Override
	public Piezas crearPiezas(Piezas piezas) {
		return piezasDao.save(piezas);
	}

	@Override
	public Piezas modificarPiezas(Piezas piezas) {
		return piezasDao.save(piezas);
	}

	@Override
	public void eliminarPiezas(Long codigo) {
		piezasDao.deleteById(codigo);
		
	}

	@Override
	public Piezas buscarPiezas(Long codigo) {
		return piezasDao.findById(codigo).get();
	}
	
	
}