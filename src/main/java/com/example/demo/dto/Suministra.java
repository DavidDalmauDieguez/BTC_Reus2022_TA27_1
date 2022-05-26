package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministra")
public class Suministra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="codigo_pieza")
	private Piezas piezas;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedores proveedores;
	
	@Column(name="precio")
	private int precio;
	
	//Constructores
	public Suministra() {
		
	}

	/**
	 * @param id
	 * @param codigoPieza
	 * @param idProveedor
	 * @param precio
	 */
	public Suministra(Long id, Piezas piezas, Proveedores proveedores, int precio) {
		super();
		this.id = id;
		this.piezas = piezas;
		this.proveedores = proveedores;
		this.precio = precio;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the piezas
	 */
	public Piezas getPiezas() {
		return piezas;
	}

	/**
	 * @param piezas the piezas to set
	 */
	public void setPiezas(Piezas piezas) {
		this.piezas = piezas;
	}

	/**
	 * @return the proveedores
	 */
	public Proveedores getProveedores() {
		return proveedores;
	}

	/**
	 * @param proveedores the proveedores to set
	 */
	public void setProveedores(Proveedores proveedores) {
		this.proveedores = proveedores;
	}

	/**
	 * @return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

}