package br.aula.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Livro")
public class Livro
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long idLivro;
    
    @Column(name = "titulo", nullable = true, length = 45)
    private String titulo;
    
    @Column(name = "foto", nullable = true, length = 200)
    private String foto;
    
    @Column(name = "quantidade")
    private int quantidade;

    @ManyToOne
    private Autor autor;
    
    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    @OneToMany(mappedBy = "livro")
    private List<Review> reviews = new ArrayList<>();
    
    public Long getIdLivro()
    {
        return idLivro;
    }

    public void setIdLivro(Long idLivro)
    {
        this.idLivro = idLivro;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getFoto()
    {
        return foto;
    }

    public void setFoto(String foto)
    {
        this.foto = foto;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }

    public Autor getAutor()
    {
        return autor;
    }

    public void setAutor(Autor autor)
    {
        this.autor = autor;
    }
}
