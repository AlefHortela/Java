package br.biblioteca.livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> listaLivros(){
            return livroRepository.findAll();
	}

	public Livro salvaLivro(Livro livro) {
            return livroRepository.save(livro);
	}

    public Livro buscaLivro(long id){
    	return livroRepository.findOne(id);
    }
    
    public void excluir(Livro livro){
    	livroRepository.delete(livro);    	
    }
}
