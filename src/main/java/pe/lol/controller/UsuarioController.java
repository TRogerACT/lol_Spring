package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.lol.service.RoladcService;
import pe.lol.service.RoljgService;
import pe.lol.service.RolmidService;
import pe.lol.service.RolsupService;
import pe.lol.service.RoltopService;

@Controller
public class UsuarioController {
	
	@Autowired
	private RoltopService roltopService;
	
	@Autowired
	private RoljgService roljgService;
	
	@Autowired
	private RolmidService rolmidService;
	
	@Autowired
	private RoladcService roladcService;
	
	@Autowired
	private RolsupService rolsupService;
	
	@RequestMapping(value="/Topusuario",method= RequestMethod.GET)
	public String Top_Get(Map map) {	
		
		
		map.put("bRoltop",roltopService.findAll());
		
		return "/usuario/topusuario";
	}	
	
	@RequestMapping(value="/Jgusuario",method= RequestMethod.GET)
	public String Jg_GET(Map map)
	{

		map.put("bRoljg",roljgService.findAll());
		
		return "/usuario/jgusuario";
	}
	
	@RequestMapping(value="/Midusuario",method= RequestMethod.GET)
	public String Mid_GET(Map map)
	{

		map.put("bRolmid",rolmidService.findAll());
		
		return "/usuario/midusuario";
	}
	
	@RequestMapping(value="/Adcusuario",method= RequestMethod.GET)
	public String Adc_GET(Map map)
	{

		map.put("bRoladc",roladcService.findAll());
		
		return "/usuario/adcusuario";
	}
	
	@RequestMapping(value="/Supusuario",method= RequestMethod.GET)
	public String Sup_GET(Map map)
	{

		map.put("bRolsup",rolsupService.findAll());
		
		return "/usuario/supusuario";
	}
	
	@RequestMapping(value="/usuario",method= RequestMethod.GET)
	public String usuario_Get() {
		return "/usuario/usuario";
	}
}
