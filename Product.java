import java.math.BigDecimal;

public class Product{

    private String name;
    private BigDecimal price;
    private boolean imported;

    public Product(String name ,String price){
        this.name = name;
        this.price = new BigDecimal(price);
        this.imported= isImported(name);
    }

    private boolean isImported(String imported){
        return (imported.indexOf("imported")>=0)?true:false;

    }

    public String getName(){
        return this.name;
    }

    public BigDecimal getPrice(){
        return this.price;
    }
    
    public boolean getImport(){
        return this.imported;
    }
    
}