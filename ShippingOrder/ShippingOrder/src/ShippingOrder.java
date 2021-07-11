import java.util.StringTokenizer;

import javax.lang.model.util.ElementScanner6;

public class ShippingOrder{
    private String correstype=null, name=null, addr=null, phone=null;
    private String rename=null, readdr=null, rephone=null;
    private String corresdimension=null;
    private double corresweight=0.0, corresvalue=0.0;
    static int count=0;
    public ShippingOrder(String shippingtype, String shipperName, String shipperAddress, String shipperPhoneNumber,String RecipientName, String recipientAddress, String recipientPhoneNumber)
    {
        this.correstype=shippingtype;
        this.name=shipperName;
        this.addr=shipperAddress;
        this.phone=shipperPhoneNumber;
        this.rename=RecipientName;
        this.readdr=recipientAddress;
        this.rephone=recipientPhoneNumber;
    }
    /**
     * Correspond to letter
     * 
     * @param shippingtype
     * @param shipperName
     * @param shipperAddress
     * @param shipperPhoneNumber
     * @param RecipientName
     * @param recipientAddress
     * @param recipientPhoneNumber
     * @param weight
     */
    public ShippingOrder(String shippingtype, String shipperName, String shipperAddress, String shipperPhoneNumber,String RecipientName, String recipientAddress, String recipientPhoneNumber,double weight)
    {
        setShippingType(shippingtype);
        setShipperName(shipperName);
        setShipperAddr(shipperAddress);
        setShipperPhone(shipperPhoneNumber);
        setRecipientName(RecipientName);
        setRecipientAddr(recipientAddress);
        setRecipientPhone(recipientPhoneNumber);
        setWeight(weight);
    }
    /**
     * Correspond to Parcel
     * 
     * @param shippingtype
     * @param shipperName
     * @param shipperAddress
     * @param shipperPhoneNumber
     * @param RecipientName
     * @param recipientAddress
     * @param recipientPhoneNumber
     * @param dimension
     */
    public ShippingOrder(String shippingtype, String shipperName, String shipperAddress, String shipperPhoneNumber,String RecipientName, String recipientAddress, String recipientPhoneNumber,String dimension)
    {
        setShippingType(shippingtype);
        setShipperName(shipperName);
        setShipperAddr(shipperAddress);
        setShipperPhone(shipperPhoneNumber);
        setRecipientName(RecipientName);
        setRecipientAddr(recipientAddress);
        setRecipientPhone(recipientPhoneNumber);
        setDimension(dimension);
    }
    /**
     * Correspond to Value-declared Parcel
     * 
     * @param shippingtype
     * @param shipperName
     * @param shipperAddress
     * @param shipperPhoneNumber
     * @param RecipientName
     * @param recipientAddress
     * @param recipientPhoneNumber
     * @param value
     */
    public ShippingOrder(String shippingtype, String shipperName, String shipperAddress, String shipperPhoneNumber,String RecipientName, String recipientAddress, String recipientPhoneNumber, String dimension, double value)
    {
        setShippingType(shippingtype);
        setShipperName(shipperName);
        setShipperAddr(shipperAddress);
        setShipperPhone(shipperPhoneNumber);
        setRecipientName(RecipientName);
        setRecipientAddr(recipientAddress);
        setRecipientPhone(recipientPhoneNumber);
        setDimension(dimension);
        setValue(value);
    }
    
    public ShippingOrder(double weight, String dimension,double value){
        this.corresdimension=dimension;
        this.corresweight=weight;
        this.corresvalue=value;
    }
    public static int resetOrderID(){
        count=0;
        return count;
    }
    public void setShippingType(String shippingtype){
        correstype=shippingtype;
    }

    public void setShipperName(String shipperName){
        name=shipperName;
    }
    public void setShipperAddr(String shipperAddress){
        addr=shipperAddress;
    }

    public void setShipperPhone(String shipperPhoneNumber){
        phone=shipperPhoneNumber;
    }

    public void setRecipientName(String RecipientName){
        rename=RecipientName;
    }

    public void setRecipientAddr(String recipientAddress){
        readdr=recipientAddress;
    }

