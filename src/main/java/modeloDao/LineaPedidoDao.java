package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
