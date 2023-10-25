package br.com.fiap.bean;
import java.util.Calendar;

public class Investimento {
	
	private int id;
	private int usuario_id;
	private String tipo;
	private double valor;
	private Calendar dataCriacao;
	private Calendar dataVencimento;
	
	public Investimento(int id, int usuario_id, String tipo, double valor, Calendar dataCriacao, 
			Calendar dataVencimento) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
		this.dataVencimento = dataVencimento;
	}
	
	public Investimento() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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
}
