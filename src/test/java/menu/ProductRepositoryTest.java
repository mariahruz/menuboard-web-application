package menu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= {RepositoryConfiguration.class})
public class ProductRepositoryTest {
	
	private ProductRepository repository;
	
	@Autowired
	public void setProductRepository(ProductRepository repository) {
		this.repository = repository;
	}
	
	@Test
	public void testProductRepository(){
		
		//add new product to repository
		Product product = new Product();
		product.setName("Tuscan Chicken Sandwich");
		product.setComboPrice(7.89);
		product.setEachPrice(4.59);
		product.setAvailable(true);
		product.setImage("/images/Tuscan_Chicken.png");
		repository.save(product);
		
		//test if saving product gave it an id
		assertNotNull(product.getId());
		
		//change name
		product.setName("Chicken Club");
		repository.save(product);
		
		//test if database updated name
		Product fromDB = repository.findOne(product.getId());
		assertEquals(fromDB.getName(), product.getName());
		
		//add another product to repository
		Product newProduct = new Product();
		newProduct.setName("Oatmeal");
		newProduct.setComboPrice(4.99);
		newProduct.setEachPrice(2.49);
		newProduct.setAvailable(true);
		newProduct.setImage("/images/Oatmeal.png");
		repository.save(newProduct);
		
		//check that ids are in fact unique
		assertNotEquals(newProduct.getId(), product.getId());
		
		//verify that there are 2 entries in db now
		long count = repository.count();
		assertEquals(count, 2);
		
		//remove first product from db
		repository.delete(product.getId());
		long newCount = repository.count();
		assertEquals(newCount, 1);
		
		//assure correct product was removed
		assertNotNull(repository.findOne(newProduct.getId()));
		assertNull(repository.findOne(product.getId()));
		
		
	}
	
}
