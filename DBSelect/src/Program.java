import java.sql.*;
import java.util.Scanner;

public class Program {
	
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String CONNECTION_STRING = 
			"jdbc:mysql://localhost:3306/web?user=root&password=demo";

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName(DRIVER_NAME);
		
		
		
		try(Connection conn  = DriverManager.getConnection(CONNECTION_STRING))
		{
			
			CallableStatement sp = 	conn.prepareCall("call countCourses(?)");
			// sp.set..
			sp.execute();
			int count = sp.getInt(1);
			
			System.out.printf("Всего курсов: %d\n", count);
			
			
			System.out.print("Поиск: ");
			Scanner sc = new Scanner(System.in);
			String search = sc.nextLine();
			sc.close();
			
			
			/*// bad. sql injection
			Statement cmd = conn.createStatement();
			String sql = "SELECT title, length FROM courses "
					+ "WHERE title LIKE '%"+search+"%' "
					+ "ORDER BY title";
			ResultSet result = cmd.executeQuery(sql);
			*/
			String sql = "SELECT title, length FROM courses "
					+ "WHERE title LIKE ? "
					+ "ORDER BY title";
			
			PreparedStatement cmd = conn.prepareStatement(sql);
			cmd.setString(1, "%"+search+"%");
			
			ResultSet result = cmd.executeQuery();
			
			while( result.next() ) {
				String title = result.getString("title");
				int length   = result.getInt("length");
				if (result.wasNull())
					System.out.printf("%-40s\n", title);
				else				
					System.out.printf("%-40s : %d\n", title, length);
				
			}
			
		} // conn.close();
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
			
		}

	}

}
