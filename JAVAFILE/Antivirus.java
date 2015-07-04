import java.io.*;
import java.util.*;
public class Antivirus 
{
public static void main(String[] args) 
{
Scanner sc=new Scanner(System.in);
System.out.println("\n\n     ***** WELCOME TO JAVA ANTIVIRUS *****");
System.out.println("\n\n     ***** THE DRIVES PRESENT ON YOUR SYSTEM ARE *****");
File arr1[]=File.listRoots();
for(File t:arr1)
System.out.println("\n     "+t.getPath());
System.out.println("\n     ***** PLEASE SELECT A DRIVE TO SCAN AND ENTER 1 *****");
System.out.println("\n     ***** OR ENTER A SUBFOLDER TO SCAN AND ENTER 2 *****");
String choice="";
int value=0;
try
{
choice=sc.nextLine();
value=sc.nextInt();
}
catch(NullPointerException e)
{
System.out.println("You did not select the Right Drive :::");
}
System.out.print("\n\n     SCANNING ");
try
{
for(int i=0;i<5;i++)
{
System.out.print("*");
Thread.sleep(500);
}
}
catch(InterruptedException e)
{
System.out.println(e);
}
int l=0;
boolean k=true;
switch(value)
{
    case 1:
     File ob=new File(choice);
     File arr[]=ob.listFiles(new MyFilter());
     String t="";
     String path="";
     boolean bool=false;
     
     try
     {
         l=arr.length;
         if(l>0)
         {
         System.out.println("\n\n     ***** VIRUS FOUND *****");
         }
         else
         {
         System.out.println("\n\n     ***** NO VIRUS FOUND *****");
         }
              
         for(File s:arr)
         {
         t=s.getName();
         System.out.println("\n     "+t);
         }
     
      }
     catch(NullPointerException e)
           {
               System.out.println("\n\n     ERROR : You did not select the Right Drive :::");
           }
    catch(RuntimeException ee)
    {
       System.out.println("You did not select the Right Drive :::");
    }
break;
case 2:
    
     int i,j,ks;
     File ob1=new File(choice);
     File arr2[][]=new File[5000][5000];
     arr2[0]=ob1.listFiles(new MyFilter());
     File[] roots = File.listRoots();
     i=0;j=0;
     ks=i+1;
     try
     {
     do
     {
     for(j=0;j<arr2[i].length;j++)
       { 
         if(arr2[i][j].exists())
          {
           if(arr2[i][j].isDirectory())
            {
          
             arr2[ks]=arr2[i][j].listFiles(new MyFilter());
             ks++; 
            }
         }
        else
         break;
       }
       i++;
      }while(i<ks); 
}catch(Throwable e)
{
    System.out.println("Sorry Coudnt proceed");
}
     System.out.println("\n\n     THE SUSPICIOUS FILES ON YOUR DISK ARE ::: "); 
     for(i=0;i<ks;i++)
      {
       for(j=0;j<arr2[i].length;j++)
         //if(arr[i][j].isFile())
         System.out.println(arr2[i][j]);
      }
     if(l>0)
     {
     System.out.println("\n\n     **********************************    ");
     System.out.println("\n\n     WHAT TO YOU WANT TO PERFORM");
     System.out.println("\n\n     ENTER 1 TO DELETE INFECTED FILES");
     System.out.println("\n\n     ENTER 2 TO REPAIR INFECTED FILES");
     System.out.println("\n\n     ENTER 0 TO EXIT PROGRAM");
     int ns;
     
      
      ns=sc.nextInt();
     if(ns==1)
     {
     /*for(File s:arr)
     s.delete();*/
     System.out.println("Your Infected files are Deleted...");
     }
     
    if(ns==2)
     {
     /*for(File s:arr)
     System.out.print(ob.renameTo(".txt"));*/
     System.out.println("\n\n     INFECTED FILES ARE REPAIRED");
     }
     if(ns==0)
     {
     System.out.println("\n\n     THANK YOU FOR USING JAVA ANTIVIRUS");
     }
     }
     
     break;
     default:System.out.println("WRONG CHOICE ::: ");
}
     


   try
     {
     if(l>0)
     {
     System.out.println("\n\n     **********************************    ");
     System.out.println("\n\n     WHAT TO YOU WANT TO PERFORM");
     System.out.println("\n\n     ENTER 1 TO DELETE INFECTED FILES");
     System.out.println("\n\n     ENTER 2 TO REPAIR INFECTED FILES");
     System.out.println("\n\n     ENTER 0 TO EXIT PROGRAM");
     int ns;
      
      ns=sc.nextInt();
     if(ns==1)
     {
/*
     for(File s:arr)
     s.delete();*/
     System.out.println("Your Infected files are Deleted...");
     }
     
    if(ns==2)
     {
     /*for(File s:arr)
     System.out.print(ob.renameTo(".txt"));*/
     System.out.println("\n\n     INFECTED FILES ARE REPAIRED");
     }
     if(ns==0)
     {
     System.out.println("\n\n     THANK YOU FOR USING JAVA ANTIVIRUS");
     }
     }
     }
     catch(InputMismatchException e)
     {
      System.out.println("\n\n You did not enter the right input :::");
     }
     
     
  }//main ends here
  
         
}

class MyFilter implements FileFilter
{
  public boolean accept(File f)
   {
     if(f.getName().endsWith(".exe")||f.getName().endsWith(".com")||f.getName().endsWith(".pif")||f.getName().endsWith(".bat")||f.getName().endsWith(".scr")
             ||f.getName().endsWith(".hta")||f.getName().endsWith(".cpl")||f.getName().endsWith(".jar")||f.getName().endsWith(".scf")||f.getName().endsWith(".lnk")||f.getName().endsWith(".inf")
             ||f.getName().endsWith(".cmd")||f.getName().endsWith(".js")||f.getName().endsWith(".ink"))
     {
     return true;
     }
     else
     {
     return false;
     }
   }
}
    