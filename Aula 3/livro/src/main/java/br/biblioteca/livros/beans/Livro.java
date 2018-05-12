package br.biblioteca.livros.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message = "Nome não pode ser vazio")
	@Size(min = 2, max = 100, message= "Tamanho tem que estar entre 2 e 100 caracteres")
	private String nome;
	
	@NotNull(message = "Quantidade não pode ser vazio")
	@Min(value = 10, message = "Quantidade mínima de paginas é 10")
	private int quantidadePaginas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidadePaginas() {
		return quantidadePaginas;
	}

	public void setQuantidadePaginas(int quantidadePaginas) {
		this.quantidadePaginas = quantidadePaginas;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", nome=" + nome + ", quantidadePaginas=" + quantidadePaginas + "]";
	}
	
	

}
