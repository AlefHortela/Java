package br.biblioteca.livros.controladores;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AutorController
{
    @Autowired
    AutorService autorService;

    @RequestMapping("/autor")
    public ModelAndView home()
    {
        return new ModelAndView("autor/autor");
    }

    @RequestMapping("/autor/lista")
    public ModelAndView autor()
    {
        Iterable<Autor> autores = autorService.listaAutores();
        return new ModelAndView("autor/autor", "autores", autores);
    }
}
