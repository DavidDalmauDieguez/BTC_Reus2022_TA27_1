package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proveedores;

public interface ProveedoresService {
public List<Proveedores> listarProveedores();
	
	public Proveedores crearProveedores(Proveedores proveedores);

	public Proveedores modificarProveedores(Proveedores proveedores);

	public void eliminarProveedores(Long id);

	public Proveedores buscarProveedores(Long id);

}
