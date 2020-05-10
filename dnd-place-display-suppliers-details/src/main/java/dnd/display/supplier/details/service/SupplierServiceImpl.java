package dnd.display.supplier.details.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dnd.display.supplier.details.dao.SupplierDao;
import dnd.display.supplier.details.exceptions.SupplierWithIdNotFoundException;
import dnd.display.supplier.details.exceptions.SupplierWithThisIdAlreadyExistException;
import dnd.display.supplier.details.exceptions.SuppliersListIsEmptyException;
import dnd.display.supplier.details.model.SupplierEntity;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	SupplierDao repo;
	

	public SupplierEntity addSupplierDetails(SupplierEntity details) {
		if(repo.existsById(details.getSupplierId())) {
			throw new SupplierWithThisIdAlreadyExistException(" Supplier with this Id already exist");
		}
		repo.save(details);
		return null;
	}

	public boolean deleteSupplierDetails(Long supplierId) {
		if(!repo.existsById(supplierId)) {
			throw new SupplierWithIdNotFoundException("Supplier with this id is not found");
		}
		repo.deleteById(supplierId);
		 return !(repo.existsById(supplierId));
	}

	public SupplierEntity getSupplierDetailsById(Long supplierId) {
		if(!repo.existsById(supplierId)) {
		throw new SupplierWithIdNotFoundException("Supplier with Id : ["+supplierId+"] Not Found");
	}
		return repo.getOne(supplierId);
		
	}

	public List<SupplierEntity> getAllSupplierDetails() {	
		if(repo.findAll().isEmpty()) {
			throw new SuppliersListIsEmptyException("List is empty");
		}
		return repo.findAll();
	}

	public SupplierEntity updateSupplierDetails(SupplierEntity newdetails) {
		SupplierEntity olddetails = repo.getOne(newdetails.getSupplierId());
		olddetails.setName(newdetails.getName());
		olddetails.setAddress(newdetails.getAddress());
		olddetails.setphoneNo(newdetails.getphoneNo());
		return olddetails;
	}
	
	
}
