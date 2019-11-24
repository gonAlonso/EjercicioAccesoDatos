package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexion.Conexion;
import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Factura;
import modeloVo.Producto;

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
}

