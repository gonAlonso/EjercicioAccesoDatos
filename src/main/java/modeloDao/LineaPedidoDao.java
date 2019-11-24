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

	public static void addLineaPedido(int numPedido, LineaPedido lin) throws Exception {
		System.out.println("AñadirLineaAPedido");

		String consultaNumLinea = "SELECT max(liId)+1 FROM LineasPedido;";
		String consultaLinea = "INSERT INTO LineasPedido (liId, liNumPedido, liIdProducto,liCantidad) VALUES (?,?,?,?);";
	
		Conexion con = Controlador.getConexion();
		int resultado = 0;
		int numLinea;
		PreparedStatement ps = null;

		try {
			System.out.println("ANTES");
			con.getConnection().setAutoCommit(false);		//Start transaction
			ps = con.getConnection().prepareStatement( consultaNumLinea );
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) throw new Exception("ERROR en SELECT numLinea");
			numLinea = rs.getInt(1);

			ps = con.getConnection().prepareStatement( consultaLinea );
			ps.setInt( 1, numLinea);
			ps.setInt( 2, numPedido );
			ps.setInt( 3, lin.getIdProd());
			ps.setInt( 4, lin.getCantidad());
			resultado  = ps.executeUpdate();
			System.out.println("Resultado: " + resultado);
			System.out.println("Consulta: " + ps);
			if(resultado < 1) throw new Exception("ERROR en INSERT Lineas");

			con.getConnection().commit();
			System.out.println("OK");
		}
		catch(SQLException ex) {
			System.out.println( "ERROR DE TRANSACCION" );
			ex.printStackTrace();
			try { con.getConnection().rollback(); }
			catch (SQLException e) { e.printStackTrace();}
			throw ex;
		}
		catch( Exception e) { e.printStackTrace(); }
		
		try { ps.close(); } catch (Exception ex) {ex.printStackTrace();}

	}
}
