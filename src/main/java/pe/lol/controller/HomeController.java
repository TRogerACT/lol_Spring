package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.lol.service.ImagenCampeonesService;
import pe.lol.service.RoladcService;
import pe.lol.service.RoljgService;
import pe.lol.service.RolmidService;
import pe.lol.service.RolsupService;
import pe.lol.service.RoltopService;

@Controller
public class HomeController {
	
	@Autowired
	private RolsupService rolsupService;	
	@Autowired
	private RoladcService roladcService;	
	@Autowired
	private RolmidService rolmidService;
	@Autowired
	private RoljgService roljgService;
		
	@Autowired
	private RoltopService roltopService;
	
	@Autowired
	private ImagenCampeonesService imagenCampeonesService;
	
	@RequestMapping(value="/welcome",method= RequestMethod.GET)
	public String welcome_Get() {
		return "welcome";
	}
	
	@RequestMapping(value="/Inicio",method= RequestMethod.GET)
	public String Inicio_Get() {	
		return "Inicio";
	}	
	
	@RequestMapping(value="/index",method= RequestMethod.GET)
	public String index_Get() {	
		return "index";
	}	


	@RequestMapping(value="/index2",method= RequestMethod.GET)
	public String index2_Get() {	
		return "index2";
		
	}
	
	@RequestMapping(value="/campeones",method= RequestMethod.GET)
	public String campeones_Get(Map map) {	
		
		map.put("bRoltop",roltopService.findAll());
		map.put("bRoljg",roljgService.findAll());	
		map.put("bRolmid",rolmidService.findAll());
		map.put("bRoladc",roladcService.findAll());
		map.put("bRolsup",rolsupService.findAll());
		
		return "campeones";
		
	}	
}
