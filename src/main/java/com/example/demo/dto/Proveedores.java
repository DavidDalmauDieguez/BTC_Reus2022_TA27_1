package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor y lo incrementa
	private Long id;

	@Column(name="nombre")
	private String nombre;

	// One to many
	@OneToMany
	@JoinColumn(name="id")
	private List<Suministra> suministra;
	
	//Constructores
	public Proveedores () {
		
	}

	public Proveedores(Long id, String nombre, List<Suministra> suministra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Suministra> getSuministra() {
		return suministra;
	}

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	// Creacion toString
	@Override
	public String toString() {
		return "Proveedores [id=" + id + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	}
	
	
}
