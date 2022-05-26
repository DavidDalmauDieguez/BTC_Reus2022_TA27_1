package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {
	@ManyToOne
	@JoinColumn(name="codigoPieza")
	private int codigoPieza;	
	@ManyToOne
	@JoinColumn(name="idProveedor")
	private char idProveedor;
	@Column(name="precio")
	private int precio;
	
	//Constructores
	public Suministra() {
		
	}

	public Suministra(int codigoPieza, char idProveedor, int precio) {
		this.codigoPieza = codigoPieza;
		this.idProveedor = idProveedor;
		this.precio = precio;
	}

	// Getters y Setter
	public int getCodigoPieza() {
		return codigoPieza;
	}

	public void setCodigoPieza(int codigoPieza) {
		this.codigoPieza = codigoPieza;
	}

	public char getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(char idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	// Creacion toString
	@Override
	public String toString() {
		return "Suministra [codigoPieza=" + codigoPieza + ", idProveedor=" + idProveedor + ", precio=" + precio + "]";
	}
}
