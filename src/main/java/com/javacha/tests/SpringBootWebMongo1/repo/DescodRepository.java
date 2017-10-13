package com.javacha.tests.SpringBootWebMongo1.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.javacha.tests.SpringBootWebMongo1.beans.Descod;

public interface DescodRepository  extends PagingAndSortingRepository<Descod, Integer> {

		public List<Descod> findAllByTabla(Integer tabla);
		public Page<Descod> findAllByTabla(Integer tabla, Pageable pageable);

		public Descod findByTablaAndCodigo(Integer tabla, Integer codigo);
	
		
		@Query("{ 'tabla' : ?0, 'descripcion':{$regex:?1,$options:'i'} }") 
		List<Descod> findByTablaAndDescripcion(Integer tabla, String descripcion);
					
		
		
}
