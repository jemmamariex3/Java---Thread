/*
Jemma Tiongson
Section #16031
App: Driver.java RunnableClassB.java RunnableClassB.java
Purpose: Demonstrate ability to use Runnable and priorities threads.
-------------------------------------------------------------------------

Terminal:
   Compile: javac Driver.java RunnableClassB.java RunnableClassB.java
   Run: java Driver
_________________________________________________________________________
*/
import java.lang.Thread;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class RunnableClassB implements Runnable{
   private String [] words;
   private String fileName;
   private Thread thread;
   
   public RunnableClassB(){
      words = new String [30000];
      for(int i = 0; i < words.length; i++){
         words[i] = " ";
      }
      fileName = "dictionary.txt";
      thread = new Thread(this,"thread2");
   }
   public void read(){
      String fileLine = "";
      
      try {
         // Read file
         FileReader data = new FileReader(fileName);
         // Wrap FileReader with BufferedReader
         BufferedReader br = new BufferedReader(data);
         
         int temp=0;
         while((fileLine = br.readLine()) != null) {
            words[temp++] = fileLine;
            
         }
         // close the file
         br.close();
      }
      catch(FileNotFoundException ex) {
         System.out.println("File not found: " + fileName);
      }
      catch(IOException ex) {
         System.out.println("Error reading file: " + fileName);
      }
      
   }
   public void write(){
      String fileName ="sortedDictionary.txt";
      
      try {
         File file = new File(fileName);
         // creates the file
         file.createNewFile();
         // create FileWriter object
         FileWriter writer = new FileWriter(file);
         // output to file
         for(int i = 0; i < words.length; i++){
            writer.write(words[i] +"\n");
         }
         
         
         writer.flush();
         writer.close();
      }
      catch(IOException ex) {
         System.out.println("Error writing to file: " + fileName);
      }
   }
   public void sort(){
      String tempString;
      for(int i=0; i<words.length; i++)
      {
         for(int j=1; j< words.length; j++)
         {
            if(words[j-1].compareTo(words[j])>0)
            {
               tempString=words[j-1];
               words[j-1]=words[j];
               words[j]=tempString;
            }
         }
      }
   }
   
   public void run(){
      read();
      sort();
      write();
   }
   
   public void start(){
      thread.start();
   }
}