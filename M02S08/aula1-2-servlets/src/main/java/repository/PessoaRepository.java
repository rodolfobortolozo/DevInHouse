package repository;

import java.util.ArrayList;

import Model.Pessoa;

public class PessoaRepository {
	
	private static ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public static Pessoa getPessoaById(Integer id) {
		return pessoas.get(id);
	}
	
	public static boolean addPessoa(Pessoa pessoa) {
		return pessoas.add(pessoa);
	}
	
	public static ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

}
