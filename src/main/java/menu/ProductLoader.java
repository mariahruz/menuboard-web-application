package menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ProductLoader implements ApplicationListener<ContextRefreshedEvent> {
	
	private ProductRepository repository;
	
	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.repository = productRepository;
	}
	
	/*Load data on startup*/
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Product turkeyClub = new Product();
		turkeyClub.setName("Turkey Club");
		turkeyClub.setAvailable(true);
		turkeyClub.setComboPrice(7.89);
		turkeyClub.setEachPrice(4.99);
		turkeyClub.setImage("/images/Turkey_Club.png");
		repository.save(turkeyClub);
		
		Product soup = new Product();
		soup.setName("Chicken Noodle Soup");
		soup.setAvailable(true);
		soup.setComboPrice(6.49);
		soup.setEachPrice(3.89);
		soup.setImage("/images/Soup_Bowl.png");
		repository.save(soup);
		
		Product tuscan = new Product();
		tuscan.setName("Tuscan Chicken");
		tuscan.setAvailable(true);
		tuscan.setComboPrice(6.78);
		tuscan.setEachPrice(3.89);
		tuscan.setImage("/images/Tuscan_Chicken.png");
		repository.save(tuscan);
		
		Product wrap = new Product();
		wrap.setName("Grilled Chicken Wrap");
		wrap.setAvailable(true);
		wrap.setComboPrice(7.19);
		wrap.setEachPrice(4.59);
		wrap.setImage("/images/Grilled_Wrap.png");
		repository.save(wrap);
		
		Product donut = new Product();
		donut.setName("Chocolate dip donut");
		donut.setAvailable(true);
		donut.setEachPrice(1.00);
		donut.setImage("/images/Donut.png");
		repository.save(donut);
		
		Product oatmeal = new Product();
		oatmeal.setName("Berry Oatmeal");
		oatmeal.setAvailable(true);
		oatmeal.setComboPrice(4.99);
		oatmeal.setEachPrice(2.99);
		oatmeal.setImage("/images/Oatmeal.png");
		repository.save(oatmeal);
		
		Product breakfast = new Product();
		breakfast.setName("Breakfast Sandwich");
		breakfast.setAvailable(true);
		breakfast.setComboPrice(4.59);
		breakfast.setEachPrice(2.99);
		breakfast.setImage("/images/Breakfast_Sandwich.png");
		repository.save(breakfast);
		
		Product muffin = new Product();
		muffin.setName("Muffin");
		muffin.setAvailable(true);
		muffin.setEachPrice(1.19);
		muffin.setImage("/images/Muffin.png");
		repository.save(muffin);
		
	}
	
}