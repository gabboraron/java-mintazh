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
	
	public static void main(String args[]){
		Market myMarket = new Market(args[0]);
		myMarket.printMarket();
	}
}