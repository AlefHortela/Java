/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.aula.teste;

import br.aula.db.HibernateFactory;
import br.aula.model.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LABA18-12
 */
public class IncluindoUsuario
{

    public static void main(String[] args)
    {
        Session s = HibernateFactory
                .configureSessionFactory()
                .openSession();

        Usuario usuario = new Usuario();
        usuario.setUsuario("A Grande Familia");
        usuario.setSenha("Essa Familia é muito unida");
        usuario.setEmail("E tambem muito ouriçada");
        Transaction t = s.beginTransaction();
        s.save(usuario);
        t.commit();
    }
}
