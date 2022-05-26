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

import com.example.demo.dto.Proveedores;
import com.example.demo.dto.Suministra;
import com.example.demo.service.SuministraServiceImpl;

@RestController
@RequestMapping("/api") //Raiz de la app
public class SuministraController {
	@Autowired
	SuministraServiceImpl suministraServiceImpl;

	// Listar todas las suministra
	@GetMapping("/suministra")
	public List<Suministra> listarProveedores(){
		return suministraServiceImpl.listarSuministra();
	}


	// Buscar las proveedores por id
	@GetMapping("/suminastra/{id}")
	public Suministra buscarSuministraCodigo(@PathVariable(name= "codigoPieza")Long id) {
		return suministraServiceImpl.buscarSuministra(id);		
	}	

	// Eliminar una proveedores
	@GetMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name="id")Long id) {
		suministraServiceImpl.eliminarSuministra(id);
	}

	// Crear piezas
	@PostMapping("/suministra")
	public Suministra crearSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImpl.crearSuministra(suministra);
	}

	// Modificar sala
	@PutMapping("/suministra/{codigoPieza}")
	public Suministra modificarSuministra (@PathVariable(name="codigoPieza")Long id, @RequestBody Suministra suministra) {
		Suministra suministra_a_modificar = new Suministra();
		Suministra modificado = new Suministra();

		// Busco el id de la sala que quiero cambiar
		suministra_a_modificar = suministraServiceImpl.buscarSuministra(id);

		suministra_a_modificar.setCodigoPieza(suministra.getCodigoPieza());
		suministra_a_modificar.setIdProveedor(suministra.getIdProveedor());
		suministra_a_modificar.setPrecio(suministra.getPrecio());

		// Modificado es = a los cambios aplicados
		modificado = suministraServiceImpl.modificarSuministra(suministra_a_modificar);

		return modificado;
	}
}