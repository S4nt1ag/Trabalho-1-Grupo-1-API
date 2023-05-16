package com.grupoone.instrutor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoone.instrutor.entities.Telefone;
import com.grupoone.instrutor.repositories.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	TelefoneRepository telefoneRepository;

	public List<Telefone> getAllTelefones() {
		return telefoneRepository.findAll();
	}

	public Telefone getTelefoneById(Integer id) {
		return telefoneRepository.findById(id).orElse(null);
	}

	public Telefone saveTelefone(Telefone telefone) {
		return telefoneRepository.save(telefone);
	}

	public Telefone updateTelefone(Telefone telefone, Integer id) {
		return telefoneRepository.save(telefone);
	}

	public Boolean deleteTelefone(Integer id) {
		Telefone telefoneDeleted = telefoneRepository.findById(id).orElse(null);
		if (telefoneDeleted != null) {
			telefoneRepository.deleteById(id);
			telefoneDeleted = telefoneRepository.findById(id).orElse(null);
			if (telefoneDeleted != null) {
				return false;
			} 
			else {
				return true;
			}

		} 
		else {
			return false;
		}
	}
}
