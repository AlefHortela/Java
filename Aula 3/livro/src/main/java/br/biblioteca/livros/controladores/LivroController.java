package br.biblioteca.livros.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.LivroService;

@Controller
@RequestMapping(LivroController.PATH_LIVRO)
public class LivroController {
	
	public static final String PATH_LIVRO = "/livros";
	public static final String PATH_LIVRO_LIST = "/list";
	
	@Autowired
	LivroService livroService;
	
	@RequestMapping("/")
	public ModelAndView  home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/list")
	public ModelAndView livros() {
		List<Livro> livros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", livros);
	}
	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute Livro livro) {
		return "livros/form";
	}
	
	@PostMapping(value = "/gravar")
	public ModelAndView create(@ModelAttribute Livro livro) {
		livro = livroService.salvaLivro(livro);
	   	return new ModelAndView("redirect:/livros/list");
	}
}
