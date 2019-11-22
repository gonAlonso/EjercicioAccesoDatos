package controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;


public class Logica {
	public static boolean getDouble( String s) {
		try {
			double out = Double.parseDouble( s );
		}
		catch(Exception ex) {}
		return false;
	}

	
	public static String getFechaActual() {
		LocalDate date = LocalDate.now();
		return  date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) ;	
	}
	
	public static boolean txtFechaOK(JTextField input) {
		if(input.getText().isEmpty()) return false;
		try {
			LocalDate date = LocalDate.parse( input.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			input.setText( date.toString() );
		}
		catch( Exception ex ) { return false; }

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
