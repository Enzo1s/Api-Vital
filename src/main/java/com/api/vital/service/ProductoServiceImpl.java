package com.api.vital.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.vital.models.entity.Producto;
import com.api.vital.models.repository.ProductoRepository;

@Service
public class ProductoServiceImpl extends CommonServiceImpl<Producto, ProductoRepository> implements ProductoService {
	
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String term) {
		return repository.findByNombre(term);
	}

	@Override
	public Iterable<Producto> findAllById(Iterable<Long> ids) {
		return repository.findAllById(ids);
	}
	
	@Override
	@Transactional
	public void deleteById(Long id) {
		super.deleteById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		return repository.findAllByOrderByIdAsc();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Producto> findAll(Pageable pageable) {
		return repository.findAllByOrderByIdAsc(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByTipo(String term) {
		return repository.findByTipo(term);
	}	

}
