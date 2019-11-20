package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import conexion.Conexion;
import controlador.Controlador;

public class Formulario02Productos extends JFrame {

	private JPanel contentPane;
	private Conexion conexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario02Productos frame = new Formulario02Productos( );
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
	public Formulario02Productos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		ActionSalir objActionSalir = new ActionSalir();
		JButton btnSalir = new JButton("SALIR");
		panel.add(btnSalir);
		btnSalir.addActionListener( objActionSalir );
		
		JButton btnOk = new JButton("OK");
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnCancel);
		btnCancel.addActionListener( objActionSalir );
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		panel_2.setBorder(new TitledBorder(null, "Mantenimiento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		
		JButton btnNewButton_3 = new JButton("NUEVO");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton("MODIFICAR");
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("ELIMINAR");
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("CONSULTAR");
		panel_2.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Listados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 4);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 1;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {30, 30, 30};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnListado = new JButton("Listado");
		GridBagConstraints gbc_btnListado = new GridBagConstraints();
		gbc_btnListado.insets = new Insets(0, 0, 5, 4);
		gbc_btnListado.gridx = 0;
		gbc_btnListado.gridy = 0;
		panel_3.add(btnListado, gbc_btnListado);
		
		JButton btnMinimos = new JButton("Minimos");
		GridBagConstraints gbc_btnMinimos = new GridBagConstraints();
		gbc_btnMinimos.insets = new Insets(0, 0, 5, 5);
		gbc_btnMinimos.gridx = 1;
		gbc_btnMinimos.gridy = 0;
		panel_3.add(btnMinimos, gbc_btnMinimos);
		btnMinimos.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarMinimos();
			}
		} );
		
		JButton btnBeneficio = new JButton("Beneficio");
		GridBagConstraints gbc_btnBeneficio = new GridBagConstraints();
		gbc_btnBeneficio.insets = new Insets(0, 0, 5, 5);
		gbc_btnBeneficio.gridx = 2;
		gbc_btnBeneficio.gridy = 0;
		panel_3.add(btnBeneficio, gbc_btnBeneficio);
		btnBeneficio.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarBeneficio();
			}
		} );
		
		
		JButton btnIncrementa = new JButton("Incrementar Precio");
		GridBagConstraints gbc_btnIncrementa = new GridBagConstraints();
		gbc_btnIncrementa.insets = new Insets(0, 0, 0, 5);
		gbc_btnIncrementa.gridx = 0;
		gbc_btnIncrementa.gridy = 1;
		panel_3.add(btnIncrementa, gbc_btnIncrementa);
		btnIncrementa.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarIncrPrecios();
			}
		} );
		
		JButton btnExistencias = new JButton("Valoracion Existencias");
		GridBagConstraints gbc_btnExistencias = new GridBagConstraints();
		gbc_btnExistencias.insets = new Insets(0, 0, 0, 5);
		gbc_btnExistencias.gridx = 2;
		gbc_btnExistencias.gridy = 1;
		panel_3.add(btnExistencias, gbc_btnExistencias);
		btnExistencias.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.mostrarValoracion();
			}
		} );
		
	}
	
	class ActionSalir implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}

}
