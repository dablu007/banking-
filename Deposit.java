

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Deposit 
{
    ArrayList<Transaction> lst;
    
    private int crdt;
    
	
	public Deposit(Transaction cr,int index)
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Banking2.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   lst=(ArrayList<Transaction>)oin.readObject();
		   
		   int fix1=convert1(index);
		  int calc=fix1+(Integer.parseInt(cr.getdepositamount()));
		   String fix2= lst.get(index).getaccountno();
		   //private String next(){
		   	String s= String.valueOf(calc);
		   lst.get(index).setdepositamount(s);
		   
		}catch(Exception e)
		 {
			 lst=new ArrayList<Transaction>();
		 }
		//Transaction crt;
		// lst.set(index, crt);
		
		 try	
		 {
		       FileOutputStream fout=new FileOutputStream("Banking2.dat");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(lst);
		}catch(Exception e){}
	
	}
	public int convert1(int index)
	{
		int conv=Integer.parseInt(lst.get(index).getdepositamount());
		return(conv);
		
	}
	
}
