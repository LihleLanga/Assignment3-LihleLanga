/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ac.za.cput.assignment;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Collections;

/**
 *
 * @author Lihle Langa
 */
public class Reader {
ObjectInputStream input;
ArrayList<Customer> Cust = new ArrayList<Customer>();
ArrayList<Supplier> Supp = new ArrayList<Supplier>();



public void openFile(){
try{ 
input = new ObjectInputStream( new FileInputStream ("customerOutFile.txt"));
System.out.println("===========CUSTOMER=============");
}
catch (IOException ioe){
System.out.println("file could not load" + ioe.getMessage());
}
}
public void readFile(){
try{
//Collections.sort(Cust(super()));
String filename = "stakeholder.ser";
ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename));
Customer cust1 = (Customer)input.readObject();
Supplier supp1 = (Supplier)input.readObject();
Customer cust2 = (Customer)input.readObject();
Supplier supp2 = (Supplier)input.readObject();
Supplier supp3 = (Supplier)input.readObject();
Customer cust3 = (Customer)input.readObject();
Customer cust4 = (Customer)input.readObject();
Supplier supp4 = (Supplier)input.readObject();
Supplier supp5 = (Supplier)input.readObject();
Customer cust5 = (Customer)input.readObject();
Customer cust6 = (Customer)input.readObject();

Cust.add(cust1);
Cust.add(cust2);
Cust.add(cust3);
Cust.add(cust4);
Cust.add(cust5);
Cust.add(cust6);

Supp.add(supp1);
Supp.add(supp2);
Supp.add(supp3);
Supp.add(supp4);
Supp.add(supp5);

}catch (EOFException eofe){
System.out.println("eofe reached");
}
catch (ClassNotFoundException ioe){
System.out.println("error reading class" + ioe);
}
catch(IOException ioe){
System.out.println("file could not load" + ioe.getMessage());
}
finally{
closeFile();
System.out.println("file closed");
}

}
public void closeFile(){
try{
input.close();
}
catch(IOException ioe){
System.out.println("file closed" + ioe.getMessage());
}
}
public void writeToFile(){
try{
FileOutputStream out = new FileOutputStream("customerOutFile.txt");
ObjectOutputStream oout = new ObjectOutputStream(out);
oout.writeObject(Cust);
//Arrays.sort(Cust);
oout.close();
}
catch (Exception ex) {
         ex.printStackTrace();
      }
}

public void writeToSupplier(){
try{
FileOutputStream out = new FileOutputStream("supplierOutFile.txt");
ObjectOutputStream supOut = new ObjectOutputStream(out);
supOut.writeObject(Supp);
Collections.sort(Supp);
supOut.close();
}
catch (Exception ex) {
         ex.printStackTrace();
      }
}
public static void main (String[] args){
Reader reader = new Reader();
reader.openFile();
reader.readFile();
Customer.getDateOfBirth();
reader.writeToFile();

}
}
