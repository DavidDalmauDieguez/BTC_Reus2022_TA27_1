package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Proveedores;

//Repositorio de funcion es de base de datos
public interface ProveedoresDAO extends JpaRepository<Proveedores,Long>{

}
