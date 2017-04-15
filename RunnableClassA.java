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
import java.lang.Runnable;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class RunnableClassA implements Runnable{
   private int [] numArray;
   private Thread thread;
   
   public RunnableClassA(){
      numArray = new int [100000];
      thread = new Thread(this,"thread1");
   }
   public void generate(){
      for(int i = 0; i < numArray.length; i++){
         numArray[i] = (int)(Math.random()*100+1);
      }
   }
   public void sort(){
      for (int i =0; i <numArray.length;i++){
         for(int j = i+1; j <numArray.length; j++){
            if(numArray[i] < numArray[j]){
               int temp = numArray[i];
               numArray[i] = numArray[j];
               numArray[j] = temp;
            }
         }
      }
      
   }
   public void write(){
      String fileName ="SortedNumbers.txt";
   
      try {
         File file = new File(fileName);
         // creates the file
         file.createNewFile();
         // create FileWriter object
         FileWriter writer = new FileWriter(file);
         // output to file
         for(int i = 0; i < numArray.length; i++){
            writer.write(numArray[i] +"\n");
         }
      
      
         writer.flush();
         writer.close();
      }
      catch(IOException ex) {
         System.out.println("Error writing to file: " + fileName);
      }
   }
   
   public void run(){
      generate();
      sort();
      write();
   }
   
   public void start(){
         thread.start();
   }
}