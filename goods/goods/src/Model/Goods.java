package Model;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer count;
	private Double price;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(Integer id, String name, Integer count, Double price) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}