package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@GetMapping("/suministra/{id}")
	public Suministra buscarSuministraCodigo(@PathVariable(name= "id") Long id) {
		return suministraServiceImpl.buscarSuministra(id);		
	}	

	// Eliminar una proveedores
	@DeleteMapping("/suministra/{id}")
	public void eliminarSuministra(@PathVariable(name="id")Long id) {
		suministraServiceImpl.eliminarSuministra(id);
		System.out.println("Se ha eliminado el suministro "+ id + " statisfactoriamente");
	}

	// Crear piezas
	@PostMapping("/suministra")
	public Suministra crearSuministra(@RequestBody Suministra suministra) {
		return suministraServiceImpl.crearSuministra(suministra);
	}

	// Modificar sala
	@PutMapping("/suministra/{id}")
	public Suministra modificarSuministra (@PathVariable(name="id")Long id, @RequestBody Suministra suministra) {
		Suministra suministra_a_modificar = new Suministra();
		Suministra modificado = new Suministra();

		// Busco el id de la sala que quiero cambiar
		suministra_a_modificar = suministraServiceImpl.buscarSuministra(id);
		suministra_a_modificar.setId(suministra.getId());
		suministra_a_modificar.setPiezas(suministra.getPiezas());
		suministra_a_modificar.setProveedores(suministra.getProveedores());
		suministra_a_modificar.setPrecio(suministra.getPrecio());

		// Modificado es = a los cambios aplicados
		modificado = suministraServiceImpl.modificarSuministra(suministra_a_modificar);

		return modificado;
	}
}