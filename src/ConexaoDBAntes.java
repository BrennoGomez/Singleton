import java.sql.*;

public class ConexaoDBAntes {
	private Configure configure;
	private Connection con;
	public ConexaoDBAfter(Configure configure) {
		this.configure = configure;
  }
	public Connection getConection() {
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
       return con;
  }
}