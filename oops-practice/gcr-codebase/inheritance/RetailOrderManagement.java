package level1;

import java.util.*;

public class RetailOrderManagement {

//	Description: Create a multilevel hierarchy to manage orders, where Order is the base class, ShippedOrder is a subclass, and DeliveredOrder extends ShippedOrder.
//	Tasks:
//	Define a base class Order with common attributes like orderId and orderDate.
//	Create a subclass ShippedOrder with additional attributes like trackingNumber.
//	Create another subclass DeliveredOrder extending ShippedOrder, adding a deliveryDate attribute.
//	Implement a method getOrderStatus() to return the current order status based on the class level.

	public static void main(String[] args) {
		Order order = new Order(101, "02-01-2026");
		ShippedOrder shipped = new ShippedOrder(order, 124512);
		DeliveredOrder delivered = new DeliveredOrder(shipped, "28-01-2026");
		order.getOrderStatus();
		shipped.getOrderStatus();
		delivered.getOrderStatus();
	}
}

class Order {
	int orderID;
	String orderDate;
	String orderStatus = "Order Placed";

	Order(int orderID, String orderDate) {
		this.orderID = orderID;
		this.orderDate = orderDate;
	}

	Order(Order order) {
		this(order.orderID, order.orderDate);
	}

	void getOrderStatus() {
		System.out.println("Order Status: " + orderStatus);
	}
}

class ShippedOrder extends Order {
	int trackingNumber;

	public ShippedOrder(Order order, int trackingNumber) {
		super(order.orderID, order.orderDate);
		this.orderStatus = "Order Shipped";
		this.trackingNumber = trackingNumber;
	}

	void getOrderStatus() {
		System.out.println('\n' + "Order Status: " + orderStatus);
		System.out.println("Order Tracking Number: " + trackingNumber);
	}
}

class DeliveredOrder extends ShippedOrder {

	String deliveryDate;

	DeliveredOrder(ShippedOrder shipped, String deliveryDate) {
		super(shipped, shipped.trackingNumber);
		this.orderStatus = "Order Delivered";
		this.deliveryDate = deliveryDate;
	}

	void getOrderStatus() {
		System.out.println('\n' + "Order Status: " + orderStatus);
		System.out.println("Order Delivery Date: " + deliveryDate);
	}
}
