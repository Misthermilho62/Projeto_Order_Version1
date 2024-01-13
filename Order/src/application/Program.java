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
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String nameClient = sc.nextLine();
		System.out.print("Email: ");
		String emailClient = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDateClient = sdf.parse(sc.next());
		
		Client client = new Client(nameClient, emailClient, birthDateClient);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String statusOrder = sc.next();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(statusOrder), client);
		
		System.out.print("How many items to this order? ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);
			OrderItem orderItem = new OrderItem(quantityProduct, priceProduct, product);
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();

	}

}
