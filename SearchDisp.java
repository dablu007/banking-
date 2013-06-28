

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchDisp extends JFrame 
{
	public SearchDisp(int index)
	{
		super("Search Window");
		String heading[]={"Name","DOB","Gender","Phoneno","Address","emailid","occupation","identityproof","identityproofno","accounttype","depositamount","facilitiesrequired","accountno"};
		String data[][]=new String[20][13];
		ArrayList<Registration> list2;
		try
		{
			FileInputStream fin=new FileInputStream("Banking.dat");
			ObjectInputStream oin=new ObjectInputStream(fin);
			list2=(ArrayList<Registration>)oin.readObject();
			
			Registration re = list2.get(index);
			
			data[0][0]=re.getName();
				data[0][1]=re.getdob();
				data[0][2]=re.getgender();
				data[0][3]=re.getphoneno();
				data[0][4]=re.getaddress();
				data[0][5]=re.getemailid();
				data[0][6]=re.getoccupation();
				data[0][7]=re.getidproof();
				data[0][8]=re.getidentityproofno();
				data[0][9]=re.getaccounttype();
				data[0][10]=re.getdepositamount();
				data[0][11]=re.getfr();
				data[0][12]=re.getaccountno();
				
					
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("Information Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(650, 300);
			
			setLocation(200, 200);
			setVisible(true);
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

