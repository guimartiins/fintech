package br.com.fiap.bean;

import java.util.Calendar;

public class Despesa {
	
	private int id_despesa;
	private int usuario_id;
	private String tipo;
	private double valor;
	private Calendar dataCriacao;
	
	
	public Despesa(int id_despesa, int usuario_id, String tipo, double valor, Calendar dataCriacao) {
		super();
		this.id_despesa = id_despesa;
		this.usuario_id = usuario_id;
		this.tipo = tipo;
		this.valor = valor;
		this.dataCriacao = dataCriacao;
	}
	
	public Despesa() {
		super();
	}

	public int getId_despesa() {
		return id_despesa;
	}

	public void setId_despesa(int id_despesa) {
		this.id_despesa = id_despesa;
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
	
	
	
}
