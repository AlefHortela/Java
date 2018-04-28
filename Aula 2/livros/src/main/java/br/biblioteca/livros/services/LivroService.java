package br.biblioteca.livros.services;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService
{

    @Autowired
    private LivroRepository livroRepository;

    public Iterable<Livro> listaLivros()
    {
        return livroRepository.findAll();
    }
    
    public Livro save(Livro livro)
    {
        return livroRepository.save(livro);
    }
    
    public void delete(Livro livro)
    {
        livroRepository.delete(livro);
    }
    
    public Livro findOne(long id)
    {
        return livroRepository.findOne(id);
    }
    
    
}
