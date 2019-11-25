package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	//static String bd = "ud02bd01empleados";
	//static String login = "root";
	//static String password = "123456";
	//static String url = "jdbc:mysql://localhost/"+bd+"?noAccessToProcedureBodies=true&?useServerPrepStmts=true";
	static String bd = "ud02BdFacturacion";
	static String login = "zalo";
	static String password = "zz123456";
	static String host = "gac.duckdns.org";
	//static String host = "192.168.1.7";
	static String url = "jdbc:mysql://"+host+"/"+bd+
			"?serverTimezone=Europe/Madrid&useSSL=false&allowPublicKeyRetrieval=true";
	
	//String url = "jdbc:mysql://localhost:3306/UD02BD01Empleados?serverTimezone=Europe/Madrid";
	
	private Connection conn = null;

	/** Constructor de DbConnection */
	public Conexion() {
		try{
			//obtenemos el driver de para mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//obtenemos la conexión
			conn = DriverManager.getConnection(url,login,password);
			//System.out.println(url);
			if (conn!=null){
				//System.out.println("Conexión a base de datos "+bd+" OK");
			}
		}
		/*catch(SQLException e){
			System.out.println(e);
		}*/catch(ClassNotFoundException e){
			System.out.println(e);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**Permite retornar la conexi�n*/
	public Connection getConnection(){
		return conn;
	}

	public void desconectar(){
		conn = null;
	}
}
