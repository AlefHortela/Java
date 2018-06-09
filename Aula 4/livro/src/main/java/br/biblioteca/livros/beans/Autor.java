package br.biblioteca.livros.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Autor")
public class Autor
{
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long idAutor;
    
    @Column(name = "nome", nullable = true, length = 45)
    private String nome;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();
    
    public Long getIdAutor()
    {
        return idAutor;
    }

    public void setIdAutor(Long idAutor)
    {
        this.idAutor = idAutor;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public List<Livro> getLivros()
    {
        return livros;
    }

    public void setLivros(List<Livro> livros)
    {
        this.livros = livros;
    }
    
}
