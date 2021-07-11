import java.util.Scanner;

public class ShippingCostCalculator{
  public static void main (String[] args){
    Scanner in = new Scanner(System.in);
    int i=1;
    while(i==1){
    System.out.print("Please enter the package type (P for parcel, V for value-declared parcel):");
    String type = in.next();
    
    if(type.equals("P")){
      System.out.print("Please enter the package dimension (cm):");
      int dimension = in.nextInt();
      if(dimension<=60){
        int cost=130;
        System.out.println("Mail Services");
        System.out.println("Parcel,dimension"+" "+dimension+"cm");
        System.out.println("$Retail:$"+cost);
      }
      else if(dimension>=61 && dimension<=90){
        int cost=170;
        System.out.println("Mail Services");
        System.out.println("Parcel,dimension"+" "+dimension+"cm");
        System.out.println("$Retail:$"+cost);
      }
      else if(dimension>=91 && dimension<=120){
        int cost=210;
        System.out.println("Mail Services");
        System.out.println("Parcel,dimension"+" "+dimension+"cm");
        System.out.println("$Retail:$"+cost);
      }
      else if(dimension>=121 && dimension<=150){
        int cost=250;
        System.out.println("Mail Services");
        System.out.println("Parcel,dimension"+" "+dimension+"cm");
        System.out.println("$Retail:$"+cost);
      }
      else if(dimension>150){
        System.out.println("Oversized");
      }
      else{
        System.out.println("not allowed");
      }
      
    }
    else if(type.equals("V")){
      System.out.print("Please enter the package dimension (cm):");
      int dimension=in.nextInt();
      int cost=0;
      int dollars=0;
      int total;
      if(dimension<=60){
        cost=130;
      }
      else if(dimension>=61 && dimension<=90){
        cost=170;
      }
      else if(dimension>=91 && dimension<=120){
        cost=210;
      }
      else if(dimension>=121 && dimension<=150){
        cost=250;
      }

      System.out.print("Please enter the value for value-declared parcel:");
      int value=in.nextInt();

      final double PERCENT=0.05;
      final double PERCENTT=0.1;
      final double PERCENTTT=0.15;
      
      if(value<1000){
        dollars=(int)(value*PERCENT);
      }
      else if(value>=1001 && value<=10000){
        dollars=(int)(value*PERCENTT);
      }
      if(value>=10001 && value<=100000){
        dollars=(int)(value*PERCENTTT);
      }

      total=cost+dollars;
      System.out.println("Mail Services");
      System.out.println("Parcel,dimension"+" "+dimension+"cm,value"+" "+value);
      System.out.println("$Retail:$"+total);
    }
    else{
        System.out.println("Invalid parcel type");
    }
    }
    
  }
}