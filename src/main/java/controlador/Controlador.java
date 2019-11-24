package controlador;

import java.util.ArrayList;

import conexion.Conexion;
import modeloDao.ClientesDao;
import modeloDao.FacturaDao;
import modeloDao.LineaPedidoDao;
import modeloDao.PedidosDao;
import modeloDao.ProductosDao;
import modeloDao.ProveedoresDao;
import modeloVo.BeneficiosProductos;
import modeloVo.Cliente;
import modeloVo.Existencias;
import modeloVo.Factura;
import modeloVo.LineaFacturaMes;
import modeloVo.LineaPedido;
import modeloVo.Pedido;
import modeloVo.Producto;
import modeloVo.ProductosBajoMinimo;
import modeloVo.Proveedor;
import vista.Formulario01Principal;
import vista.Formulario02Productos;
import vista.Formulario03Minimos;
import vista.Formulario04IncPrecios;
import vista.Formulario05Beneficios;
import vista.Formulario06Valoracion;
import vista.Formulario07Pedidos;
import vista.Formulario07Pedidos_2;
import vista.Formulario08Facturas;

public class Controlador {
	private static Conexion cx = null;
	private static Formulario01Principal fPricipal = null;
	private static Formulario02Productos fProductos = null;
	private static Formulario03Minimos fMinimos = null;
	private static Formulario04IncPrecios fIncPrec = null;
	private static Formulario05Beneficios fBeneficios = null;
	private static Formulario06Valoracion fValoracion = null;
	private static Formulario07Pedidos fPedidos = null;
	private static Formulario08Facturas fFacturas = null;

	public static void main(String[] args) {
		cx = new Conexion();

		fPricipal = new Formulario01Principal();
		fProductos = new Formulario02Productos();
		fMinimos = new Formulario03Minimos();
		fIncPrec = new Formulario04IncPrecios();
		fBeneficios = new Formulario05Beneficios();
		fValoracion = new Formulario06Valoracion();
		fPedidos = new Formulario07Pedidos();
		fFacturas = new Formulario08Facturas();

		fPricipal.setVisible( true );
	}
	
	public static void mostrarProductos() { fProductos.setVisible( true );}
	public static void mostrarMinimos() { fMinimos.setVisible( true );}
	public static void mostrarBeneficio() { fBeneficios.setVisible( true );}
	public static void mostrarIncrPrecios() { fIncPrec.setVisible( true );}
	public static void mostrarValoracion() { fValoracion.setVisible( true ); }
	public static void mostrarPedidos() { fPedidos.setVisible( true ); }
	public static void mostrarFacturas() { fFacturas.setVisible( true ); }
	
	public static Conexion getConexion() { return cx; }
	
	public static ArrayList<ProductosBajoMinimo> getListaStockBajoMinimo(){
		return ProductosDao.getListaStockBajoMinimo();
	}

	public static ArrayList<Proveedor> cargarProveedores() {
		return ProveedoresDao.getListaProveedores();
	}

	public static int incPreciosProveedor(String proveedor, double incremento) {
		return ProductosDao.incPreciosProveedor( proveedor, incremento);
		
	}

	public static ArrayList<BeneficiosProductos> getListaStockBeneficios() {
		return ProductosDao.getListaBeneficiosProductos();
	}

	public static ArrayList<Existencias> getValoracionExistencias() {
		return ProductosDao.getValoracionExistencias();
	}
	
	public static double getTotalValoracionExistencias() {
		return ProductosDao.getTotalValoracionExistencias();
	}

	public static ArrayList<LineaPedido> getListaLineasPedido(int n) {
		return LineaPedidoDao.getListaLineasPedido(n);
	}

	public static ArrayList<Pedido> cargarListaPedidos() {
		return PedidosDao.cargarListaPedidos();
	}

	public static ArrayList<Producto> cargarListaProductos() {
		return ProductosDao.cargarListaProductos();
	}

	public static ArrayList<Cliente> cargarListaClientes() {
		return ClientesDao.cargarListaClientes();
	}

	public static void eliminarPedido(int numPed) {
		PedidosDao.eliminarPedido(numPed);
	}
	
	public static int addPedido(Pedido ped, ArrayList<LineaPedido> lista) throws Exception {
		return PedidosDao.addPedido(ped, lista);
	}

	public static void updateDatosPedido(Pedido ped) throws Exception {
		 PedidosDao.updateDatosPedido(ped);
	}

	public static void deleteLineaPedido(int selectedRow) throws Exception {
		LineaPedidoDao.deleteLineaPedido(selectedRow);
	}

	public static void addLineaPedido(int num, LineaPedido lin) throws Exception{
		LineaPedidoDao.addLineaPedido(num, lin);
	}

	public static Cliente getCliente(String nifCliente){
		return ClientesDao.getCliente(nifCliente);
	}

	public static Factura getDatosFactura(int numPedido) {
		return FacturaDao.getDatosFactura(numPedido);
	}

	public static ArrayList<LineaFacturaMes> getListaFacturasMes(int mes) {
		return FacturaDao.getListaFacturasMes(mes);
	}

	public static ArrayList<LineaFacturaMes> getListaFacturasCliente(String nif) {
		return FacturaDao.getListaFacturasCliente(nif);
	}
}
