package jacalix.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
public class View implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	@OneToOne   
	@JoinColumn(name = "product_id")
	private Product productViewed;
	private LocalDate startView;
	private LocalDate endView;
	
	public View() {
		super();
	}

	public View(int id,Product productViewed, LocalDate startView, LocalDate endView) {
		super();
		this.id = id;
		this.productViewed = productViewed;
		this.startView = startView;
		this.endView = endView;
	}

	public Product getProductViewed() {
		return productViewed;
	}

	public void setProductViewed(Product productViewed) {
		this.productViewed = productViewed;
	}

	public LocalDate getStartView() {
		return startView;
	}

	public void setStartView(LocalDate startView) {
		this.startView = startView;
	}

	public LocalDate getEndView() {
		return endView;
	}

	public void setEndView(LocalDate endView) {
		this.endView = endView;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
}
