package br.aula.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Usuario
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "username", nullable = true, length = 45)
    private String usuario;
    
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    
    @Column(name = "password", nullable = true, length = 45)
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos = new ArrayList<>();
    
    @OneToMany(mappedBy = "usuario")
    private List<Review> reviews = new ArrayList<>();
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public List<Emprestimo> getEmprestimos()
    {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos)
    {
        this.emprestimos = emprestimos;
    }
}
