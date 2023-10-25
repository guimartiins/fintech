package br.com.fiap.bean;

import java.util.Calendar;

public class Usuario {
	
	private int id_usuario;
	private String nome;
	private String email;
	private String telefone;
	private String cargo;
	private String funcao;
	private Calendar dataNascimento;
	private double salario;
	private int administrador;
	private String senha;
	
	
	public Usuario(int id_usuario, String nome, String email, String telefone, String cargo, String funcao,
			Calendar dataNascimento, double salario, int administrador, String senha) {
		super();
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.cargo = cargo;
		this.funcao = funcao;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.administrador = administrador;
		this.senha = senha;
	}

	public Usuario() {
		super();
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getAdministrador() {
		return administrador;
	}

	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
