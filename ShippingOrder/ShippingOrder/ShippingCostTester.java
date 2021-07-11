import static java.lang.System.out;

import java.util.Scanner;
import java.util.StringTokenizer;

public class ShippingCostTester {
	final static int RESET_VALUE = 10;
	public static void main (String[] args){
		String shippingType = null, shipperName, shipperAddress, shipperPhone, recipientName, recipientAddress, recipientPhone, dimension;
		ShippingOrder order = null;
		double weight = 0, value = 0, count = 0;
		Scanner in = new Scanner(System.in);

		while(true) {
			out.print("Please enter the package type (L for letter, P for parcel, V for value-declared parcel, and -1 for exit): ");
			shippingType = in.next();
			if(shippingType.equals("-1")) {
				break;
            }
			if(!shippingType.equals("L") && !shippingType.equals("P") && !shippingType.equals("V")) {
				out.println("Invalid parcel type");
				continue;
            }
			count = ShippingOrder.count;
            if(count >= RESET_VALUE) {
                ShippingOrder.resetOrderID();
            }

			out.print("Please enter the shipper's name: ");
			shipperName = in.next();
			out.print("Please enter the shipper's address: ");
            shipperAddress = in.next();
            /* //if you want to get extra 1% point, remove the mark
                while(!ShippingOrder.areaValidate(shipperAddress)) {
                out.print("The address is not in Taiwan, please re-enter a valid address: ");
                shipperAddress = in.next();
            }*/
			out.print("Please enter the shipper's phone number: ");
			shipperPhone = in.next();
			out.print("Please enter the recipient's name: ");
			recipientName = in.next();
			out.print("Please enter the recipient's address: ");
            recipientAddress = in.next();
            /* //if you want to get extra 1% point, remove the mark
             	while(!ShippingOrder.areaValidate(recipientAddress)) {
                out.print("The address is not in Taiwan, please re-enter a valid address: ");
                recipientAddress = in.next();
            }*/
			out.print("Please enter the recipient's phone number: ");
			recipientPhone = in.next();
			
			switch(shippingType) {
				case "L":
                    out.print("Please enter the weight(g) of the letter: ");
					weight = in.nextInt();
                    order = new ShippingOrder("L", shipperName, shipperAddress, shipperPhone, recipientName, recipientAddress, recipientPhone, weight);
                    
                    order.getShippingInfo();
                    out.println("Retail:$" +order.getShippingFee());
                    break;
				case "P":
					do {
			            out.print("Please enter the dimension of the parcel (format: length * width * height): ");
			            dimension = in.next();
			            if(!dimension.matches("[0-9]{1,3}[*][0-9]{1,3}[*][0-9]{1,3}"))
			            {
			            	out.println("format error");
			            }
					}while(!dimension.matches("[0-9]{1,3}[*][0-9]{1,3}[*][0-9]{1,3}"));
                    order = new ShippingOrder("P", shipperName, shipperAddress, shipperPhone, recipientName, recipientAddress, recipientPhone, dimension);
                    order.getShippingInfo();
                    out.println("Retail: " +order.getShippingFee()+"$");
                    break;
				case "V":
					do {
			            out.print("Please enter the dimension of the parcel (format: length * width * height): ");
			            dimension = in.next();
			            if(!dimension.matches("[0-9]{1,3}[*][0-9]{1,3}[*][0-9]{1,3}"))
			            {
			            	out.println("format error");
			            }
					}while(!dimension.matches("[0-9]{1,3}[*][0-9]{1,3}[*][0-9]{1,3}"));
					out.print("Please enter the value of the parcel: ");
					value = in.nextInt();
                    order = new ShippingOrder("V", shipperName, shipperAddress, shipperPhone, recipientName, recipientAddress, recipientPhone, dimension, value);
                    order.getShippingInfo();
                    out.println("Retail: " +order.getShippingFee()+"$");
                    break;
                default:
                    break;
            }
            count++;
        }
		in.close();
	}
}