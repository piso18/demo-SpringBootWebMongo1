package com.javacha.tests.SpringBootWebMongo1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javacha.tests.SpringBootWebMongo1.beans.Descod;
import com.javacha.tests.SpringBootWebMongo1.repo.DescodRepository;




@RestController
@RequestMapping("/descod")
public class DescodController {

	
	@Autowired
	DescodRepository descodRepository;	
	
	/**
	 * Lista descod por nro de tabla
	 * @param tabla
	 * @return
	 */
    @RequestMapping(value = "/{tabla}",  method = RequestMethod.GET)
    public List<Descod> listDescodByTabla(@PathVariable int tabla) {
        return descodRepository.findAllByTabla(tabla); 
    }	
	
	/**
	 * Lista descod por nro de tabla con paginado. <br> Ejemplos<br>   http://localhost:8080//descod/1?page=2&size=10
	 * <br> http://localhost:8080//descod/1?page=0&size=10&sort=descripcion,desc&sort=codigo
	 * @param tabla
	 * @return
	 */
    @RequestMapping(value = "{tabla}",  params = { "page" },  method = RequestMethod.GET)
    public Page<Descod> listDescodByTablaPag(@PathVariable int tabla, Pageable pageable) {
        return descodRepository.findAllByTabla(tabla, pageable); 
    } 
    
    /*
    @RequestMapping(value = "/{tabla}",  params = { "page"},  method = RequestMethod.GET)
    public Page<Descod> listDescodByTablaPag(@PathVariable int tabla, @PageableDefault(size = 50) Pageable pageable) {
        return descodRepository.findAllByTabla(tabla, pageable); 
    }
    */
    
    /**
     * Obtiene codigo puntual de una tabla
     * @param tabla
     * @param codigo
     * @return
     */
   
    @RequestMapping(value = "/{tabla}/codigo/{codigo}",  method = RequestMethod.GET)
    public Descod getDescodByTablaCodigo(@PathVariable int tabla, @PathVariable int codigo) {
        return descodRepository.findByTablaAndCodigo(tabla, codigo); 
    }	

    
 
    @RequestMapping(value = "/{tabla}/descrip/{desc}",  method = RequestMethod.GET)
    public List<Descod> listDescodByTablaDescripcion(@PathVariable int tabla, @PathVariable String desc) {
        return descodRepository.findByTablaAndDescripcion(tabla, desc);
    }	
	     
}
