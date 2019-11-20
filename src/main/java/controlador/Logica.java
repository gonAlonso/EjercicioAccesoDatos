package controlador;

public class Logica {
	public static boolean getDouble( String s) {
		try {
			double out = Double.parseDouble( s );
		}
		catch(Exception ex) {}
		return false;
	}

}
