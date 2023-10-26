package fintech.models;

import java.util.Calendar;


public class Despesa {
	private int id;
	private String tipo;
	private double valor;
	private Calendar dataCriacao;
	private int usuarioID;
	
	public Despesa(String tipo, double valor, Calendar dataCriacao, int usuarioID) {
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.usuarioID = usuarioID;
	}

	public Despesa( int id, String tipo, double valor, Calendar dataCriacao, int usuarioID) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.usuarioID = usuarioID;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}
	
	public int getUsuarioID() {
		return this.usuarioID;
	}
	
	@Override
	public String toString() {
		return "Despesas [id=" + id + ", tipo=" + tipo + ", valor=" + valor + ", dataCriacao=" + dataCriacao + ", usuarioID=" + usuarioID + "]";
	}
}
