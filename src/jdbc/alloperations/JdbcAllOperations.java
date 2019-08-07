package jdbc.alloperations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcAllOperations {

	public static void insert()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student?user=root&password=root");
			
			System.out.println("Enter supplyno,sname,status,city-");
			String suppno=sc.nextLine();
			String sname=sc.nextLine();
			String status=sc.nextLine();
			String city=sc.nextLine();

			PreparedStatement ps=con.prepareStatement("insert into supplier(suppno,sname,status,city) values (  ? , ? , ? ,  ?  )");
			ps.setString(1, suppno);
			ps.setString(2, sname);
			ps.setInt(3, Integer.parseInt(status));
			ps.setString(4, city);
			
			int rs = ps.executeUpdate();
			System.out.println("Row number inserted -" +rs);
			
			
		}
		
catch(Exception e)
		{
	e.printStackTrace();
		}
	}
	
	public static void delete()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
		System.out.println("Enter the supply number to delete recored-");
		String suppno=sc.nextLine();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student?user=root&password=root");
		PreparedStatement ps=con.prepareStatement("delete from supplier where suppno=?");
		ps.setString(1, suppno);
		
		int rs=ps.executeUpdate();
		System.out.println("No. of record deleted-"+rs);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void update()
	{
		Scanner sc=new Scanner(System.in);
		try
		{
			System.out.println("Enter the supply number to update-");
			String suppno=sc.nextLine();
			System.out.println("Enter new city--");
			String city=sc.nextLine();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/student?user=root&password=root");
			PreparedStatement ps=con.prepareStatement("update supplier set city= ? where suppno = ?");
			ps.setString(1, city);
			ps.setString(2,suppno);
			
			int rs=ps.executeUpdate();
			System.out.println("No.of row updated--" + rs);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	public static void display()
	{
		try{  
			   Class.forName("com.mysql.jdbc.Driver");  
			   Connection con =DriverManager.getConnection("jdbc:mysql://localhost/student?user=root&password=root");  
			   Statement st= con.createStatement();  
			   ResultSet rs=st.executeQuery("select * from supplier");  
			   System.out.println("Print All Content:");
			   while(rs.next()){  
			    System.out.println(
			    		rs.getString("suppno") + ", "
			    		+ rs.getString(2) + ", "
			    		+ rs.getString(3) + ", "
			    		+ rs.getString(4));  
			   }  
			  
			}catch(Exception ee){System.out.println(ee);}  
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	    while(true)
	    {
	    	System.out.println("Enter 1 to insert \nEnter 2 to delete\nEnter 3 to Update\nEnter 4 to Display all records\n");
	    	int choice=sc.nextInt();
	    	switch(choice)
	    	{
	    	case 1:
	    		insert();break;
	    	case 2:
	    		delete();break;
	    	case 3:
	    		update();break;
	    	case 4:
	    		display();break;
	    	}
	    }
		
	}

}
