package mz.co.Lunguissa.Classes;

public class Cliente {

	private String nome;
	private int numeroTelefone;

	public Cliente(String nome, int numeroTelefone) {
		super();
		this.nome = nome;
		this.numeroTelefone = numeroTelefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

}
