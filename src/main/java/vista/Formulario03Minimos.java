package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import conexion.Conexion;
import controlador.Controlador;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Formulario03Minimos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JScrollPane scrollPane;
	private JTable table;
	private Conexion conexion;
	private ModeloTablaProductosMinimos miModelo;
	private DefaultTableCellRenderer aCentro, aDerecha,aIzquierda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Formulario03Minimos dialog = new Formulario03Minimos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param cx 
	 */
	public Formulario03Minimos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		contentPanel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Productos Stock bajo Minimos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		crearTabla();
	}
	
	private void crearTabla() {
		miModelo = new ModeloTablaProductosMinimos();
		table = new JTable( miModelo );
		scrollPane.setViewportView( table );

		iniciarRenderers();

		table.getColumnModel().getColumn(0).setCellRenderer( aDerecha );
		for(int i=1; i<miModelo.getColumnCount(); i++)
			table.getColumnModel().getColumn(i).setCellRenderer( aDerecha );
		table.getColumnModel().getColumn(1).setCellRenderer( aIzquierda );
		
		updateTable();
	}
	
	private void iniciarRenderers() {
		aCentro = new DefaultTableCellRenderer();
		aDerecha = new DefaultTableCellRenderer();
		aIzquierda = new DefaultTableCellRenderer();
		aIzquierda.setHorizontalAlignment(SwingConstants.LEFT);
		aCentro.setHorizontalAlignment(SwingConstants.CENTER);
		aDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	
	private void updateTable() {
		miModelo.cargarProductos();
		//miModelo.cargarEmpleadosSalario( ((Departamento)comboBox.getSelectedItem()).getCodDep() );
		miModelo.fireTableDataChanged();
/*
		SumasDepartamento resultados = Controlador.cargarSumasDepartamento( ((Departamento)comboBox.getSelectedItem()).getCodDep() );
		if( resultados == null) {
			textFieldSalario.setText( "0");
			textFieldComision.setText( "0");
			textFieldIRPF.setText( "0");
			textFieldSS.setText( "0");
			textFieldSNeto.setText( "0" );
			textFieldSBruto.setText( "0" );
			return;
		}

		textFieldSalario.setText( String.valueOf( resultados.salarioBase ));
		textFieldComision.setText( String.valueOf( resultados.comisiones ));
		textFieldIRPF.setText( String.valueOf( resultados.irpf ));
		textFieldSS.setText( String.valueOf( resultados.ss ));
		textFieldSNeto.setText( String.valueOf( resultados.SalarioNeto ));
		textFieldSBruto.setText( String.valueOf( resultados.salariosBrutos));
		*/
	}
}
