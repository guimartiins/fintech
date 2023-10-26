package fintech.models;

import java.util.Calendar;

public class Transacao {

	private int id;
	private String tipo;
	private double valor;
	private Calendar dataCriacao;
	private Calendar dataVencimento;
	private int usuarioID;

	public Transacao(String tipo, double valor, Calendar dataCriacao,
			Calendar dataVencimento, int usuarioID) {
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.usuarioID = usuarioID;
	}

	public Transacao(int id, String tipo, double valor, Calendar dataCriacao,
			Calendar dataVencimento, int usuarioID) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
		this.usuarioID = usuarioID;
	}

	public Transacao() {
	}

	public int getId_transacao() {
		return id;
	}

	public void setId_transacao(int id) {
		this.id = id;
	}

	public int getUsuarioID() {
		return usuarioID;
	}

	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", usuarioID=" + usuarioID + ", tipo=" + tipo + ", valor="
				+ valor + ", dataCriacao=" + dataCriacao + ", dataVencimento=" + dataVencimento + "]";
	}
}