package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Pedido;

public class ModeloComboPedidos extends JComboBox<Pedido>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModeloComboPedidos(){
		cargarListaPedidos();
	}
	
	public void cargarListaPedidos() {
		ArrayList<Pedido> listaPedidos = Controlador.cargarListaPedidos();
		if (listaPedidos == null) return;
		for( Pedido ped : listaPedidos) {
			this.addItem( ped );
		}
	}
	
	public void addEmptyElm() {
		Pedido ped = new Pedido();
		ped.setNifCliente("***");
		ped.setNumPedido(0);
		this.addItem( ped );
		setSelectedItem( ped );
	}
}