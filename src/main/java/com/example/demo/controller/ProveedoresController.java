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
import com.example.demo.service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/api") //Raiz de la app
public class ProveedoresController {
	@Autowired
	ProveedoresServiceImpl proveedoresServiceImpl;

	// Listar todas las proveedores
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores(){
		return proveedoresServiceImpl.listarProveedores();
	}

	// Buscar las proveedores por id
	@GetMapping("/proveedores/{id}")
	public Proveedores buscarProveedorCodigo(@PathVariable(name= "id")Long id) {
		return proveedoresServiceImpl.buscarProveedores(id);		
	}

	// Eliminar una proveedores
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedores(@PathVariable(name="id")Long id) {
		proveedoresServiceImpl.eliminarProveedores(id);
		System.out.println("Se ha eliminado el proveedor "+ id + " statisfactoriamente");
	}

	// Crear piezas
	@PostMapping("/proveedores")
	public Proveedores crearproveedores(@RequestBody Proveedores proveedores) {
		return proveedoresServiceImpl.crearProveedores(proveedores);
	}

	// Modificar sala
	@PutMapping("/proveedores/{id}")
	public Proveedores modificarProveedores (@PathVariable(name="id")Long id, @RequestBody Proveedores proveedores) {
		Proveedores proveedores_a_modificar = new Proveedores();
		Proveedores modificado = new Proveedores();

		// Busco el id de la sala que quiero cambiar
		proveedores_a_modificar = proveedoresServiceImpl.buscarProveedores(id);

		proveedores_a_modificar.setId(proveedores.getId());
		proveedores_a_modificar.setNombre(proveedores.getNombre());

		// Modificado es = a los cambios aplicados
		modificado = proveedoresServiceImpl.modificarProveedores(proveedores_a_modificar);

		return modificado;
	}
}