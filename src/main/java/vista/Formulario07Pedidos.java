package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;

import conexion.Conexion;
import modeloVo.Proveedor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.JSeparator;

public class Formulario07Pedidos extends JFrame {

	//private JFrame frame;
	//private JTabbedPane tabbedPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private Conexion conexion;
	private ModeloComboPedidos modeloCombo;
	private JPanel panel_add_producto;
	private JLabel lblNewLabel_2;
	private JButton btnNuevo;
	private JSeparator separator;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_2;
	private JButton btnNewButton;

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
		try { UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName());}  catch (Exception e) {}
		setBounds(100, 100, 615, 373);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		new JTabbedPane(JTabbedPane.TOP);
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);

		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 97, 67, 87, 63, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 37, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("N\u00BA Pedido");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		modeloCombo = new ModeloComboPedidos();
		GridBagConstraints gbc_comboBox_1_1_1_1 = new GridBagConstraints();
		gbc_comboBox_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1_1_1_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1_1_1_1.gridx = 1;
		gbc_comboBox_1_1_1_1.gridy = 0;
		panel.add(modeloCombo, gbc_comboBox_1_1_1_1);
		modeloCombo.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Proveedor pr = (Proveedor) modeloCombo.getSelectedItem();
				System.out.println( "CARGAR");
				//cargarTabla( dep.getCodDep() );
			}
		});
		
		lblNewLabel_2 = new JLabel("Fecha");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("% Descuento");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 0;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 5;
		gbc_textField_1.gridy = 0;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel_add_producto = new JPanel();
		panel_add_producto.setBorder(new TitledBorder(null, "Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_add_producto = new GridBagConstraints();
		gbc_panel_add_producto.gridwidth = 6;
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
		
		JComboBox comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox_12 = new GridBagConstraints();
		gbc_comboBox_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_12.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_12.anchor = GridBagConstraints.NORTH;
		gbc_comboBox_12.gridx = 1;
		gbc_comboBox_12.gridy = 0;
		panel_add_producto.add(comboBox, gbc_comboBox_12);
		
		lblNewLabel_4 = new JLabel("Cantidad");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_add_producto.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 0, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 0;
		panel_add_producto.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
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
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setEnabled(false);
		btnEliminar.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(btnEliminar);
		
		JButton btnOK = new JButton("GUARDAR");
		btnOK.setEnabled(false);
		panel_1.add(btnOK);
		
		separator = new JSeparator();
		panel_1.add(separator);
		
		JButton bntCancel = new JButton("CANCEL");
		bntCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(bntCancel);
		bntCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
