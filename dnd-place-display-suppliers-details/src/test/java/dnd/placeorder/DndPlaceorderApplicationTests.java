package dnd.placeorder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dnd.display.supplier.details.dao.SupplierDao;
import dnd.display.supplier.details.model.SupplierEntity;
import dnd.display.supplier.details.service.SupplierServiceImpl;

@SpringBootTest
public class DndPlaceorderApplicationTests {
	
   
    @Autowired
    private SupplierDao testRepo;
    @Autowired
   	private SupplierServiceImpl testService;
    
    SupplierEntity supplier1;
	
	@BeforeEach
	public void init() {
		supplier1=new SupplierEntity(120l,"Dhavalika","Kompally, Hyderabad",9493111539l);
		
	}
	@Test
	public void testAddDetails() {
		testService.addSupplierDetails(supplier1);
		assertEquals(true,testRepo.getSupplierById(supplier1.getSupplierId())!=null);
	}
	
//    public void getAllSupplierDetails() {
//    	
//    }
    
    
//	@Test
//	void contextLoads() {
//	}

}
