package demo1;

import java.lang.reflect.Field;

public class SimpleBrowser {

	public static void main(String[] args) throws Exception {
		/*
		 * Field[] fields = ShippingOrder.class.getDeclaredFields(); for (int i
		 * = 0; i < fields.length; i++) System.out.println(fields[i]);
		 */

		ShippingOrder order = new ShippingOrder();
		Field cardField = ShippingOrder.class.getDeclaredField("creditCardNumber");

		cardField.setAccessible(true);

		long creditNumber = cardField.getLong(order);

		System.out.println(creditNumber);

	}

}

class ShippingOrder {
	private int customerNumber = 57548;
	private int orderNumber = 211213;
	private long creditCardNumber = 1234567890123456L;
}