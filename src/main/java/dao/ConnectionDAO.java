package dao;
public class ConnectionDAO {
	/**
	 * Parametres de connexion a la base de donnees
	 * URL, LOGIN et PASS sont des constantes
	 */

	final static String URL   = "jdbc:mysql://localhost:3306/irve?characterEncoding=UTF-8";
	final static String LOGIN = "root";
	final static String PASS  = "password";
	
	/**
	 * Constructor
	 * 
	 */
	public ConnectionDAO() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
	
}