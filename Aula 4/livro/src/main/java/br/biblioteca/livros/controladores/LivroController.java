package br.biblioteca.livros.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.services.AutorService;
import br.biblioteca.livros.services.LivroService;
import br.biblioteca.livros.util.FileSaver;

import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(LivroController.PATH_LIVRO)
public class LivroController {
	
	public static final String PATH_LIVRO = "/livros";
	public static final String PATH_LIVRO_LIST = "/list";
	
	@Autowired
	LivroService livroService;
	@Autowired
	AutorService autorService;
	@Autowired
	FileSaver fileSaver;
	
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
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/form");
		Iterable<Autor> autores = autorService.pegarTodos();
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	
	@PostMapping(path = "/gravar" , params = "form")
	public ModelAndView create(@RequestParam("capaUrl") MultipartFile capaUrl, @ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult, Model model) {
		
		if(capaUrl.getOriginalFilename().equals("")) {
			model.addAttribute("message", "A capa não pode ser vazia");
			return new ModelAndView("livros/form");
		}else {
			if(capaUrl.getContentType().equals("image/jpeg")){
				String webPath = fileSaver.write("uploaded-images",capaUrl);
				livro.setCapa(webPath);
			}else{
				model.addAttribute("message", "Arquivo em formato errado. Permitido apenas jpg");
				return new ModelAndView("livros/form");
			}
		}
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("livros/form");
		}
		
		livro = this.livroService.salvaLivro(livro);
	    return new ModelAndView("redirect:/livros/list");
	} 



	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = this.livroService.buscaLivro(id);
		Iterable<Autor> autores = autorService.pegarTodos();
		ModelAndView modelAndView = new ModelAndView("livros/form");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livro", livro);
		return modelAndView;
	}

    
    @GetMapping("/excluir/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id) {
		Livro livro = livroService.buscaLivro(id);
		livroService.excluir(livro);
		return new ModelAndView("redirect:/livros/list");
    }


}

