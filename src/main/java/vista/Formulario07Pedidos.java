package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

import conexion.Conexion;
import modeloVo.Pedido;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

//import org.graalvm.compiler.hotspot.phases.aot.EliminateRedundantInitializationPhase;

import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;

public class Formulario07Pedidos extends JFrame {

	//private JFrame frame;
	//private JTabbedPane tabbedPane;
	private JTextField txtFieldFecha;
	private JTextField txtFieldDescuento;
	private JTable table;
	//private JTable table_1;
	//private JTable table_2;
	private ModeloComboPedidos modeloComboPedidos;
	private JPanel panel_add_producto;
	private JLabel lblNewLabel_2;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton bntCancel;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField txtFieldCantidad;
	private JButton btnNewButton;
	private M modo = M.MODO_VISTA;
	private JLabel lblCliente;
	private ModeloComboClientes modeloComboClientes;
	private ModeloComboProductos comboBoxProductos;
	private JLabel label;
	
	
	static enum M{
		MODO_VISTA,
		MODO_EDICION,
		MODO_ADD,
		MODO_SELECTED
	}

	/**
	 * Launch the application.
	 */
	
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

	/**
	 * Create the application.
	 * @param cx 
	 */
	public Formulario07Pedidos() {
		modo = M.MODO_VISTA;
		try { UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());}  catch (Exception e) {}
		setBounds(100, 100, 615, 373);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{76, 97, 114, 87, 0};
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
		txtFieldFecha.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		panel.add(txtFieldFecha, gbc_textField);
		txtFieldFecha.setColumns(10);
		
		lblCliente = new JLabel("Cliente");
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.anchor = GridBagConstraints.EAST;
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 0;
		gbc_lblCliente.gridy = 1;
		panel.add(lblCliente, gbc_lblCliente);
		
		modeloComboClientes = new ModeloComboClientes();
		modeloComboClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
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
		
		table = new JTable( new ModeloTablaLineasPedido() );
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		ActionTableLineasPedido actionTableLineasPedido = new ActionTableLineasPedido();
		table.getSelectionModel()
			.addListSelectionListener( actionTableLineasPedido );
		
		
		panel_add_producto = new JPanel();
		panel_add_producto.setBorder(new TitledBorder(null, "Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_add_producto = new GridBagConstraints();
		gbc_panel_add_producto.gridwidth = 4;
		gbc_panel_add_producto.fill = GridBagConstraints.BOTH;
		gbc_panel_add_producto.gridx = 0;
		gbc_panel_add_producto.gridy = 6;
		panel.add(panel_add_producto, gbc_panel_add_producto);
		GridBagLayout gbl_panel_add_producto = new GridBagLayout();
		gbl_panel_add_producto.columnWidths = new int[]{73, 184, 0, 0, 0, 0};
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
		txtFieldCantidad.setEnabled(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 0;
		panel_add_producto.add(txtFieldCantidad, gbc_textField_2);
		txtFieldCantidad.setColumns(10);
		
		btnNewButton = new JButton("Añadir");
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 0;
		panel_add_producto.add(btnNewButton, gbc_btnNewButton);
	
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnNuevo);
		btnNuevo.addActionListener(new ActionBotonNuevo());
		
		btnEliminar = new JButton("ELIMINAR PEDIDO");
		btnEliminar.setEnabled(false);
		btnEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnEliminar);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Seleccionado OK?
				modo = M.MODO_VISTA;
				// Eliminar campo
				// Deshabilitar botones
			}
		});
		
		btnEditar = new JButton("EDITAR PED.");
		btnEditar.setEnabled(false);
		panel_1.add(btnEditar);
		btnEditar.addActionListener( new ActionBotonEditar() );
		
		separator = new JSeparator();
		panel_1.add(separator);
		
		bntCancel = new JButton("SALIR");
		bntCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(bntCancel);
		bntCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( modo );
				if (modo == M.MODO_SELECTED ) {
					table.clearSelection();
					modo = M.MODO_VISTA;
					bntCancel.setText( "SALIR" );;
					btnEditar.setText( "EDITAR PED." );
					btnEliminar.setText( "ELIMINAR PED." ); 
					return;
				}
				else if( modo == M.MODO_VISTA) dispose();
				else  if( modo == M.MODO_ADD) {
					modeloComboPedidos.cargarListaPedidos();
					modeloComboPedidos.setEnabled(true);
					txtFieldFecha.setEnabled(false);
					modeloComboClientes.setEnabled(false);
					txtFieldDescuento.setEnabled(false);
					comboBoxProductos.setEnabled(false);
					txtFieldCantidad.setEnabled(false);
					btnNewButton.setEnabled(false);
				}
				modo = M.MODO_VISTA;
				
			}
		});
		
	}
	
	
	// Carga el pedido por defecto y lo muestra
	@Override
	public void setVisible(boolean b) {
		if (b) modeloComboPedidos.setSelectedIndex(0);
		super.setVisible(b);
	}
	
	private void updateTablaLineasPedido(int num) {
		((ModeloTablaLineasPedido)table.getModel()).cargarPedidos(num);
		((ModeloTablaLineasPedido)table.getModel()).fireTableDataChanged();
		}
	
	
	// MANEJADOR DEL COMBO DE PEDIDOS
	class ActionComboPedidos implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Pedido ped= (Pedido) modeloComboPedidos.getSelectedItem();
			if( ped == null) {
				txtFieldFecha.setEnabled( false );
				txtFieldDescuento.setEditable( false );
				// ...
			}
			// si nulo nothing [Deshabilitar botones]
			modo = M.MODO_VISTA;
			txtFieldFecha.setText( ped.getFecha());
			txtFieldDescuento.setText( String.valueOf( ped.getDescuento()));
			if (modeloComboClientes.selectCliente( ped.getNifCliente() ) == false )
				System.out.println( "No se encuentra el Cliente" );
			btnEliminar.setEnabled( true );
			btnEditar.setEnabled( true );
			//System.out.println( "CARGAR");
			updateTablaLineasPedido( ped.getNumPedido());
		}
	}
	
	class ActionTableLineasPedido implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			System.out.println( "Elemento seleccionado "+e.getFirstIndex() ); 
			modo = M.MODO_SELECTED;
			bntCancel.setText( "CANCELAR" );
			btnEditar.setText( "EDITAR SEL." );
			btnEliminar.setText( "ELIMINAR SEL." ); 
		}
		
	}
	
	class ActionBotonEditar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(modo == M.MODO_ADD) return;
			else if(modo == M.MODO_EDICION) {
				
			}
			modo = M.MODO_VISTA;
			// Si est� en modo edici�n se guardan los datos (comprobar valores). Se deshabilitan botones
			// Si No modo edicion se cambia boton a GUARDAR, se habilitan campos/botones
		}
	}
	
	class ActionBotonNuevo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = M.MODO_ADD;
			// Añadir Nº pedido con ***
			modeloComboPedidos.addEmptyElm();
			modeloComboPedidos.setEnabled( false );
			// Fecha actual por defecto
			txtFieldFecha.setText( "DEFAULT" );
			txtFieldFecha.setEnabled( true );
			// Habilitar seleccion de cliente
			modeloComboClientes.setEnabled( true );
			// Habilitar txt descuento
			txtFieldDescuento.setEnabled( true );
			// Tabla vacía
			((ModeloTablaLineasPedido)table.getModel()).clear();
			// Habilitar cuadro de venta 
			comboBoxProductos.setEnabled( true );
			txtFieldCantidad.setEnabled(true);
			btnNewButton.setEnabled( true );
		}
	}
}
