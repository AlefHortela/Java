package br.biblioteca.livros.controladores;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.LivroRepository;
import br.biblioteca.livros.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LivroController
{

    public 
    
    @Autowired
    LivroService livroService;

    @RequestMapping("/")
    public ModelAndView home()
    {
        return new ModelAndView("livros/livros");
    }

    @RequestMapping("/livros")
    public ModelAndView livros()
    {
        Iterable<Livro> livros = livroService.listaLivros();
        return new ModelAndView("livros/livros", "livros", livros);
    }

}
