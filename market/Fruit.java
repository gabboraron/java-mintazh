import java.util.*;
import java.io.*;

public class Fruit{
	private String name;
	private int price;
	
	//KONSTRUKTOR
	public Fruit (){
		System.out.println("URES");
	}
	public Fruit (String name, int price){
		this.name = name;
		this.price = price;
		
		//System.out.println("NAME/PRICE: " + this.name + "/" + this.price);
		//System.out.println("NAME/PRICE SET");
		//System.out.println("getCheapestFruit(): " + getCheapestFruit());
		//System.out.println("getCheapestFruit(): " + getCheapestFruit().price);
		//System.out.println("getCheapestFruit(): " + getCheapestFruit().name);
		//System.out.println("getCheapestFruit().show() " + getCheapestFruit().show());
		
		/*if (getCheapestFruit() == null){
			setCheapestFruit(name, price);
			System.out.println("CHEAPEST NAME/PRICE INITIALIZED");
		} else {
			if(getCheapestFruit().price> price){
				setCheapestFruit(name, price);
				System.out.println("CHEAPEST NAME/PRICE SET");
			}			
		}*/
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean cheaperThan(int currentFruitPrice){
		return this.price > currentFruitPrice;
	}
	
	public Fruit make(String name, int price){
		if((name.length() > 1) && (name.matches("[a-zA-Z]+"))){
			System.out.println("NAME OK");
			if((price<5001) && (price>0) && (((price % 10) == 0) || ((price % 10) == 5))){
				System.out.println("FRUIT CREATED");
				setCheapestFruit(name, price);
				return new Fruit(name, price);
			}
			System.out.println("PRICE ERROR");
		}
		System.out.println("NAME ERROR");
		return null;
	}
	
	public String show(){
		String tmpPrice = String.valueOf(this.price);
		/*System.out.println("****");
		System.out.println("name: "+ this.name);
		System.out.println("price: "+ this.price);
		System.out.println("****");*/
		if(name.length()>3){
			tmpPrice = "";
			String tmpChar = "";
			int counter = 0;
			for(int i = String.valueOf(this.price).length()-1; i>-1; --i){
				if(counter == 3 ){
					tmpPrice = " " + tmpPrice;
					counter = 0;
				}
				tmpPrice = String.valueOf(this.price).charAt(i) + tmpPrice;
				++counter;
			}
			return this.name + " (" + tmpPrice + " Ft)";
		}
		return this.name + " (" + this.price + " Ft)";
	} 
	
	public static Fruit cheapestFruit = null;
	public static Fruit getCheapestFruit(){
		/*System.out.println("**LOG**");
		System.out.println("cheapestFruit.name: " + cheapestFruit.name);
		System.out.println("**LOG**");*/
		return cheapestFruit;
	}
	public static void setCheapestFruit(String name, int price){
		if (getCheapestFruit() == null){
			cheapestFruit = new Fruit (name, price);
			//System.out.println("CHEAPEST NAME/PRICE INITIALIZED: "+ cheapestFruit.name + "/" + cheapestFruit.price);
			//System.out.println("CHEAPEST NAME/PRICE INITIALIZED: "+ getCheapestFruit().name + "/" );
		} else {
			if(getCheapestFruit().price> price){
				cheapestFruit = new Fruit (name, price);
				//setCheapestFruit(name, price);
				//System.out.println("CHEAPEST NAME/PRICE SET");
			}			
		}
		
		/*this.cheapestFruit.price = price;
		//this.cheapestFruit = new Fruit(name,price);
		System.out.println("***");
		//this.cheapestFruit.name = name;*/
	}
	
	public static void main(String[] args){
		//Fruit myFruit = new Fruit(args[0],Integer.parseInt(args[1]));
		Fruit myFruit = new Fruit();
		myFruit = myFruit.make(args[0],Integer.parseInt(args[1]));
		//System.out.println("myFruit.name " + myFruit.name);
		System.out.println(myFruit.show());
		//System.out.print("name:" + myFruit.getName() + " ");
		//System.out.println("price:" + myFruit.getPrice());
		Fruit mySndFruit = new Fruit();
		mySndFruit = mySndFruit.make("banan",300);
		//System.out.print("name:" + mySndFruit.getName() + " ");
		//System.out.println("price:" + mySndFruit.getPrice());
		System.out.println(mySndFruit.show());
		System.out.println("CHEAPEST: " + getCheapestFruit().show());
	}
	
}