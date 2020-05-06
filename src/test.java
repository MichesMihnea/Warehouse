import java.sql.*;  
class test{  
public static void main(String args[]){  
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false","root","root");  	
		MainView mv = new MainView(con);
		Controller ctrl = new Controller(mv);
		}catch(SQLException e){ System.out.println(e);} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	
	}  
}  