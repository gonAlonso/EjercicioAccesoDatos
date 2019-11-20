package modeloDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.CallableStatement;

import conexion.Conexion;
import controlador.Controlador;
import modeloVo.BeneficiosProductos;
import modeloVo.Existencias;
import modeloVo.Producto;
import modeloVo.ProductosBajoMinimo;

public class ProductosDao {
	
public static boolean addProducto(){ return false; }
	
	public static boolean delProducto(int id){ return false; }
	
	public static ArrayList<Producto> getListaProductos(){ return null;}
	
	public static int incrementarPrecioProductosProveedor( int proveedor, double incremento) { return 0; }
	
	public static ArrayList<ProductosBajoMinimo> getListaStockBajoMinimo(){
		String consulta = "SELECT pdId,pdNombre,pdPrecioCompra,pdStock,pdPrecioVenta,prNombre,prTelefono FROM Productos JOIN Proveedores ON pdNifProveedor = prNif WHERE pdStock < pdStockMinimo;";
		ArrayList<ProductosBajoMinimo> listaProductos = new ArrayList<ProductosBajoMinimo>();
		
		
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		ProductosBajoMinimo prod = null;
		//ArrayList<ProductosBajoMinimo > out = new ArrayList<ProductosBajoMinimo >();

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta ); 
			while( resultado.next()) {
				prod = new ProductosBajoMinimo(
						resultado.getInt( "pdId" ),
						resultado.getString( "pdNombre" ),
						resultado.getDouble( "pdPrecioCompra" ),
						resultado.getInt( "pdStock" ),
						resultado.getDouble( "pdPrecioVenta" ),
						resultado.getString( "prNombre" ),
						resultado.getString( "prTelefono" ));
				listaProductos.add( prod );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return listaProductos;
	}
	
	
	public static ArrayList<BeneficiosProductos> getListaBeneficiosProductos(){
		String consulta = "SELECT pdId,pdNombre,"
				+ "sum(pdPrecioCompra ) as precioCompra,"
				+ "sum(pdPrecioVenta) as precioVenta,"
				+ "sum(pdPrecioVenta) - sum(pdPrecioCompra ) as beneficio,"
				+ "prNombre,prTelefono,prWeb, sum(liCantidad) as unidades "
				+ "FROM Productos JOIN Proveedores ON pdNifProveedor = prNif "
				+ "JOIN LineasPedido ON liIdProducto = pdId "
				+ "GROUP BY pdId ORDER BY unidades;";
						
		ArrayList<BeneficiosProductos> listaProductos = new ArrayList<BeneficiosProductos>();
		
		
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		BeneficiosProductos prod = null;

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta ); 
			while( resultado.next()) {
				prod = new BeneficiosProductos(//id, producto, precioCompra, precioVenta, cantidad, beneficio, proveedor, telefono, web)
					resultado.getInt( "pdId"),
					resultado.getString( "pdNombre"),
					resultado.getDouble( "precioCompra"),
					resultado.getDouble( "precioVenta"),
					resultado.getInt( "unidades"),
					resultado.getDouble( "beneficio"),
					resultado.getString( "prNombre"),
					resultado.getString( "prTelefono"),
					resultado.getString( "prWeb"));
				listaProductos.add( prod );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return listaProductos;
	}

	public static int incPreciosProveedor(String proveedor, double incremento) {
		String consulta = "select prIncrementaPreciosProveedor( ?, ?) as numprods;";
		//String consulta = "select year( curdate()) as numprods;";
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		PreparedStatement ps;
		int numeroActualizados = 0;

		try {
			ps = con.getConnection().prepareStatement(consulta);
			ps.setString(1, proveedor);
			ps.setDouble(2, incremento );
			resultado  = ps.executeQuery();
			
			if( resultado.next())
				numeroActualizados = resultado.getInt( "numprods" );
		} catch( Exception e) {
			e.printStackTrace();
			return 0;
		}

		
		try {
			resultado.close();
			ps.close();
		} catch (Exception e) {}
		
		return numeroActualizados;
	}

	public static ArrayList<Existencias> getValoracionExistencias() {
		String consulta = "SELECT pdNombre, pdStock, pdPrecioCompra, pdStock*pdPrecioCompra AS total "
				+ " FROM Productos "
				+ " ORDER BY total;";
		ArrayList<Existencias> listaProductos = new ArrayList<Existencias>();
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		Existencias prod = null;

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta ); 
			while( resultado.next()) {
				prod = new Existencias(//id, producto, precioCompra, precioVenta, cantidad, beneficio, proveedor, telefono, web)
					resultado.getString( "pdNombre"),
					resultado.getInt( "pdStock"),
					resultado.getDouble( "pdPrecioCompra"),
					resultado.getDouble( "total"));
				listaProductos.add( prod );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return listaProductos;
	}

	

	public static double getTotalValoracionExistencias() {
		String consulta = "SELECT sum( pdStock*pdPrecioCompra) AS total FROM Productos;";
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		double numeroActualizados = 0;

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta );
			
			if( resultado.next())
				numeroActualizados = resultado.getDouble( "total" );
		} catch( Exception e) {
			e.printStackTrace();
			return 0;
		}

		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return numeroActualizados;
	}

	public static ArrayList<Producto> cargarListaProductos() {
		String consulta = "SELECT *"
				+ " FROM Productos "
				+ " ORDER BY pdNombre;";
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();
		Conexion con = Controlador.getConexion();
		ResultSet resultado = null;
		Statement st;
		Producto prod = null;

		try {
			st = con.getConnection().createStatement();
			resultado  = st.executeQuery( consulta ); 
			while( resultado.next()) {
				prod = new Producto(
					resultado.getInt( "pdId"),
					resultado.getString( "pdNombre"),
					resultado.getDouble( "pdPrecioCompra"),
					resultado.getInt( "pdStock"),
					resultado.getString( "pdNifPRoveedor"),
					resultado.getDouble( "pdPrecioVenta"),
					resultado.getInt( "pdStockMinimo"),
					resultado.getDouble( "pdIVA"));
				listaProductos.add( prod );
			}
		} catch( Exception e) {
			e.printStackTrace();
			return null;
		}

		
		try {
			resultado.close();
			st.close();
		} catch (Exception e) {}
		
		return listaProductos;
	}
}
