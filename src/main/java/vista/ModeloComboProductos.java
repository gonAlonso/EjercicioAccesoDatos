package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Producto;
import modeloVo.Proveedor;

public class ModeloComboProductos extends JComboBox<Producto>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModeloComboProductos(){
		cargarProveedores();
	}
	
	public void cargarProveedores() {
		ArrayList<Producto> productos = Controlador.cargarListaProductos();
		if (productos == null) return;
		for( Producto pro : productos) {
			this.addItem( pro );
		}
	}
}