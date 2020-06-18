package br.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoBanco {
	public static Connection getConexao() {

		try {
			Properties prop = getProperties();
			final String url = prop.getProperty("dbConnStr");
			final String usuario = prop.getProperty("dbUser");
			final String senha = prop.getProperty("dbPass");

			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static Properties getProperties() {
		Properties prop = new Properties();

		prop.setProperty("dbConnStr", "jdbc:mysql://localhost:3306/poo2final");
        prop.setProperty("dbUser", "root");
        prop.setProperty("dbPass", "");

		return prop;
	}
}
