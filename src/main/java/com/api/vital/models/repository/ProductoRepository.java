package com.api.vital.models.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.api.vital.models.entity.Producto;

public interface ProductoRepository extends PagingAndSortingRepository<Producto, Long>{

	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByTipo(String term);
	
	public Iterable<Producto> findAllByOrderByIdAsc();
	
	public Page<Producto> findAllByOrderByIdAsc(Pageable pageable);
}
