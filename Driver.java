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

class Driver{
   public static void main (String [] args){
      RunnableClassA runClassA = new RunnableClassA();
      runClassA.start();
      RunnableClassB runClassB = new RunnableClassB();
      runClassB.start();
   }
}