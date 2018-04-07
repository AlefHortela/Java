package br.aula.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Emprestimo")
public class Emprestimo
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long idEmprestimo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_emprestimo")
    private Date dataEmprestimo;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_devolucao")
    private Date dataDevolucao;

    public Long getIdEmprestimo()
    {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo)
    {
        this.idEmprestimo = idEmprestimo;
    }

    public Date getDataEmprestimo()
    {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo)
    {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao()
    {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao)
    {
        this.dataDevolucao = dataDevolucao;
    }
}
