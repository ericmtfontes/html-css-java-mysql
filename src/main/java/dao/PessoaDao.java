package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDao {
	
	Connection con;
	PreparedStatement pstm;
	
	public void inserirBd(Pessoa p) {
		String sql = "insert into pessoa(nome,email,cpf,telefone,rua,bairro,cidade,estado,cep,pais) values (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			this.con = new ConexaoDao().getConexao();
			pstm = con.prepareStatement(sql);
			pstm.setString(1, p.getNome());
			pstm.setString(2, p.getEmail());
			pstm.setString(3, p.getCpf());
			pstm.setString(4, p.getTelefone());
			pstm.setString(5, p.getEndereco().getRua());
			pstm.setString(6, p.getEndereco().getBairro());
			pstm.setString(7, p.getEndereco().getCidade());
			pstm.setString(8, p.getEndereco().getEstado());
			pstm.setInt(9, p.getEndereco().getCep());
			pstm.setString(10, p.getEndereco().getPais());
			
			pstm.execute();
			pstm.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir: " + e.getMessage());
		}
	}

}
