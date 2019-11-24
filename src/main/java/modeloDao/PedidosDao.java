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
	
	/**
	 * Añade nuevo Pedido
	 * @param ped Objeto Pedido 
	 * @param lista Lista de LineasPedido
	 * @return El id de pedido nuevo
	 */
	public static int addPedido(Pedido ped, ArrayList<LineaPedido> lista) throws Exception {
		System.out.println("AñadirPedido");

		String consultaNumPedido = "SELECT max(peNumPedido) FROM Pedidos;";
		String consultaNumLinea = "SELECT max(liId) FROM LineasPedido;";
		String consultaLineas = "INSERT INTO LineasPedido (liId, liNumPedido, liIdProducto,liCantidad) VALUES (?,?,?,?);";
		String consultaPedido = "INSERT INTO Pedidos (peNumPedido, peFecha, peNifCliente, peDescuento) VALUES (?,?,?,?);";
		
		Conexion con = Controlador.getConexion();
		int resultado = 0;
		int numPedido = 0, numLinea;
		PreparedStatement ps = null;

		try {
			con.getConnection().setAutoCommit(false);		//Start transaction

			ps = con.getConnection().prepareStatement( consultaNumPedido );
			ResultSet rs = ps.executeQuery();
			if(!rs.next()) throw new Exception("ERROR en SELECT numPedido");
			numPedido = rs.getInt(1) +1;
			
			ps = con.getConnection().prepareStatement( consultaNumLinea );
			rs = ps.executeQuery();
			if(!rs.next()) throw new Exception("ERROR en SELECT numLinea");
			numLinea = rs.getInt(1);

			// Add row Pedido
			ps = con.getConnection().prepareStatement( consultaPedido, Statement.RETURN_GENERATED_KEYS );
			ps.setInt( 1, numPedido );
			ps.setString( 2, ped.getFecha());
			ps.setString( 3, ped.getNifCliente() );
			ps.setDouble( 4, ped.getDescuento());
			resultado  = ps.executeUpdate();
			if(resultado < 1) throw new Exception("ERROR en INSERT Pedido");
			
			// Add rows LineasPedido
			for( LineaPedido li : lista ) {
				ps = con.getConnection().prepareStatement( consultaLineas );
				ps.setInt( 1, ++numLinea);
				ps.setInt( 2, numPedido );
				ps.setInt( 3, li.getIdProd());
				ps.setInt( 4, li.getCantidad());
				resultado  = ps.executeUpdate();
				if(resultado < 1) throw new Exception("ERROR en INSERT Lineas");
			}
			con.getConnection().commit();
		}
		catch(SQLException ex) {
			System.out.println( "ERROR DE TRANSACCION" );
			ex.printStackTrace();
			try { con.getConnection().rollback(); }
			catch (SQLException e) { e.printStackTrace();}
			throw ex;
		}
		catch( Exception e) { e.printStackTrace(); }
		
		if(numPedido <= 0) throw new Exception("Numero Pedido inválido");
		
		try { ps.close(); } catch (Exception ex) {ex.printStackTrace();}

		return numPedido;
	}

	public static void updateDatosPedido(Pedido ped) throws Exception  {
		System.out.println("EditPedido");
		String consultaPedido = "UPDATE Pedidos SET peFecha=?, peNifCliente=?, peDescuento=? WHERE peNumPedido = ?";
		Conexion con = Controlador.getConexion();

		PreparedStatement ps = null;

		con.getConnection().setAutoCommit(true);		//Start transaction

		// Add row Pedido
		ps = con.getConnection().prepareStatement( consultaPedido);//, Statement.RETURN_GENERATED_KEYS );
		ps.setString( 1, ped.getFecha());
		ps.setString( 2, ped.getNifCliente() );
		ps.setDouble( 3, ped.getDescuento());
		ps.setInt( 4, ped.getNumPedido());
		if( ps.executeUpdate()< 1) throw new Exception("ERROR en INSERT Pedido");
		try { ps.close(); } catch (Exception ex) {ex.printStackTrace();}
	}
}
