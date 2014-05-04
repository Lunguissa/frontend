package mz.co.Lunguissa.Classes;

import java.util.Date;

public class Registo {

	private Cliente cliente;
	private Date data;
	private String servico;

	public Registo(Cliente cliente, Date data, String servico) {
		super();
		this.cliente = cliente;
		this.data = data;
		this.servico = servico;
	}

	@Override
	public String toString() {
		return "Registo [cliente=" + cliente + ", data=" + data + ", servico="
				+ servico + "]";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

}
