package vista;

import java.util.ArrayList;

import javax.swing.JComboBox;

import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Pedido;

public class ModeloComboMeses extends JComboBox<String>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModeloComboMeses(){
		addItem( "Enero" );
		addItem( "Febrero" );
		addItem( "Marzo" );
		addItem( "Abril" );
		addItem( "Mayo" );
		addItem( "Junio" );
		addItem( "Julio" );
		addItem( "Agosto" );
		addItem( "Septiembre" );
		addItem( "Octubre" );
		addItem( "Noviembre" );
		addItem( "Diciembre" );
	}

}