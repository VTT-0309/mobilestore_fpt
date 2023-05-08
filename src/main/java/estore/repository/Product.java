package estore.repository;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name = "unitprice")
	private Double unitPrice;	
	private String image = "new.png";	
	@Column(name = "unitsinstock")
	private Integer unitsInStock = 1;
	private String description;
	private String manufacturer;
	
	
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;	
	
	@ManyToOne 
	@JoinColumn(name = "conditionid")
	private Condition condition;	
		
	public double getPromotePrice() {
		return this.unitPrice;
	}
}
