package menu;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	private double comboPrice;
	private double eachPrice;
	private boolean available;
	private String image;
	
	public Product() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getComboPrice() {
		return comboPrice;
	}
	
	public void setComboPrice(double price) {
		this.comboPrice = price;
	}
	
	public double getEachPrice() {
		return eachPrice;
	}
	
	public void setEachPrice(double price) {
		this.eachPrice = price;
	}
	
	public boolean getAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

}
