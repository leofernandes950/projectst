package com.leofaria.projectst.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leofaria.projectst.domain.Cliente;
import com.leofaria.projectst.dto.ClienteDTO;
import com.leofaria.projectst.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	private void updateData(Cliente newObj,Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpfOuCnpj(obj.getCpfOuCnpj());
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEmail());
		newObj.setSexo(obj.getSexo());
		newObj.setTipo(obj.getTipo());
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(),objDto.getNome(),objDto.getCpfOuCnpj(),objDto.getEndereço(),objDto.getDataNascimento(),objDto.getDataCadastro(),objDto.getSexo(),objDto.getEmail(),objDto.getTipo());
	}
	
	
	

}
