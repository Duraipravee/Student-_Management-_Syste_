import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/* the CURD class have the 4 methods

Insert() executeUpdate()
Update() executeUpdate()
display() executeQuery
delete() executeUpdate()

*/
public class CRUD {
	
	public  void  Insert() {
		String url ="jdbc:mysql://127.0.0.1:3306/student "; // mysql data base URL link
		String Username ="root" ; // 
		String password = "DP2615";
		
		//User Input for Insert To the Student Informatiom
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter student id : ");
		int id = scan.nextInt();//
		System.out.println("Enter student name : "); 
		String name = scan.next();
		System.out.println("Enter student contact no : ");
		String mobile = scan.next();
		System.out.println("Enter student department : ");
		String department = scan.next();

		/*the sql query for Insert 
		database name : student 
		table name is StudentImformation
		exsample insert Query is**** Insert into StudentInformation values(6,'karthick','8838782277','commerce' );*** */
		
		String Qurey = "insert into StudentInformation values( " + id + ",'" + name + "','" + mobile + "','" + department +"')" ;
		
		
		try {
			// connect the database to JDBC
		   Connection con = DriverManager.getConnection(url,Username,password); 
		   Statement st = con.createStatement();
		   int rows = st.executeUpdate(Qurey);
		   
		   System.out.println("rows affected : " + rows);
		   
		}catch(Exception e) {
			System.out.println("throw errors : " + e);
		}
		}
	
	
	 void Update() {
		 String url = "jdbc:mysql://127.0.0.1:3306/student";
		 String Username = "root";
		 String password = "DP2615";
		 
		 
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter the colum of table: ");
		 String colum = scan.next();
		 System.out.println("Enter the values of colum: ");
		 String values = scan.next();
		 System.out.println("Enter the update id: ");
		 int id = scan.nextInt();
		 /*exsample update query ***update StudentInformation set  name = 'ram' where id = 1;
		 name is the colum of the table and id is the primary colum of the table */
		 
		 try {
		  String Query = "update StudentInformation set "+colum +" = '" + values +"' where id = " + id ; 
		  Connection con = DriverManager.getConnection(url,Username,password); 
		  Statement st = con.createStatement();
		  int row = st.executeUpdate(Query);
		  
		  
		 
		  
		  System.out.println("rows affected : " + row);
		  
		 }
		 catch(Exception e) {
			 System.out.println("throw error : "+ e);
		 }
	 }
	 
	 
	 
	 
	 
	 public void delete() {
		 String url = "jdbc:mysql://127.0.0.1:3306/student";
		 String Username = "root";
		 String password = "DP2615";
		 
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Enter the id : ");
		 int id = scan.nextInt();
		 
		/* 
		 exsample Query delete from StudentInformation where id = 1" 
		 */
		 
		 try {
		  String Query = "delete from StudentInformation where id = " + id ;
		  Connection con = DriverManager.getConnection(url,Username,password);
		  Statement st = con.createStatement();
		   int row =st.executeUpdate(Query);
		  
		  System.out.println("rows affected : " + row);
		  
		 }
		 catch(Exception e) {
			 System.out.println("throws error: " + e);
		 }
	 }
	 
	 
	 void display() {
			String url = "jdbc:mysql://127.0.0.1:3306/student";
			String Username = "root";
			String password = "DP2615";
			
			/* 
			  sql query select * from StudentInformation
			 */
		try {
			String Query =  "select * from StudentInformation";
			Connection con = DriverManager.getConnection(url,Username,password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(Query);
			
			while(rs.next()) {
				System.out.println("Student id is : " + rs.getInt(1));//
				System.out.println("name : " + rs.getString(2));
				System.out.println("mobile no : " + rs.getString(3));
				System.out.println("Department is : " + rs.getString(4));
			}
			con.close();}catch(Exception e) {
				System.out.println("throws error: "+e);
			}
	 }
	 
	 

}
