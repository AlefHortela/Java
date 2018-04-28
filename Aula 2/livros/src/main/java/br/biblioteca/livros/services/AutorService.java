package br.biblioteca.livros.services;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService
{
    @Autowired
    private AutorRepository autorRepository;

    public Iterable<Autor> listaAutores()
    {
        return autorRepository.findAll();
    }
}
