package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {

	public Connection getConexao() {
		Connection con = null;
		
		String url = "jdbc:mysql://localhost:3306/meubanco?user=root&password=";
		
		try {
			con = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			System.out.println("Erro ao pegar conexão:" + e.getMessage());
		}
		
		
		return con;
	}
}
