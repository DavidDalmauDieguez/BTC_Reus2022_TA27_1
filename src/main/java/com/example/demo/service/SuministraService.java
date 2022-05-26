package com.example.demo.service;

import java.util.List;


import com.example.demo.dto.Suministra;

public interface SuministraService {
	public List<Suministra> listarSuministra();

	public Suministra crearSuministra(Suministra suministra);

	public Suministra modificarSuministra(Suministra suministra);

	public void eliminarSuministra(Long id);

	public Suministra buscarSuministra(Long id);
}
