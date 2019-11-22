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
import modeloVo.ProductosBajoMinimo;

public class PedidosDao {
	public static ArrayList<Pedido> getlistaPedidosMes(int mes){ return null; }
	public static ArrayList<Pedido> getlistaPedidosCliente(String cliente){ return null; }
	public static ArrayList<Pedido> addPedido( ArrayList<LineaPedido> lista) throws Exception { return null; }
	public static boolean deleteLineaPedido(int idPedido, int idLinea) { return false; }
	

	public static ArrayList<Pedido> cargarListaPedidos() {
		String consulta = "SELECT * from Pedidos ORDER BY peNumPedido;";
		ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		Pedido ped = null;

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta ); 
			while( resultado.next()) {
				ped = new Pedido(	//(numPedido, fecha, nifCliente, descuento)
						resultado.getInt( "peNumPedido" ),
						resultado.getString( "peFecha" ),
						resultado.getString( "peNifCliente" ),
						resultado.getDouble( "peDescuento" ));
				listaPedidos.add( ped );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return listaPedidos;
	}


	
	public static void eliminarPedido(int numPed) {
		System.out.println("Eliminar Pedido: " + numPed );
				
		String consultaLineas = "DELETE from LineasPedido WHERE liNumPedido = ?;";
		String consultaPedido = "DELETE from Pedidos WHERE peNumPedido = ?;";
		Conexion con = Controlador.getConexion();
		int resultado;
		PreparedStatement ps = null;
		Pedido ped = null;

		try {
			con.getConnection().setAutoCommit(false);		//Start transaction
			ps = con.getConnection().prepareStatement( consultaLineas );
			ps.setInt( 1, numPed );
			resultado  = ps.executeUpdate();
			
			ps = con.getConnection().prepareStatement( consultaPedido );
			ps.setInt( 1, numPed );
			resultado  = ps.executeUpdate();
			
			con.getConnection().commit();
		}
		catch(SQLException ex) {
			System.out.println( "ERROR DE TRANSACCION" );
			try { con.getConnection().rollback(); }
			catch (SQLException e) { e.printStackTrace();}
		}
		catch( Exception e) {
			e.printStackTrace();
			return;
		}

		
		try {
			ps.close();
		} catch (Exception e) {}
	}
	
	public static boolean addPedido(Pedido ped, ArrayList<LineaPedido> lista) {
		System.out.println("AñadirPedido");
				
		String consultaLineas = "INSERT INTO LineasPedido (liId, liNumPedido, liIdProducto,liCantidad) VALUES (?,?,?,?);";
		String consultaPedido = "INSERT INTO Pedidos (peNumPedido, peFecha, peNifCliente, peDescuento) VALUES (?,?,?,?);";
		
		Conexion con = Controlador.getConexion();
		int resultado = 0;
		PreparedStatement ps = null;

		try {
			con.getConnection().setAutoCommit(false);		//Start transaction

			ps = con.getConnection().prepareStatement( consultaPedido, Statement.RETURN_GENERATED_KEYS );
			
			ps.setString( 1, "null" );
			ps.setString( 2, "curdate()");
			ps.setString( 3, ped.getNifCliente() );
			ps.setDouble( 4, ped.getDescuento());
			resultado  = ps.executeUpdate();
			if(resultado == 0) throw new Exception();
			
			for( LineaPedido li : lista ) {
				ps = con.getConnection().prepareStatement( consultaLineas );
				ps.setInt( 1, li.getLiId());
				ps.setInt( 2, resultado );
				ps.setInt( 3, li.getIdProd());
				ps.setInt( 4, li.getCantidad());
				resultado  = ps.executeUpdate();
			}
			con.getConnection().commit();
		}
		catch(SQLException ex) {
			System.out.println( "ERROR DE TRANSACCION" );
			resultado = -1;
			try { con.getConnection().rollback(); }
			catch (SQLException e) { e.printStackTrace();}
		}
		catch( Exception e) {
			e.printStackTrace();
			resultado = -1;
		}
		try { ps.close(); }
		catch (Exception e) {}
		return (resultado > 0)? true : false;
	}
}