    public void setRecipientPhone(String recipientPhoneNumber){
        rephone=recipientPhoneNumber;
    }
    /**
     * Different dimension corresponds to different shipping cost
     * @param dimension the total of length, height, and width of the parcel
     */
    public void setDimension(String dimension){
        int token=0;
        double length=0.0, width=0.0, height=0.0;
        StringTokenizer str = new StringTokenizer(dimension, "*");
        while(str.hasMoreTokens()){
            switch(token)
            {
                case 0:
                length=(Double.parseDouble(str.nextToken()));
                token++;
                break;
                case 1:
                width=(Double.parseDouble(str.nextToken()));
                token++;
                break;
                case 2:
                height=(Double.parseDouble(str.nextToken()));
                token++;
                break;
                default:
                break;
            }
        }
        double sum = length + width + height;
        this.corresdimension=String.valueOf(sum);
    }
    public void setWeight(double weight){
        corresweight=weight;
    }
    public void setValue(double value){
        corresvalue=value;
    }

    public void getShippingInfo(){
        count++;
        System.out.println("Mail Services");
        if(correstype.equals("L")){
            System.out.println("Shipping ID: L000"+count);
            System.out.println("Shipping Type: Letter");
        }
        if(correstype.equals("P")){
            System.out.println("Shipping ID: P000"+count);
            System.out.println("Shipping Type: Parcel");
        }
        if(correstype.equals("V")){
            System.out.println("Shipping ID: V000"+count);
            System.out.println("Shipping Type: Value-declared Parcel");
        }
        System.out.println("Shipping Type: "+correstype);
        System.out.println("Shipper: "+name);
        System.out.println("Shipper Address: "+addr);
        System.out.println("Shipper Phone Number: "+phone);
        System.out.println("Recipient: "+rename);
        System.out.println("Recipient Address: "+readdr);
        System.out.println("Recipient Phone Number: "+rephone);
        if(correstype.equals("L")){
            System.out.println("Weight: "+corresweight+ "g");
        }
        if(correstype.equals("P")){
            System.out.println("Dimension: "+corresdimension+ "g");
        }
        if(correstype.equals("V")){
            System.out.println("Dimension: "+corresdimension+ "g");
            System.out.println("Value: "+corresvalue);
        }
    }
    /**
     * Gets the corresponding shipping cost of the specific weight(type L)
     * Gets the corresponding shipping cost of the specific dimension(type P)
     * Gets the corresponding shipping cost of the value-declared parcel(type V)
     * @param shippingtype the letter corresponds to the shipping type
     * @return the shipping information for the order
     */
    public double getShippingFee(){
        double cost =0.0;
        if(correstype.equals("L")){
            if(corresweight<=20)
            cost=8;
            else if(corresweight>=20 && corresweight<=50)
            cost=16;
            else if(corresweight>=51 && corresweight<=100)
            cost=24;
            else if(corresweight>=101 && corresweight<=250)
            cost=40;
        }
        if(correstype.equals("P")){
            if(Double.parseDouble(corresdimension)<=60)
            cost=130;
            else if(Double.parseDouble(corresdimension)>=61 && Double.parseDouble(corresdimension)<=90)
            cost=170;
            else if(Double.parseDouble(corresdimension)>=91 && Double.parseDouble(corresdimension)<=120)
            cost=210;
            else if(Double.parseDouble(corresdimension)>=121 && Double.parseDouble(corresdimension)<=150)
            cost=250;
            else{
                System.out.println("Oversized");
            }
        }
        if(correstype.equals("V")){
            if(Double.parseDouble(corresdimension)<=60)
            cost=130;
            else if(Double.parseDouble(corresdimension)>=61 && Double.parseDouble(corresdimension)<=90)
            cost=170;
            else if(Double.parseDouble(corresdimension)>=91 && Double.parseDouble(corresdimension)<=120)
            cost=210;
            else if(Double.parseDouble(corresdimension)>=121 && Double.parseDouble(corresdimension)<=150)
            cost=250;
            else{
                System.out.println("Oversized");
            }
            double ratio = 0.0;
            if(corresvalue<1000)
            ratio=0.05;
            else if(corresvalue>=1001 && corresvalue<=10000)
            ratio=0.1;
            else if(corresvalue>=10001 && corresvalue<=100000)
            ratio=0.15;
            cost = cost + corresvalue*ratio;
        }
        return cost;
    }
    public static boolean areaverified(String area){
        StringTokenizer str = new StringTokenizer(area, ",");
        while(str.hasMoreTokens()){
            if(str.nextToken().equals("Taiwan")){
                return true;
            }
        }
        return false;
    }
}