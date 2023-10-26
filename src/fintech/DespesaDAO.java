package fintech;

import java.util.Calendar;

public class DespesaDAO {
	private int id;
	private String tipo;
	private double valor;
	private Calendar data_criacao;
	private int usuario;
	
	public DespesaDAO() {
		super();
	}

	public DespesaDAO(int id, String tipo, double valor, Calendar data_criacao, int usuario) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.data_criacao = data_criacao;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Calendar getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Calendar data_criacao) {
		this.data_criacao = data_criacao;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	
}
