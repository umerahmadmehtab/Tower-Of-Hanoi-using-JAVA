package tower.of.hanoi;
//Umer Ahmad Mehtab 
//05905
//BESE-4A
 import java.util.*;
 
 public class TowerOfHanoi
 {
     public static int N;
     
     public static Stack<Integer>[] tower = new Stack[4]; 
 
     public static void main(String[] args)
     {
         // Using Stacks for the towers 
         tower[1] = new Stack<Integer>();
         tower[2] = new Stack<Integer>();
         tower[3] = new Stack<Integer>();
         /* Accepting number of disks */         
         System.out.println("The Tower of Hanoi Using 8 disks:");
         int num = 8; 
         N = num;
         elements_put(num);
     }
     /* Function to push disks into stack */
     public static void elements_put(int n)
     {
         for (int d = n; d > 0; d--)
             tower[1].push(d);
         display();
         move(n, 1, 2, 3);         
     }
     /* Recursive Function to move disks */
     public static void move(int n, int a, int b, int c)
     {
         if (n > 0)
         {
             move(n-1, a, c, b);     
             int d = tower[a].pop();                                             
             tower[c].push(d);
             display();                   
             move(n-1, b, a, c);     
         }         
     }
     //This function will display the disks on towers with all the possiblities 
     public static void display()
     {
         System.out.println("  A  ||  B  ||  C");
         System.out.println("**********************");
         for(int i = N - 1; i >= 0; i--)
         {
             String d1 = " ", d2 = " ", d3 = " ";
             try
             {
                 d1 = String.valueOf(tower[1].get(i));
             }
             catch (Exception e){
             }    
             try
             {
                 d2 = String.valueOf(tower[2].get(i));
             }
             catch(Exception e){
             }
             try
             {
                 d3 = String.valueOf(tower[3].get(i));
             }
             catch (Exception e){
             }
             System.out.println("  "+d1+"  ||  "+d2+"  ||  "+d3);
         }
         System.out.println("\n");         
     }
 }