package market;
import java.util.*;
import java.io.*;


public class Market{
	private LinkedList<Fruit> fruitsOnMarket = new LinkedList<>();
	
	//KONSTRUKTOR
	public Market(String inFileName){
		File inFile = new File(inFileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line;
			for(line = br.readLine(); line!=null; line=br.readLine()){
				String[] thisLine = line.split(",");
				Fruit tmpFruit = new Fruit();
				tmpFruit = tmpFruit.make(thisLine[0], Integer.parseInt(thisLine[1]));
				if(tmpFruit != null){
					fruitsOnMarket.add(tmpFruit);
				} 
			}
		} catch (IOException e) {
			System.out.println("ERROR");
		}
	}

	public void printMarket(){
		for(Fruit fruit : fruitsOnMarket){
			System.out.println(fruit.show());
		}		
	}
	
	public int numberOfFruits(){
		return fruitsOnMarket.size();
	}
	
	public String show(){
		String tmp = "";
		int length = numberOfFruits();
		int i = 1;
		for(Fruit fruit : fruitsOnMarket){
			tmp += fruit.show();
			if(i<length){
				tmp += "\n";
			}
			++i;
		}
		return tmp;
	}
	
	public LinkedList<Fruit> cheaperThan(Fruit thisFruit){
		LinkedList<Fruit> resultList = new LinkedList<>();
		for(Fruit fruit : fruitsOnMarket){
			//System.out.println("fruit.getPrice()|thisFruit.getPrice()" + fruit.getPrice() + "|" + thisFruit.getPrice());
			if(fruit.getPrice()<thisFruit.getPrice()){
				resultList.add(fruit);
			}
		}
		return resultList;
	}
	
	public double average(){
		if(numberOfFruits() == 0){
			return -1;
		}
		int tmp = 0;
		for(Fruit fruit : fruitsOnMarket){
			tmp = tmp + fruit.getPrice();
		}
		return tmp/numberOfFruits();
	}
	
	public Fruit buyCheapestFruit(){
		if(numberOfFruits() == 0){
			return null;
		}
		Fruit fstFruitOnMarket = fruitsOnMarket.get(0); 
		if(cheaperThan(fstFruitOnMarket).size() > 0){
			fstFruitOnMarket = cheaperThan(fstFruitOnMarket).get(0);
			fruitsOnMarket.remove(fstFruitOnMarket);
			return fstFruitOnMarket;
		}
		fruitsOnMarket.remove(fstFruitOnMarket);
		return fstFruitOnMarket;
	}
	
	public LinkedList<Fruit> sale(){
		LinkedList<Fruit> tmp = new LinkedList<>();
		while(numberOfFruits() != 0){
			tmp.add(buyCheapestFruit());
		}
		return tmp;
	}
	
	public void showFruitList(LinkedList<Fruit> tmp){
		for(Fruit fruit : tmp){
			System.out.println(fruit.show());
		}
	}
	/*
	public static void main(String args[]){
		Market myMarket = new Market(args[0]);
		myMarket.printMarket();
		System.out.println("nr of available fruits: " + myMarket.numberOfFruits());
		System.out.print(myMarket.show());
		System.out.println("///");
		Fruit myTmpFruit = new Fruit();
		myTmpFruit = myTmpFruit.make("ize", 85);
		System.out.println("cheaperThanTEST: " + myMarket.cheaperThan(myTmpFruit).get(0).show());
		System.out.println("average price: " + myMarket.average());
		System.out.println("------------------------------------------");
		System.out.println("--- SALE  SALE  SALE  SALE  SALE  SALE ---");
		System.out.println("------------------------------------------");
		myMarket.showFruitList(myMarket.sale());
	}*/
}