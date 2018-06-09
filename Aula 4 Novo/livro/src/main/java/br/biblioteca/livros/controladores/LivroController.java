package br.biblioteca.livros.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.beans.Autor;
import br.biblioteca.livros.beans.Livro;
import br.biblioteca.livros.repository.AutorRepository;
import br.biblioteca.livros.services.LivroService;
import br.biblioteca.livros.util.FileSaver;

@Controller
@RequestMapping(LivroController.PATH_LIVRO)
public class LivroController {
	
	public static final String PATH_LIVRO = "/livros";
	public static final String PATH_LIVRO_LIST = "/list";
	public static final String PATH_LIVRO_NOVO = "/novo";
	public static final String PATH_LIVRO_GRAVAR = "/gravar";
	public static final String PATH_LIVRO_EXCLUIR = "/excluir/{id}";
	public static final String PATH_LIVRO_UPDATE = "/alterar/{id}";
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	FileSaver fileSaver;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@RequestMapping("/")
	public ModelAndView  home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(PATH_LIVRO_LIST)
	public ModelAndView livros() {
		List<Livro> livros = livroService.listaLivros();
		return new ModelAndView("livros/livros", "livros", livros);
	}
	
	@GetMapping(PATH_LIVRO_NOVO)
	public ModelAndView createForm(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livros/form");
		Iterable<Autor> autores = autorRepository.findAll();
		modelAndView.addObject("autores", autores);
		return modelAndView;
	}

	
	@PostMapping(value = PATH_LIVRO_GRAVAR)
	public ModelAndView create(@RequestParam("fotoUrl") MultipartFile fotoUrl, @ModelAttribute("livro") @Valid Livro livro, BindingResult bindingResult, Model model) {
		
		if (livro.getId() != null) {
			if (fotoUrl.getOriginalFilename().length() > 0) {
				incluiFoto(fotoUrl, livro, model);
			}
		} else {
			if (fotoUrl.getOriginalFilename().equals("")) {
				model.addAttribute("capa", "A capa não pode ser vazia");
			} else {
				incluiFoto(fotoUrl, livro, model);
			}
		}
			
		if (bindingResult.hasErrors()  || model.containsAttribute("message")) {
			Iterable<Autor> autores = autorRepository.findAll();
			return new ModelAndView("livros/form", "autores", autores);
		}
		
		livro = livroService.salvaLivro(livro);
	   	return new ModelAndView("redirect:/livros/list");
	}
	
	@GetMapping(PATH_LIVRO_UPDATE)
	public ModelAndView alterar(@PathVariable("id") Long id) {
		Livro livro = this.livroService.buscaLivro(id);
		Iterable<Autor> autores = autorRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("livros/form");
		modelAndView.addObject("autores", autores);
		modelAndView.addObject("livros", livro);
		return modelAndView;
	}
	
	@GetMapping(PATH_LIVRO_EXCLUIR)
	public ModelAndView excluir(@PathVariable("id") Long id) {
		this.livroService.apagaLivro(id);
		return new ModelAndView("redirect:/livros/list");
	}
	
	private void incluiFoto(MultipartFile fotoUrl, Livro livro, Model model) {
		if (fotoUrl.getContentType().equals("image/jpeg")) {
			String webPath = fileSaver.write("uploaded-images", fotoUrl);
			livro.setFoto(webPath);
		} else {
			model.addAttribute("foto", "Arquivo em formato errado. Permitido apenas jpg");
		}
	}

}
