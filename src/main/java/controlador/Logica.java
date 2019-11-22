package controlador;

import javax.swing.JTextField;

public class Logica {
	public static boolean getDouble( String s) {
		try {
			double out = Double.parseDouble( s );
		}
		catch(Exception ex) {}
		return false;
	}

	public static boolean txtFechaOK(JTextField input) {
		if(input.getText().isEmpty()) return false;
		return true;
	}

	public static boolean txtDecimalOK(JTextField input) {
		try {
			Double.parseDouble( input.getText() );
		}
		catch(Exception e){ return false;}
		return true;
	}

}
