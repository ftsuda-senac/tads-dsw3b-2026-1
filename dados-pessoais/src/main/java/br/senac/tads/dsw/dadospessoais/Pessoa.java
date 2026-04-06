package br.senac.tads.dsw.dadospessoais;


import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class Pessoa {

    private Integer id;

	@NotBlank(message = "Preencha o username seu animal") // @NotEmpty + @NotNull
	@Size(max = 64)
    private String username;

	@NotBlank(message = "Preencha o nome completo seu ignorante")
	@Size(max = 100)
    private String nome;

	@NotBlank
	@Size(max = 100)
	@Email
    private String email;

	@NotNull
	@PastOrPresent
    private LocalDate dataNascimento;

	private String senha;

	private String senhaRepetida;


    public Pessoa() {
    }

    public Pessoa(Integer id, String username, String nome, String email, LocalDate dataNascimento) {
        this.id = id;
        this.username = username;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}
}
