package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.Conexion;
import controlador.Controlador;
import modeloVo.LineaPedido;
import modeloVo.Pedido;

public class LineaPedidoDao {

	public static ArrayList<LineaPedido> getListaLineasPedido( int nPed) {
		String consulta = "SELECT liId, pdNombre, liIdProducto, liCantidad, "
				+ " pdPrecioVenta, pdPrecioVenta*liCantidad as importe "
				+ "from LineasPedido JOIN Productos on pdId=liIdProducto WHERE liNumPedido = ? ORDER BY liId;";
		ArrayList<LineaPedido> listaPedido = new ArrayList<LineaPedido>();
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		PreparedStatement ps;
		LineaPedido ped = null;

		try {
			ps = con.getConnection().prepareStatement( consulta );
			ps.setInt(1,  nPed);
			resultado  = ps.executeQuery(); 
			while( resultado.next()) {
				ped = new LineaPedido(//(liId, numPed, idProd, cantidad, nombreProd, precio, importe)
						resultado.getInt( "liId" ),
						resultado.getInt( "liIdProducto" ),
						resultado.getInt( "liCantidad" ),
						resultado.getString( "pdNombre" ),
						resultado.getDouble( "pdPrecioVenta"),
						resultado.getDouble( "importe"));
						
				listaPedido.add( ped );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			ps.close();
		} catch (Exception e) {}
		
		return listaPedido;
	}

	public static void deleteLineaPedido(int numLinea) throws Exception {
		System.out.println("Eliminar LienaPedido: " + numLinea );
		
		String consultaLineas = "DELETE from LineasPedido WHERE liId = ?;";

		Conexion con = Controlador.getConexion();
		PreparedStatement ps = null;

		try {
			con.getConnection().setAutoCommit(true);		//Start transaction
			ps = con.getConnection().prepareStatement( consultaLineas );
			ps.setInt( 1, numLinea );
			int ret = ps.executeUpdate();
			if(  ret< 1) throw new Exception("No se ha eliminado la linea (ret="+ret+")");
		}
		catch(SQLException ex) {
			System.out.println( "ERROR DE TRANSACCION" );
			try {
				con.getConnection().rollback();
				ps.close();
			}
			catch (Exception e) { e.printStackTrace();}
			throw ex;
		}
		catch( Exception e) {
			e.printStackTrace();
			try {ps.close();} catch (Exception ex) {}
			throw e;
		}

		try { ps.close(); } catch (Exception e) {}
	}
}
