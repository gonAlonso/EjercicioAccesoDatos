package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import conexion.Conexion;
import controlador.Controlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Formulario01Principal extends JFrame {

	private JPanel contentPane;
	private Conexion conexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario01Principal frame = new Formulario01Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param cx 
	 */
	public Formulario01Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnClientes = new JButton("Clientes");
		GridBagConstraints gbc_btnClientes = new GridBagConstraints();
		gbc_btnClientes.insets = new Insets(0, 0, 5, 5);
		gbc_btnClientes.gridx = 0;
		gbc_btnClientes.gridy = 0;
		contentPane.add(btnClientes, gbc_btnClientes);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Funcion no implementada");
			}
		});
		
		
		JButton btnProveedores = new JButton("Proveedores");
		GridBagConstraints gbc_btnProveedores = new GridBagConstraints();
		gbc_btnProveedores.insets = new Insets(0, 0, 5, 0);
		gbc_btnProveedores.gridx = 1;
		gbc_btnProveedores.gridy = 0;
		contentPane.add(btnProveedores, gbc_btnProveedores);
		btnProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Funcion no implementada");
			}
		});
		
		JButton btnProductos = new JButton("Productos");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 1;
		contentPane.add(btnProductos, gbc_button_1);
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarProductos();
			}
		});
		
		JButton btnFacturacion = new JButton("Facturacion");
		GridBagConstraints gbc_btnFacturacion = new GridBagConstraints();
		gbc_btnFacturacion.insets = new Insets(0, 0, 5, 5);
		gbc_btnFacturacion.gridx = 0;
		gbc_btnFacturacion.gridy = 2;
		contentPane.add(btnFacturacion, gbc_btnFacturacion);
		btnFacturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarFacturas();
			}
		});
		
		JButton btnPedidos = new JButton("Pedidos");
		GridBagConstraints gbc_btnPedidos = new GridBagConstraints();
		gbc_btnPedidos.insets = new Insets(0, 0, 5, 0);
		gbc_btnPedidos.gridx = 1;
		gbc_btnPedidos.gridy = 2;
		contentPane.add(btnPedidos, gbc_btnPedidos);
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarPedidos();
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 0;
		gbc_btnSalir.gridy = 3;
		contentPane.add(btnSalir, gbc_btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
