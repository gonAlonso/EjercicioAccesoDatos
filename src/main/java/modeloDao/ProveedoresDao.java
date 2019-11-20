package modeloDao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import controlador.Controlador;
import modeloVo.Producto;
import modeloVo.ProductosBajoMinimo;
import modeloVo.Proveedor;

public class ProveedoresDao {
	

	public static ArrayList<Proveedor> getListaProveedores() {
		String consulta = "SELECT * FROM Proveedores;";
		ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
		
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		Proveedor pro = null;

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta ); 
			while( resultado.next()) {
				pro = new Proveedor(
						resultado.getString( "prNif" ),
						resultado.getString( "prNombre" ),
						resultado.getString( "prCalle" ),
						resultado.getInt( "prCodPostal" ),
						resultado.getString( "prCiudad" ),
						resultado.getInt( "prTelefono" ),
						resultado.getString( "prWeb" ));
				listaProveedores.add( pro );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return listaProveedores;
	}
}
