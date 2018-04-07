package br.aula.model;

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
    
}
