package br.aula.model;

import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long idAvaliacao;

    @Column(name = "avaliacao")
    private int avaliacao;
    
    @Column(name = "comentario", nullable = true, length = 45) 
    private String comentario;

    @ManyToOne
    private Livro livro;
    
    @ManyToOne
    private Usuario usuario;
    
    public Long getIdAvalicao()
    {
        return idAvaliacao;
    }

    public void setIdAvalicao(Long idAvalicao)
    {
        this.idAvaliacao = idAvalicao;
    }

    public int getAvaliacao()
    {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao)
    {
        this.avaliacao = avaliacao;
    }

    public String getComentario()
    {
        return comentario;
    }

    public void setComentario(String comentario)
    {
        this.comentario = comentario;
    }

    public Livro getLivro()
    {
        return livro;
    }

    public void setLivro(Livro livro)
    {
        this.livro = livro;
    }

    public Usuario getUsuario()
    {
        return usuario;
    }

    public void setUsuario(Usuario usuario)
    {
        this.usuario = usuario;
    }
}
