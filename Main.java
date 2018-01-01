import market.*;

public class Main{
	public static void main(String args[]){
		Market myMarket = new Market(args[0]);
		System.out.println("------------------------------------------");
		System.out.println("--- SALE  SALE  SALE  SALE  SALE  SALE ---");
		System.out.println("------------------------------------------");
		myMarket.showFruitList(myMarket.sale());
	}
}