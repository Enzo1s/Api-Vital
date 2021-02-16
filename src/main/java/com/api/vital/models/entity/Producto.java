package com.api.vital.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@NotEmpty
	private String nombre;
	
	//@NotEmpty
	private float precio;
	
	@ElementCollection
	private List<String> tipo= new ArrayList<String>();
	
	private String descripcion;
	
	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@Lob
	@JsonIgnore
	private byte[] foto;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	/*public Producto() {
		this.tipo = new ArrayList<>();
	}*/
	
	public Integer getFotoHshCode() {
		return (this.foto != null) ? this.foto.hashCode():null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public List<String> getTipo() {
		return tipo;
	}

	public void setTipo(List<String> tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getEdited() {
		return createAt;
	}

	public void setEdited(Date createAt) {
		this.createAt = createAt;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public boolean isTheType(String tipo) {
		if(this.tipo.contains(tipo)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(!(obj instanceof Producto)) {
			return false;
		}
		Producto p = (Producto) obj;
		return this.id != null && this.id.equals(p.getId());
	}
}
