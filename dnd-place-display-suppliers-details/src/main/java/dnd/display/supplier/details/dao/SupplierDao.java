package dnd.display.supplier.details.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dnd.display.supplier.details.model.SupplierEntity;

public interface SupplierDao extends JpaRepository<SupplierEntity,Long>{

	SupplierEntity getSupplierById(long supplierId);
	
//	public SupplierEntity getSupplierById(long supplierId);

}
