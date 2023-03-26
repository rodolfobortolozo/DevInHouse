package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Pessoa;
import repository.PessoaRepository;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Pessoa> pessoas = PessoaRepository.getPessoas();
		
		PessoaRepository.addPessoa(new Pessoa(1L,"Andre"));
		PessoaRepository.addPessoa(new Pessoa(2L,"Anderson"));
		PessoaRepository.addPessoa(new Pessoa(3L,"Andrei"));

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<ul>");
		for(Pessoa pessoa: pessoas) {
			out.println("<li>"+pessoa.getNome()+"</li>");
		}
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");

		Pessoa pessoa = new Pessoa(Long.valueOf(id), nome);
		PessoaRepository.addPessoa(pessoa);
		
		PessoaRepository.getPessoas().forEach(e -> System.out.println(e.getNome()));
		
		doGet(request, response);
	}

}
