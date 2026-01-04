package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sql_dataBase_dataLoader {

	public customer_loginDetails fetchData(String query ) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ninjatutorials_database";
		String user ="root";
		String password = "Pavan@7218";
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				System.out.println("sql output : "+rs.getString("emailID"));
	            
				customer_loginDetails c = new customer_loginDetails();
	            c.setFirstName(rs.getString("firstName"));
	            c.setLastName(rs.getString("lastName"));
	            c.setEmailID(rs.getString("emailID"));
	            c.setContactNo(rs.getString("contactNo"));
	            c.setPassword(rs.getString("password"));
	            c.setValidationStatus(rs.getString("validation_status"));
	            return c;
	        }
	    
	    return null;
		}
	public customer_registrationDetails fetchRegistrationData(String query ) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/ninjatutorials_database";
		String user ="root";
		String password = "Pavan@7218";
		
		Connection con = DriverManager.getConnection(url, user, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
			if (rs.next()) {
				System.out.println("sql output : "+rs.getString("emailID"));
	            
				customer_registrationDetails c = new customer_registrationDetails();
	            c.setFirstName(rs.getString("firstName"));
	            c.setLastName(rs.getString("lastName"));
	            c.setEmailID(rs.getString("emailID"));
	            c.setContactNo(rs.getString("contactNo"));
	            c.setPassword(rs.getString("password"));
	            
	            return c;
	        }
	    
	    return null;
		}
	}
	
	
	
	

