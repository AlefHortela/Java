package br.aula.model;

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
}
