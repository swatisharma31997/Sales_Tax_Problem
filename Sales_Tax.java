import java.util.Scanner;
import java.io.File;
import java.math.BigDecimal;

public class Sales_Tax{

    public static void main(String[] args) throws Exception{
        String filename = args[0];
        String exemptions = args[1];
		Scanner fileScan = new Scanner(new File(filename));
        Scanner exemptScan = new Scanner(new File(exemptions));

        All_item cart = new All_item();
        Calculate_Tax calculator = new Calculate_Tax();
        Tax basic = new Tax("basic tax", 0.1);
        Tax imported = new Tax("import tax", 0.05);
        calculator.addTax("basic", basic);
        calculator.addTax("imported", imported);

        while(exemptScan.hasNext()){
            String line = exemptScan.nextLine();
            calculator.addExemption(line);
        }

        while(fileScan.hasNext()){
            BigDecimal quantity = new BigDecimal(fileScan.nextInt());
            String line = fileScan.nextLine();
            String[] split = line.split("\\sat\\s");
            Product p = new Product(split[0].substring(1), split[1]);
            cart.add(p, quantity, calculator);
        }

        cart.print();

		fileScan.close();
    }

}