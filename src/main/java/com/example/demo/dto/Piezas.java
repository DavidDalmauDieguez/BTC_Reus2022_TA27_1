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
@Table(name="piezas")
public class Piezas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor y lo incrementa
	private Long codigo;
	@Column(name="nombre")
	private String nombre;

	// One to many
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Suministra> suministra;

	//Constructores
	public Piezas() {

	}

	public Piezas(Long codigo, String nombre, List<Suministra> suministra) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	@Override
	public String toString() {
		return "Piezas [codigo=" + codigo + ", nombre=" + nombre + ", suministra=" + suministra + "]";
	} 
}
