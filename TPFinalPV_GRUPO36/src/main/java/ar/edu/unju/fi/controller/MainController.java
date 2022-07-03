package ar.edu.unju.fi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
		
	//@GetMapping("/")
	//public String getPageHome() {
		
	//	return "Principal";
	//}
	
	
	@GetMapping({"/","/login"})
	public String ingresar(Model model) {
		return "Principal";
	}
}
