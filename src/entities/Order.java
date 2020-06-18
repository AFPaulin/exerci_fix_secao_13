package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat ("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	/* Variavel instanciada assim quando possui só item */
	private Client client;
	
	/* Variavel é instanciada assim quando ela possui varios itens */
	private List<OrderItem>  items = new ArrayList<>();
	
	/* Construtores */
	public Order () {
	}

	//// Lembrar que não deve se colocar no construtor a variavel de tipo lista 
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	/* Getters e Setters */
	
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	//// Construtor da lista deve ser alterado pela funcao add e remove não set
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	/* Operador total() */
	
	public double total() {
	double valueTotal = 0.0;	
		for (OrderItem oi : items) {
			valueTotal += oi.subTotal();	
		}
		return valueTotal;
	}
	
	/* To String */
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName());
		sb.append("(" + sdf1.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items:\n");
		for (OrderItem item: items) {
		sb.append(item + "\n");	
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
	
}
