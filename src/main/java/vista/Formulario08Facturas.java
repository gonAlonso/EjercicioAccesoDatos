package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

import conexion.Conexion;
import controlador.Controlador;
import modeloVo.Cliente;
import modeloVo.Factura;
import modeloVo.Pedido;
import vista.Formulario07Pedidos.ActionComboPedidos;
import vista.Formulario07Pedidos.M;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Formulario08Facturas extends JFrame {

	//private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextField textFieldSubtotal;
	private JTextField textFieldDescuentoFactura;
	private JTextField textFieldBaseImponible;
	private JTextField textFieldIva;
	private JTextField textFieldTotal;
	private JTable tablaCrearFacturas;
	private JTable tableFacturasMes;
	private JTable tableFacturasClientes;
	//private Conexion conexion;
	private ModeloComboPedidos modeloComboPedidos;
	private ModeloTablaLineasPedido modeloTablaLineasPedido;
	private ModeloTablaLineasFacturas modeloTablaLineasFacturasMes;
	private ModeloTablaLineasFacturas modeloTablaLineasFacturasClientes;
	private JTextField textFieldNif;
	private JTextField textFieldDescuento;
	private JTextField txtFieldName;
	private JTextField textFieldAddress;
	private JTextField textFieldCP;
	private JTextField textFieldCiudad;
	private static DecimalFormat df = new DecimalFormat("0.00");
	private JComboBox comboBoxMeses;
	private GridBagConstraints gbc_comboListaClientes;
	private JComboBox comboListaClientes;

	/**
	 * Launch the application.
	 */
/*	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario08Facturas frame = new Formulario08Facturas();
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
	public Formulario08Facturas() {
		try { UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());}  catch (Exception e) {}
		setBounds(100, 100, 450, 600);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Crear Factura", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 97, 87, 82, 75, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 37, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Pedido");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		//JComboBox comboBox = new JComboBox();
		modeloComboPedidos = new ModeloComboPedidos();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		panel.add(modeloComboPedidos, gbc_comboBox);
		modeloComboPedidos.addActionListener( new ActionComboPedidos() );
		
		textFieldNif = new JTextField();
		textFieldNif.setEditable(false);
		textFieldNif.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldNif = new GridBagConstraints();
		gbc_textFieldNif.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNif.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNif.gridx = 2;
		gbc_textFieldNif.gridy = 0;
		panel.add(textFieldNif, gbc_textFieldNif);
		textFieldNif.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("% Descuento");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setEditable(false);
		textFieldDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldDescuento = new GridBagConstraints();
		gbc_textFieldDescuento.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDescuento.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescuento.gridx = 4;
		gbc_textFieldDescuento.gridy = 0;
		panel.add(textFieldDescuento, gbc_textFieldDescuento);
		textFieldDescuento.setColumns(10);
		
		txtFieldName = new JTextField();
		txtFieldName.setEditable(false);
		GridBagConstraints gbc_txtFieldName = new GridBagConstraints();
		gbc_txtFieldName.gridwidth = 2;
		gbc_txtFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFieldName.gridx = 0;
		gbc_txtFieldName.gridy = 1;
		panel.add(txtFieldName, gbc_txtFieldName);
		txtFieldName.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setEditable(false);
		GridBagConstraints gbc_textFieldAddress = new GridBagConstraints();
		gbc_textFieldAddress.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAddress.gridx = 2;
		gbc_textFieldAddress.gridy = 1;
		panel.add(textFieldAddress, gbc_textFieldAddress);
		textFieldAddress.setColumns(10);
		
		textFieldCP = new JTextField();
		textFieldCP.setEditable(false);
		textFieldCP.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldCP = new GridBagConstraints();
		gbc_textFieldCP.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCP.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCP.gridx = 3;
		gbc_textFieldCP.gridy = 1;
		panel.add(textFieldCP, gbc_textFieldCP);
		textFieldCP.setColumns(10);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setEditable(false);
		textFieldCiudad.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_textFieldCiudad = new GridBagConstraints();
		gbc_textFieldCiudad.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldCiudad.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCiudad.gridx = 4;
		gbc_textFieldCiudad.gridy = 1;
		panel.add(textFieldCiudad, gbc_textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		modeloTablaLineasPedido = new ModeloTablaLineasPedido();
		tablaCrearFacturas = new JTable(modeloTablaLineasPedido);
		scrollPane.setViewportView(tablaCrearFacturas);
		setTable0();
		
		JLabel lblNewLabel_2 = new JLabel("Subtotal");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldSubtotal = new JTextField();
		textFieldSubtotal.setEditable(false);
		textFieldSubtotal.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldSubtotal = new GridBagConstraints();
		gbc_textFieldSubtotal.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldSubtotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSubtotal.gridx = 4;
		gbc_textFieldSubtotal.gridy = 5;
		panel.add(textFieldSubtotal, gbc_textFieldSubtotal);
		textFieldSubtotal.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Descuento");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 6;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textFieldDescuentoFactura = new JTextField();
		textFieldDescuentoFactura.setEditable(false);
		textFieldDescuentoFactura.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldDescuentoFactura = new GridBagConstraints();
		gbc_textFieldDescuentoFactura.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDescuentoFactura.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDescuentoFactura.gridx = 4;
		gbc_textFieldDescuentoFactura.gridy = 6;
		panel.add(textFieldDescuentoFactura, gbc_textFieldDescuentoFactura);
		textFieldDescuentoFactura.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Base Imponible");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 3;
		gbc_lblNewLabel_4.gridy = 7;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textFieldBaseImponible = new JTextField();
		textFieldBaseImponible.setEditable(false);
		textFieldBaseImponible.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldBaseImponible = new GridBagConstraints();
		gbc_textFieldBaseImponible.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBaseImponible.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBaseImponible.gridx = 4;
		gbc_textFieldBaseImponible.gridy = 7;
		panel.add(textFieldBaseImponible, gbc_textFieldBaseImponible);
		textFieldBaseImponible.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("IVA");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 8;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textFieldIva = new JTextField();
		textFieldIva.setEditable(false);
		textFieldIva.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldIva = new GridBagConstraints();
		gbc_textFieldIva.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIva.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIva.gridx = 4;
		gbc_textFieldIva.gridy = 8;
		panel.add(textFieldIva, gbc_textFieldIva);
		textFieldIva.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Total");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 9;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_textFieldTotal = new GridBagConstraints();
		gbc_textFieldTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTotal.gridx = 4;
		gbc_textFieldTotal.gridy = 9;
		panel.add(textFieldTotal, gbc_textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Facturas Mes", null, panel_2, null);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{192, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_7 = new JLabel("Mes");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel_2.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		comboBoxMeses = new ModeloComboMeses();
		comboBoxMeses.addActionListener(new ActionComboMeses());
		
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 0;
		panel_2.add(comboBoxMeses, gbc_comboBox_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);
		
		modeloTablaLineasFacturasMes = new ModeloTablaLineasFacturas();
		tableFacturasMes = new JTable(modeloTablaLineasFacturasMes);
		scrollPane_1.setViewportView(tableFacturasMes);
		setTable1();
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Facturas Cliente", null, panel_3, null);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{113, 188, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_8 = new JLabel("Cliente");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_3.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		comboListaClientes = new ModeloComboClientes();
		gbc_comboListaClientes = new GridBagConstraints();
		gbc_comboListaClientes.insets = new Insets(0, 0, 5, 0);
		gbc_comboListaClientes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboListaClientes.gridx = 1;
		gbc_comboListaClientes.gridy = 0;
		panel_3.add(comboListaClientes, gbc_comboListaClientes);
		comboListaClientes.addActionListener(new ActionComboClientes());
		
		JScrollPane scrollListaClientes = new JScrollPane();
		GridBagConstraints gbc_scrollPane_2 = new GridBagConstraints();
		gbc_scrollPane_2.gridwidth = 2;
		gbc_scrollPane_2.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_2.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_2.gridx = 0;
		gbc_scrollPane_2.gridy = 1;
		panel_3.add(scrollListaClientes, gbc_scrollPane_2);
		
		modeloTablaLineasFacturasClientes = new ModeloTablaLineasFacturas();
		tableFacturasClientes = new JTable(modeloTablaLineasFacturasClientes);
		scrollListaClientes.setViewportView(tableFacturasClientes);
		setTable2();
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		/*
		JButton btnOK = new JButton("OK");
		panel_1.add(btnOK);
		*/
		JButton bntCancel = new JButton("SALIR");
		bntCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(bntCancel);
		bntCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	private void setTable0() {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		TableColumnModel tModel = tablaCrearFacturas.getColumnModel();
		
		tModel.getColumn(2).setCellRenderer( rightRenderer );
		tModel.getColumn(3).setCellRenderer( rightRenderer );
		tModel.getColumn(4).setCellRenderer( rightRenderer );
	}
	
	private void setTable1() {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		TableColumnModel tModel = tableFacturasMes.getColumnModel();
		
		//tModel.getColumn(0).setCellRenderer( rightRenderer );
		tModel.getColumn(2).setCellRenderer( rightRenderer );
		tModel.getColumn(3).setCellRenderer( rightRenderer );
		tModel.getColumn(4).setCellRenderer( rightRenderer );
	}
	
	private void setTable2() {
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		TableColumnModel tModel = tableFacturasClientes.getColumnModel();
		
		//tModel.getColumn(0).setCellRenderer( rightRenderer );
		tModel.getColumn(2).setCellRenderer( rightRenderer );
		tModel.getColumn(3).setCellRenderer( rightRenderer );
		tModel.getColumn(4).setCellRenderer( rightRenderer );
	}
	
	
	// MANEJADOR DEL COMBO DE PEDIDOS
		class ActionComboPedidos implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pedido ped= (Pedido) modeloComboPedidos.getSelectedItem();
				Cliente cli = Controlador.getCliente(ped.getNifCliente() );
				// TODO: Should show a user alert on error ??
				if(ped == null) return;
				if(cli == null) return;
				// Fill txtFields data
				txtFieldName.setText( cli.getNombre());
				textFieldNif.setText( cli.getNif() );
				textFieldAddress.setText( cli.getCalle());
				textFieldDescuento.setText( String.valueOf( cli.getClDescuento()));
				textFieldCP.setText( cli.getCodPostal());
				textFieldCiudad.setText( cli.getCiudad());
				// Calcula datos de factura
				Factura fact = Controlador.getDatosFactura( ped.getNumPedido() );

				textFieldSubtotal.setText( String.valueOf( df.format( fact.getSubtotal())));
				textFieldDescuentoFactura.setText( String.valueOf( df.format( fact.getDescuento())));
				textFieldBaseImponible.setText(String.valueOf( df.format( fact.getBaseImponible())));
				textFieldIva.setText(String.valueOf( df.format( fact.getIva())));
				textFieldTotal.setText(String.valueOf( df.format( fact.getTotal())));
				// Cargar tabla
				modeloTablaLineasPedido.cargarLineasPedidos( ped.getNumPedido());
			}
		}

		class ActionComboMeses implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				int mes = comboBoxMeses.getSelectedIndex() +1;
				modeloTablaLineasFacturasMes.cargarLineasMes(mes);
			}
		}
		
		class ActionComboClientes implements ActionListener {
			public void actionPerformed(ActionEvent ev) {
				System.out.println("Cambiado el cliente");
				Cliente cli = (Cliente) comboListaClientes.getSelectedItem();
				modeloTablaLineasFacturasClientes.cargarLineasCliente( cli.getNif() );
			}
		}
		
}

