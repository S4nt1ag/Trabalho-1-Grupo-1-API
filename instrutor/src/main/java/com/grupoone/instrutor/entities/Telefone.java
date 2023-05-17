package com.grupoone.instrutor.entities;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idTelefone"
        ) 
@Entity
@Table(name = "telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_telefone")
	private Integer idTelefone;
	
	@Column (name = "numero", unique = true)
	private Integer numero;
	
	@OneToOne
	@JoinColumn(name = "id_instrutor", referencedColumnName = "id_instrutor")
	private Instrutor idInstrutor;

	public Integer getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(Integer idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Instrutor getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Instrutor idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		return Objects.equals(numero, other.numero);
	}
}
