import java.sql.*;

public class ConexaoDBDepois {
	private static Configure configure = null;
	private static Connection con = null;
	public ConexaoDBBefore(Configure configure) {
		if (this.configure == null) {
            this.configure = configure;
      }
  }
	public Connection getConection() {
       if (con == null) {
          try {
              Class.forName("org.postgresql.Driver");
              	try {
              		con = (Connection)DriverManager.getConnection("jdbc:postgresql://" + configure.getlocal() +":5432/" + configure.getbanco(),configure.getlogin(), configure.getsenha());
              } catch(SQLException e) {
            	  throw new AbstractMethodError(e.getMessage());
              }
          } catch(ClassNotFoundException e) {
        	  System.out.println(e.getMessage());
          }
       }
       return con;
  }
}