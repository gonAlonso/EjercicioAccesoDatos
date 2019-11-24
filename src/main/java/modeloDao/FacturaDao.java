package modeloDao;

import java.math.RoundingMode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import conexion.Conexion;
import controlador.Controlador;
import modeloVo.Factura;
import modeloVo.LineaFacturaMes;

public class FacturaDao {
	public static Factura getDatosFactura(int numPedido) {
		String consulta = "SELECT SUM(liCantidad * pdPrecioVenta) as subtotal,"+
					" SUM(liCantidad * pdPrecioVenta)* clDescuento/100 as descuento,"+
					" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) as baseImponible,"+
					" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) * (pdIva/100) as iva,"+
					" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) * (1+pdIva/100) as total"+
					" FROM LineasPedido join Productos on liIdProducto=pdId join Pedidos on peNumPedido=liNumPedido join Clientes on clNif=peNifCliente WHERE liNumPedido = ?;";	
		Conexion con = Controlador.getConexion();
		Factura fact = null;
		ResultSet resultado;
		PreparedStatement ps;

		try {
			ps = con.getConnection().prepareStatement( consulta );
			ps.setInt(1, numPedido);
			resultado  = ps.executeQuery(); 
			if( !resultado.next()) throw new Exception("No se ha encontrado el Pedido");
			fact = new Factura(//subtotal, descuento, baseImponible, iva, total)
					resultado.getDouble( "subtotal" ),
					resultado.getDouble( "descuento" ),
					resultado.getDouble( "baseImponible" ),
					resultado.getDouble( "iva" ),
					resultado.getDouble( "total" ));
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			ps.close();
		} catch (Exception e) {}
		
		return fact;
	}

	public static ArrayList<LineaFacturaMes> getListaFacturasMes(int mes) {
		String consulta = "SELECT peNumPedido, peFecha, " +
				" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) as baseImponible,"+
				" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) * (pdIva/100) as iva,"+
				" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) * (1+pdIva/100) as total"+
				" FROM LineasPedido join Productos on liIdProducto=pdId "
				+ "join Pedidos on peNumPedido=liNumPedido "
				+ "join Clientes on clNif=peNifCliente "
				+ "WHERE MONTH(peFecha) = ?"
				+ " GROUP BY peNumPedido;";
		Conexion con = Controlador.getConexion();
		ArrayList<LineaFacturaMes> lista = new ArrayList<LineaFacturaMes>();
		LineaFacturaMes lin = null;
		ResultSet resultado;
		PreparedStatement ps;

		try {
			ps = con.getConnection().prepareStatement( consulta );
			ps.setInt(1, mes);
			resultado  = ps.executeQuery(); 
			while( resultado.next() ) {
				lin = new LineaFacturaMes(//numero, fecha, baseImponible, iva, total)
						resultado.getInt( "peNumPedido" ),
						resultado.getString( "peFecha" ),
						resultado.getDouble( "baseImponible" ),
						resultado.getDouble( "iva" ),
						resultado.getDouble( "total" ));
				lista.add( lin );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}
	
		
		try {
			resultado.close();
			ps.close();
		} catch (Exception e) {}
		
		return lista;
	}

	public static ArrayList<LineaFacturaMes> getListaFacturasCliente(String nif) {
		String consulta = "SELECT peNumPedido, peFecha, " +
				" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) as baseImponible,"+
				" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) * (pdIva/100) as iva,"+
				" SUM(liCantidad * pdPrecioVenta)* (1-clDescuento/100) * (1+pdIva/100) as total"+
				" FROM LineasPedido join Productos on liIdProducto=pdId "
				+ "join Pedidos on peNumPedido=liNumPedido "
				+ "join Clientes on clNif=peNifCliente "
				+ "WHERE clNif = ?"
				+ " GROUP BY peNumPedido;";
		Conexion con = Controlador.getConexion();
		ArrayList<LineaFacturaMes> lista = new ArrayList<LineaFacturaMes>();
		LineaFacturaMes lin = null;
		ResultSet resultado;
		PreparedStatement ps;

		try {
			ps = con.getConnection().prepareStatement( consulta );
			ps.setString(1, nif);
			resultado  = ps.executeQuery(); 
			while( resultado.next() ) {
				lin = new LineaFacturaMes(//numero, fecha, baseImponible, iva, total)
						resultado.getInt( "peNumPedido" ),
						resultado.getString( "peFecha" ),
						resultado.getDouble( "baseImponible" ),
						resultado.getDouble( "iva" ),
						resultado.getDouble( "total" ));
				lista.add( lin );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}
	
		
		try {
			resultado.close();
			ps.close();
		} catch (Exception e) {}
		
		return lista;
	}
}

