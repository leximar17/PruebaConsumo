package com.leximar.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.leximar.app.model.Cliente;
import com.leximar.app.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	ClienteService clienteServicio;

	@GetMapping("/")
	public ModelAndView listar(Model modelo) {
		ModelAndView mav = new ModelAndView("clientes");
		List<Cliente> clientes = clienteServicio.findAll();
		modelo.addAttribute("clientes", clientes);
		return mav;

	}
	
	
	@PostMapping ("/agregar")
	public RedirectView crear (@ModelAttribute Cliente cliente) {
		clienteServicio.create(cliente);
		return new RedirectView("/");
	}
	
	@RequestMapping( value = "/eliminar/{id}", method = RequestMethod.DELETE )	
	public RedirectView eliminar (@PathVariable(value ="id") String id) {
		clienteServicio.delete(id);
		return new RedirectView("/");
	}
	
	
	
	//@DeleteMapping("/eliminar/{id}")
//	@PostMapping("/save")
//	public ModelAndView crear (Model modelo) {
//		ModelAndView mav = new ModelAndView("save");
//		Cliente cliente = new Cliente();
//		modelo.addAttribute("cliente", cliente);
//		return mav;
//			
//	}

	
	
}
