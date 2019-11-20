package modeloDao;

import java.util.ArrayList;

import modeloVo.LineaPedido;
import modeloVo.Pedido;

public class PedidosDao {
	public static ArrayList<Pedido> getlistaPedidos(){ return null; }
	public static ArrayList<Pedido> getlistaPedidosMes(int mes){ return null; }
	public static ArrayList<Pedido> getlistaPedidosCliente(String cliente){ return null; }
	public static ArrayList<Pedido> addPedido( ArrayList<LineaPedido> lista) throws Exception { return null; }
	public static boolean deleteLineaPedido(int idPedido, int idLinea) { return false; }
	
	
}
