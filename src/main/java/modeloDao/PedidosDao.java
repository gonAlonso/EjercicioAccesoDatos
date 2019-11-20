package modeloDao;

import java.sql.ResultSet;
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
	
	
}
