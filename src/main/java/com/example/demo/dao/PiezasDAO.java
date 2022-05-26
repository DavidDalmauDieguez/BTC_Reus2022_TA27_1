package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Piezas;

//Repositorio de funcion es de base de datos
public interface PiezasDAO extends JpaRepository<Piezas,Long>{

}
