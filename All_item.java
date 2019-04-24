import java.math.BigDecimal;
import java.util.*;

public class All_item{
    private Hashtable<Product, BigDecimal> Item_bought;
    private Hashtable<Product, BigDecimal> tax;
    private BigDecimal Sub_Total;
    private BigDecimal Total_Tax;

    public All_item(){
     Item_bought = new Hashtable();
        tax = new Hashtable();
        Sub_Total = new BigDecimal(0.0);
        Total_Tax = new BigDecimal(0.0);
    }


    public void add(Product p, BigDecimal quantity, Calculate_Tax c){
     Item_bought.put(p, quantity);
        BigDecimal price = p.getPrice();
        BigDecimal t = c.calculateTax(p);

        Sub_Total = Sub_Total.add(price.multiply(quantity));
        tax.put(p, t);
        Total_Tax = Total_Tax.add(t);
    }

    
    private BigDecimal Calculate_Total(){
        return Sub_Total.add(Total_Tax);
    }

    
    public void print(){
        Set<Product> products = Item_bought.keySet();

        for(Product p : products){
            BigDecimal quantity = Item_bought.get(p);
            BigDecimal totalPrice = p.getPrice().add(tax.get(p));
            System.out.println(quantity+" "+p.getName()+" : "+totalPrice);
        }
        
        System.out.println("Sales Taxes : "+Total_Tax);
        System.out.println("Total : "+Calculate_Total());
        
    }

}