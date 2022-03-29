package control;

import java.io.IOException;

import dao.PessoaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Endereco;
import model.Pessoa;

public class ServCadPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PessoaDao dao;
       
    public ServCadPessoa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		recebeDados(request, response);
	}
	
	private void recebeDados(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("txtNome");
		String email = request.getParameter("txtEmail");
		String cpf = request.getParameter("txtCpf");
		String telefone = request.getParameter("txtTelefone");
		
		String rua = request.getParameter("txtRua");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		Integer cep = Integer.parseInt(request.getParameter("txtCep"));
		String pais = request.getParameter("txtPais");
		
		Endereco end = new Endereco(rua, bairro, cidade, estado, cep, pais);
		
		Pessoa p = new Pessoa(nome, email, cpf, telefone, end);
		
		dao = new PessoaDao();
		
		dao.inserirBd(p);
	}

}
