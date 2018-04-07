package br.aula.teste;

import br.aula.db.HibernateFactory;
import br.aula.model.Autor;
import br.aula.model.Livro;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IncluindoLivro
{
    public static void main(String[] args)
    {
        Session s = HibernateFactory
                .configureSessionFactory()
                .openSession();

        Livro livro = new Livro();
        livro.setTitulo("O livro 2");
        Autor autor = (Autor) s.get(Autor.class, 2l);
        livro.setAutor(autor);
        Transaction t = s.beginTransaction();
        s.save(livro);
        t.commit();
    }
}
