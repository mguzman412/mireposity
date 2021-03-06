package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;



@Controller
@RequestMapping("/app")
public class IndexController {
	
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)  //por defecto va get. en ligar de requestmapping se odria ocupar @getmapping
//	public String index() {
//		return "index";
//	}
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		//mv.setViewName("index");
		return "index";
	}
	
	
	@RequestMapping("/perfil")
	public String perfil(Model model){
		Usuario usuario = new Usuario();
		usuario.setNombre("Anadir");
		usuario.setApellido("De sousa");
		usuario.setEmail("anadirdesousa@revistapronombre.com");
		
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Model model){
		
		model.addAttribute("titulo", textoListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Anadir","De sousa","anadirdesousa@revistapronombre.com"));
		usuarios.add(new Usuario("Marcelo","Guzmán","marceloguzman@mguzmansegovia.com"));
		usuarios.add(new Usuario("Mauricio","Guzmàn","mauricio@mguzmansegovia.com"));
		usuarios.add(new Usuario("blabla","Guzmàn","mauricio@mguzmansegovia.com"));
		
	
		return usuarios;
		
	}
}
