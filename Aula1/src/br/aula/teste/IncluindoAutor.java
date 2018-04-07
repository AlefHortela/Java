package br.aula.teste;

import br.aula.db.HibernateFactory;
import br.aula.model.Autor;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IncluindoAutor
{

    public static void main(String[] args)
    {
        Session s = HibernateFactory
                .configureSessionFactory()
                .openSession();

        Autor autor = new Autor();
        autor.setNome("Mongol");
        Transaction t = s.beginTransaction();
        s.save(autor);
        t.commit();
    }
}
