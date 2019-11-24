package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Proveedor;

public class ModeloComboProveedores extends JComboBox<Proveedor>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<Proveedor> proveedores = null;
	
	public ModeloComboProveedores(){
		cargarProveedores();
	}
	
	public void cargarProveedores() {
		proveedores = Controlador.cargarProveedores();
		if(proveedores == null) return;
		for( Proveedor pro : proveedores) {
			this.addItem( pro );
		}
	}
}