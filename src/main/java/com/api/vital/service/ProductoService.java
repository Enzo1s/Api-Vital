package com.api.vital.service;

import java.util.List;

import com.api.vital.models.entity.Producto;

public interface ProductoService extends CommonService<Producto> {
	
	public List<Producto> findByNombre(String term);
	
	public List<Producto> findByTipo(String term);
		
	public Iterable<Producto> findAllById(Iterable<Long> ids);

}
