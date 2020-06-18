package entities;

public class OrderItem {
	
	/* Declaracao de variaveis */
	private Integer quantity;
	private Double price;
	private Product product;
	
	/* Construtores */
	
	public OrderItem() {
	}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	/* Getters e Setters */
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	/* Operacao - subTotal*/
	
	public double subTotal() {
		return quantity*price;
	}
	
	public String toString() {
		return product.getName() +
				", $" +
				String.format("%.2f", product.getPrice()) +
				", Quantity: " +
				quantity +
				", Subtotal: $" +
				String.format("%.2f", subTotal()); 
				
	}

}
