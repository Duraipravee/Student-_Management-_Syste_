import java.sql.*;
import java.util.Scanner;




public class Student_Management  {


		
		public static void main(String[] args)throws Exception {
			
		CRUD dp = new CRUD();
		int User = 0;
		
		while(User <5) {
			Scanner scan = new Scanner(System.in);
			System.out.println("press 1  add the data");
			
			System.out.println("press 2 update the data");
			
			System.out.println("press 3 delete the data");
			
			System.out.println("press 4 display the data");
			
			
			System.out.println("exit  press 5");
			User = scan.nextInt();
			if(User == 1) {
				dp.Insert();
			}
			else if(User == 2) {
				
				dp.Update();
			}
			else if(User == 3) {
				dp.delete();
			}
			else if(User == 4) {
				dp.display();
			}
			
		}
			
	}

}
