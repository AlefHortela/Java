package br.aula.teste;

import br.aula.db.HibernateFactory;
import br.aula.model.Livro;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ListandoOsLivros
{
    public static void main(String[] args)
    {
        
        Session s = HibernateFactory
                        .configureSessionFactory()
                        .openSession();
        
        //Todos os livros
        Query query = s.createQuery("from Livro");
        //Livros com where;
        //Query query = s.createQuery("from Livro l where l.autor.id = :id ");
        //query.setLong("id", 1);
        
        
        List<Livro> livros = query.list();
        for(Livro livro : livros)
        {
            System.out.println(livro.getTitulo());
        }
    }
}
