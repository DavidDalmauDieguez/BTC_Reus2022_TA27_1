package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Piezas;
import com.example.demo.service.PiezasServiceImpl;

@RestController
@RequestMapping("/api") //Raiz de la app
public class PiezasController {
	@Autowired
	PiezasServiceImpl piezasServiceImpl;

	// Listar todas las piezas
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		return piezasServiceImpl.listarPiezas();
	}

	// Buscar las piezas por id
	@GetMapping("/piezas/{id}")
	public Piezas buscarPiezaCodigo(@PathVariable(name= "id")Long codigo) {
		return piezasServiceImpl.buscarPiezas(codigo);		
	}

	// Eliminar una piezas
	@GetMapping("/piezas/{id}")
	public void eliminarPiezas(@PathVariable(name="id")Long codigo) {
		piezasServiceImpl.eliminarPiezas(codigo);
	}

	// Crear piezas
	@PostMapping("/piezas")
	public Piezas crearPeliculas(@RequestBody Piezas piezas) {
		return piezasServiceImpl.crearPiezas(piezas);
	}

	// Modificar sala
	@PutMapping("/piezas/{id}")
	public Piezas modificarPiezas (@PathVariable(name="codigo")Long codigo, @RequestBody Piezas piezas) {
		Piezas pieza_a_modificar = new Piezas();
		Piezas modificado = new Piezas();

		// Busco el id de la sala que quiero cambiar
		pieza_a_modificar = piezasServiceImpl.buscarPiezas(codigo);

		pieza_a_modificar.setCodigo(piezas.getCodigo());
		pieza_a_modificar.setNombre(piezas.getNombre());
		pieza_a_modificar.setSuministra(piezas.getSuministra());

		// Modificado es = a los cambios aplicados
		modificado = piezasServiceImpl.modificarPiezas(pieza_a_modificar);

		return modificado;
	}
}
