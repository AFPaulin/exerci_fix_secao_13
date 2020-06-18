package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthdate = sdf.parse(sc.next());
		
		Client client = new Client(clientName,emailClient,birthdate); 
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order (new Date(),status,client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for (int i=1 ;i<=n;i++) {
			System.out.printf("Enter #%d item data:\n",i );
			System.out.print("Product name: ");
			String productName = sc.next(); 
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			OrderItem item = new OrderItem(quantityProduct,priceProduct,new Product(productName,priceProduct));
			order.addItem(item);
		}
		
		System.out.println();
		System.out.print(order);
		
		sc.close();
	}

}
