package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ProveedoresDAO;
import com.example.demo.dto.Proveedores;

public class ProveedoresServiceImpl implements ProveedoresService{
	// Utilizar metodos DAO heredados de JPA
	@Autowired
	ProveedoresDAO proveedoresDao;

	@Override
	public List<Proveedores> listarProveedores() {
		return proveedoresDao.findAll();
	}

	@Override
	public Proveedores crearProveedores(Proveedores proveedores) {
		return proveedoresDao.save(proveedores);
	}

	@Override
	public Proveedores modificarProveedores(Proveedores proveedores) {
		return proveedoresDao.save(proveedores);
	}

	@Override
	public void eliminarProveedores(Long id) {
		proveedoresDao.deleteById(id);
		
	}

	@Override
	public Proveedores buscarProveedores(Long id) {
		return proveedoresDao.findById(id).get();
	}	
}
