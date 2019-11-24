package vista;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controlador.Controlador;
import controlador.Logica;
import modeloVo.Cliente;
import modeloVo.LineaPedido;
import modeloVo.Pedido;
import modeloVo.Producto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

//import org.graalvm.compiler.hotspot.phases.aot.EliminateRedundantInitializationPhase;

import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

public class Formulario07Pedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtFieldFecha;
	private JTextField txtFieldDescuento;
	private JTable table;
	private JPanel panel_add_producto;
	private JLabel lblNewLabel_2;
	private JButton btnNuevoPedido;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnCancel;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel label;
	private JTextField txtFieldCantidad;
	private JButton btnNuevoItem;
	private JLabel lblCliente;
	private ModeloComboClientes modeloComboClientes;
	private ModeloComboProductos comboBoxProductos;
	private ModeloComboPedidos modeloComboPedidos;
	private ModeloTablaLineasPedido modeloTablaLineasPedido;
	private int elmEliminar;
	private M modo = M.MODO_VISTA;	
	
	static enum M{
		MODO_VISTA,
		MODO_EDICION,
		MODO_ADD,
		MODO_EDICION_DEL
	}

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario07Pedidos frame = new Formulario07Pedidos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 * @param cx 
	 */
	public Formulario07Pedidos() {
		super("Gestion de Pedidos");
		modo = M.MODO_VISTA;
		try { UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());}  catch (Exception e) {}
		setBounds(100, 100, 615, 373);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{76, 97, 177, 87, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 37, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Pedido");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		modeloComboPedidos = new ModeloComboPedidos();
		GridBagConstraints gbc_comboBox_1_1_1_1 = new GridBagConstraints();
		gbc_comboBox_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_1_1_1.gridx = 1;
		gbc_comboBox_1_1_1_1.gridy = 0;
		panel.add(modeloComboPedidos, gbc_comboBox_1_1_1_1);
		modeloComboPedidos.addActionListener( new ActionComboPedidos() );
		
		lblNewLabel_2 = new JLabel("Fecha");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		
		txtFieldFecha = new JTextField();
		txtFieldFecha.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldFecha.setEnabled(false);
		GridBagConstraints gbc_Fecha = new GridBagConstraints();
		gbc_Fecha.insets = new Insets(0, 0, 5, 0);
		gbc_Fecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_Fecha.gridx = 3;
		gbc_Fecha.gridy = 0;
		panel.add(txtFieldFecha, gbc_Fecha);
		txtFieldFecha.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 1;
		panel.add(lblCliente, gbc_lblCliente);
		
		modeloComboClientes = new ModeloComboClientes();
	
		GridBagConstraints gbc_modeloComboPedidos = new GridBagConstraints();
		gbc_modeloComboPedidos.insets = new Insets(0, 0, 5, 5);
		gbc_modeloComboPedidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_modeloComboPedidos.gridx = 1;
		gbc_modeloComboPedidos.gridy = 1;
		panel.add(modeloComboClientes, gbc_modeloComboPedidos);
		modeloComboClientes.setEnabled( false );
		
		label = new JLabel("% Descuento");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		txtFieldDescuento = new JTextField();
		txtFieldDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 3;
		gbc_textField_1.gridy = 1;
		txtFieldDescuento .setEnabled(false);
		panel.add(txtFieldDescuento, gbc_textField_1);
		txtFieldDescuento.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		modeloTablaLineasPedido = new ModeloTablaLineasPedido();
		table = new JTable( modeloTablaLineasPedido );
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setEnabled( false );
		table.setRowSelectionAllowed(true);
		table.setColumnSelectionAllowed(false);
		//table.setCellSelectionEnabled(true);
		//table.setShowVerticalLines(false);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener( new ActionTableLineasPedido());
		setTabla();
		
		
		panel_add_producto = new JPanel();
		panel_add_producto.setBorder(new TitledBorder(null, "Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_add_producto = new GridBagConstraints();
		gbc_panel_add_producto.gridwidth = 4;
		gbc_panel_add_producto.fill = GridBagConstraints.BOTH;
		gbc_panel_add_producto.gridx = 0;
		gbc_panel_add_producto.gridy = 6;
		panel.add(panel_add_producto, gbc_panel_add_producto);
		GridBagLayout gbl_panel_add_producto = new GridBagLayout();
		gbl_panel_add_producto.columnWidths = new int[]{73, 184, 102, 59, 99, 0};
		gbl_panel_add_producto.rowHeights = new int[]{26, 0};
		gbl_panel_add_producto.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_add_producto.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_add_producto.setLayout(gbl_panel_add_producto);
		
		lblNewLabel_3 = new JLabel("Producto");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_add_producto.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		comboBoxProductos = new ModeloComboProductos();
		comboBoxProductos.setEnabled(false);
		GridBagConstraints gbc_comboBox_12 = new GridBagConstraints();
		gbc_comboBox_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_12.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_12.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_12.gridx = 1;
		gbc_comboBox_12.gridy = 0;
		panel_add_producto.add(comboBoxProductos, gbc_comboBox_12);
		
		lblNewLabel_4 = new JLabel("Cantidad");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_add_producto.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtFieldCantidad = new JTextField();
		txtFieldCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldCantidad.setEnabled(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 0;
		panel_add_producto.add(txtFieldCantidad, gbc_textField_2);
		txtFieldCantidad.setColumns(10);
		
		btnNuevoItem = new JButton("Añadir");
		btnNuevoItem.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		panel_add_producto.add(btnNuevoItem, gbc_btnNewButton);
		btnNuevoItem.addActionListener(new ActionBotonItem());
	
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnNuevoPedido = new JButton("NUEVO");
		btnNuevoPedido.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnNuevoPedido);
		btnNuevoPedido.addActionListener(new ActionBotonNuevo());
		
		btnEliminar = new JButton("ELIMINAR PEDIDO");
		btnEliminar.setEnabled(false);
		btnEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnEliminar);
		btnEliminar.addActionListener(new ActionBotonEliminar() );
		
		btnEditar = new JButton("EDITAR PED.");
		btnEditar.setEnabled(false);
		panel_1.add(btnEditar);
		btnEditar.addActionListener( new ActionBotonEditar() );
		
		separator = new JSeparator();
		panel_1.add(separator);
		
		btnCancel = new JButton("SALIR");
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionBotonCancel());
		
		setModo(M.MODO_VISTA);
	}
	
	private void setTabla() {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		TableColumnModel tModel = table.getColumnModel();
		
		tModel.getColumn(0).setCellRenderer( rightRenderer );
		tModel.getColumn(2).setCellRenderer( rightRenderer );
		tModel.getColumn(3).setCellRenderer( rightRenderer );
		tModel.getColumn(4).setCellRenderer( rightRenderer );
	}
	
	private void setModo(M nuevo) {
		if( nuevo == M.MODO_ADD) {
			btnNuevoPedido.setEnabled(true);
			btnNuevoPedido.setText("GUARDAR");
			btnCancel.setText("CANCELAR");
			btnEliminar.setText("ELIMINAR");
			btnEliminar.setEnabled(false);
			btnNuevoItem.setEnabled( true );
			btnNuevoItem.setText("Añadir");
			btnEditar.setEnabled(false);
			txtFieldCantidad.setEnabled(true);
			txtFieldFecha.setText( "DEFAULT" );
			txtFieldFecha.setEnabled( true );
			txtFieldDescuento.setEnabled( true );
			modeloComboClientes.setEnabled( true );
			modeloComboPedidos.setEnabled( false );
			comboBoxProductos.setEnabled( true );
			table.setEnabled( true );
			table.clearSelection();
		}
		else if( nuevo == M.MODO_EDICION) {
			btnNuevoPedido.setEnabled(false);
			btnCancel.setText("CANCELAR");
			btnEliminar.setText("ELIMINAR ELM");
			btnEliminar.setEnabled(false);
			btnEditar.setEnabled(true);
			btnEditar.setText( "TERMINAR");
			btnNuevoItem.setEnabled(true);
			btnNuevoItem.setText("Añadir");
			txtFieldFecha.setEnabled(true);
			txtFieldDescuento.setEnabled(true);
			txtFieldCantidad.setEnabled(true);
			modeloComboClientes.setEnabled(true);
			modeloComboPedidos.setEnabled(false);
			comboBoxProductos.setEnabled(true);
			table.setEnabled(true);
			table.clearSelection();
		}
		else if( nuevo == M.MODO_EDICION_DEL) {
			btnNuevoPedido.setEnabled(false);
			btnCancel.setText("CANCELAR");
			btnEliminar.setText("ELIMINAR ELM");
			btnEliminar.setEnabled(true);
			btnNuevoItem.setEnabled(false);
			txtFieldDescuento.setEnabled(true);
			txtFieldFecha.setEnabled(true);
			txtFieldCantidad.setEnabled(true);
			modeloComboClientes.setEnabled(true);
			modeloComboPedidos.setEnabled(false);
			comboBoxProductos.setEnabled(true);
			//table.setEnabled(true);
			//table.clearSelection();
		}
		else if( nuevo == M.MODO_VISTA) {
			btnNuevoPedido.setEnabled(true);
			btnNuevoPedido.setText("NUEVO");
			btnCancel.setText("SALIR");
			btnEliminar.setText("ELIMINAR");
			btnEliminar.setEnabled(true);
			btnEditar.setEnabled(true);
			btnEditar.setText( "EDITAR PED.");
			btnNuevoItem.setEnabled(false);
			btnNuevoItem.setText("Añadir");
			txtFieldFecha.setEnabled(false);
			txtFieldDescuento.setEnabled(false);
			txtFieldCantidad.setEnabled(false);
			modeloComboPedidos.setEnabled(true);
			modeloComboClientes.setEnabled(false);
			comboBoxProductos.setEnabled(false);
			table.setEnabled(false);
			table.clearSelection();
		}
		modo = nuevo;
	}
	
	
	// Carga el pedido por defecto y lo muestra
	@Override
	public void setVisible(boolean b) {
		try {
			if (b) modeloComboPedidos.setSelectedIndex(0);
		}
		catch(Exception ex) { ex.printStackTrace();}
		super.setVisible(b);
	}
	
	private void updateTablaLineasPedido(int num) {
		modeloTablaLineasPedido.cargarLineasPedidos(num);
		modeloTablaLineasPedido.fireTableDataChanged();
	}
	
	
	// MANEJADOR DEL COMBO DE PEDIDOS
	class ActionComboPedidos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Pedido ped= (Pedido) modeloComboPedidos.getSelectedItem();
			if( ped == null) {
				setModo( M.MODO_VISTA );
				System.out.println( "PEDIDO NULO EN COMBOBOX:PASS" );
				return;
			}

			txtFieldFecha.setText( ped.getFecha());
			txtFieldDescuento.setText( String.valueOf( ped.getDescuento()));
			if (modeloComboClientes.selectCliente( ped.getNifCliente() ) == false )
				System.out.println( "No se encuentra el Cliente" );
			updateTablaLineasPedido( ped.getNumPedido());
			setModo(M.MODO_VISTA);
		}
	}
	
	class ActionTableLineasPedido implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			if( e.getValueIsAdjusting()  || table.getSelectedRow() <0) return; 
			elmEliminar = table.getSelectedRow();
			setModo( M.MODO_EDICION_DEL);
		}
	}
	
	class ActionBotonEditar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(modo == M.MODO_EDICION_DEL) {
				// Clear selection, return back to edit_mode
				table.clearSelection();
				setModo( M.MODO_EDICION);
			}
			else if(modo == M.MODO_EDICION) {
				//double descuento = 0;
				// TODO: Save changes to SQL ??? :: live SQL Changes
				// SAVE Pedido info!!!
				if(!checkInputFecha()) return;

				Pedido ped = (Pedido)modeloComboPedidos.getSelectedItem();
				ped.setFecha( txtFieldFecha.getText() );
				
				try { ped.setDescuento(  Double.parseDouble( txtFieldDescuento.getText() )); }
				catch(Exception ex){ JOptionPane.showMessageDialog(null,  "Valor de descuento incorrecto"); return; }
				
				try { ped.setNifCliente( ((Cliente)modeloComboClientes.getSelectedItem()).getNif() ); }
				catch(Exception ex){ JOptionPane.showMessageDialog(null,  "Valor cliente incorrecto"); return; }
				
				try { Controlador.updateDatosPedido( ped );}
				catch( Exception ex ) { ex.printStackTrace(); JOptionPane.showMessageDialog(null,  "No se ha podido guardar los cambios"); return; }
				setModo( M.MODO_VISTA );
			}
			else if(modo == M.MODO_VISTA) {
				setModo(M.MODO_EDICION);
			}
			else {
				System.out.println("OPCION DEFECTO en ActionBotonEditar");
				modo = M.MODO_VISTA;
			}
		}
	}
	
	private boolean checkInputFecha() {
		if( Logica.txtFechaOK(txtFieldFecha))
			return true;
		JOptionPane.showMessageDialog(null,  "La fecha es incorrecta");
		return false ;
	}
	
	class ActionBotonNuevo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(modo == M.MODO_VISTA) {
				modeloComboPedidos.addEmptyElm();
				modeloTablaLineasPedido.clear();
				setModo(M.MODO_ADD);
				txtFieldFecha.setText( Logica.getFechaActual());
				System.out.println( "MODO: "+modo);
			}
			else if(modo == M.MODO_ADD) {
				ArrayList<LineaPedido> lista = new ArrayList<LineaPedido>();
				double descuento;
				int numPedidoNuevo = 0;
				
				// Check data
				if(!checkInputFecha()) return;

				try { descuento = Double.parseDouble( txtFieldDescuento.getText() ); }
				catch(Exception ex){ JOptionPane.showMessageDialog(null,  "Valor de descuento incorrecto"); return; }
				
				//Guardar los datos!!
				Pedido nPed = new Pedido(0,
						txtFieldFecha.getText(),
						((Cliente)modeloComboClientes.getSelectedItem()).getNif(),
						descuento);

				ModeloTablaLineasPedido model = (ModeloTablaLineasPedido) table.getModel();
				for (int row = 0; row < table.getRowCount(); row++) {	// Lee lineas del pedido
					 lista.add( model.getLinea(row));
				 }
				try {
					numPedidoNuevo =  Controlador.addPedido(nPed, lista);
				} catch(Exception ex) {
					// Se mantienen los datos...
					JOptionPane.showMessageDialog(null,  "Error al guardar el pedido. No se han realizado cambios");
					return;
				}
				modeloTablaLineasPedido.cargarLineasPedidos( numPedidoNuevo );
				//modeloComboPedidos.selectPedido( numPedidoNuevo );
				modeloComboPedidos.recargarListaPedidos();
				modeloComboPedidos.selectPedido( numPedidoNuevo );
				setModo(M.MODO_VISTA);
			}	
		}
	}
	
	class ActionBotonEliminar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int numPed = ((Pedido)modeloComboPedidos.getSelectedItem()).getNumPedido();
			if(modo == M.MODO_EDICION_DEL) {	//Eliminar items seleccionados
				if ( elmEliminar < 0) {
					JOptionPane.showMessageDialog(null,  "Elemento seleccionado incorrecto. Cancelado");
					table.clearSelection();
					elmEliminar = -1;
					return;
				}
				if(JOptionPane.showConfirmDialog(null,
						"Se va a eliminar esta linea de pedido de forma definitiva",
						"¿Estas segura?",JOptionPane.YES_NO_OPTION) == 1)
					return;

				try {
					LineaPedido lin = modeloTablaLineasPedido.getLinea(  elmEliminar );
					System.out.println( "Numero de linea de pedido: "+ lin.getLiId() );
					Controlador.deleteLineaPedido( lin.getLiId() );
				}
				catch( Exception ex ) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,  "Error al eliminar la Linea de Pedido. Revisa los mensajes de consola");
				}
				modeloTablaLineasPedido.cargarLineasPedidos(numPed);
				// Update table :: No elm should be selected afterwards 
				setModo( M.MODO_EDICION);
			}
			else if( modo == M.MODO_VISTA) {	// Eliminar el pedido entero
				if(JOptionPane.showConfirmDialog(null,
						"Se va a eliminar este Pedido",
						"¿Estas segura?",JOptionPane.YES_NO_OPTION) == 1)
					return;

				Controlador.eliminarPedido( numPed );
				modeloComboPedidos.recargarListaPedidos();
				setModo( M.MODO_VISTA);
			}
			System.out.println("MODO: "+modo);
		}
	}
	
	class ActionBotonCancel implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println( modo );
			if (modo == M.MODO_EDICION ) {
				setModo(M.MODO_VISTA);
			}
			else if (modo == M.MODO_EDICION_DEL ) {
				table.clearSelection();
				setModo(M.MODO_VISTA);
			}
			else if( modo == M.MODO_VISTA) {
				dispose();
			}
			else {//if( modo == M.MODO_EDICION) {
				modeloComboPedidos.actualizarComboPedidos();
				setModo(M.MODO_VISTA);
			}
		}
	}
	
	class ActionBotonItem implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println( modo );
			if (( modo == M.MODO_ADD) || (modo == M.MODO_EDICION )) {
				// Crea linea pedido co elm. seleccionado
				int cantidad;
				Producto pro = (Producto)comboBoxProductos.getSelectedItem();

				if(pro == null) {
					JOptionPane.showMessageDialog(null,  "Error en el producto seleccionado");
					comboBoxProductos.requestFocus();
					return;
				}
				
				try {
					cantidad = Integer.parseInt( txtFieldCantidad.getText() );
				}
				catch(Exception ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,  "Numero de unidades incorrectas");
					txtFieldCantidad.requestFocus();
					return;
				}
				LineaPedido nuevaLin = new LineaPedido(//liId, idProd, cantidad, nombreProd, precio, importe)
						modeloTablaLineasPedido.getRowCount()+1,
						pro.getId(),
						cantidad,
						pro.getNombre(),
						pro.getPrecioVenta(),
						pro.getPrecioVenta()*cantidad);
				if ( modo == M.MODO_ADD) {
					// ADD Mode optimization. Waits for the hole order to be completed
					modeloTablaLineasPedido.addLinea( nuevaLin );
				}
				else if (modo == M.MODO_EDICION ) {
					// Add new line directly
					System.out.println("ADD nueva Linea");
					try {
						int numPed = ((Pedido)modeloComboPedidos.getSelectedItem()).getNumPedido();
						modeloTablaLineasPedido.addLineaAPedido( numPed, nuevaLin );
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null,  "No se ha podido añadir el producto");
						e1.printStackTrace();
					}
				}
			}
			if (modo == M.MODO_EDICION_DEL ) {
			}
			else if( modo == M.MODO_VISTA) {

			}
			else {
			}
		}
	}
}
