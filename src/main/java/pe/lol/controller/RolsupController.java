package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pe.lol.entity.Imagencampeones;
import pe.lol.entity.Rolsup;
import pe.lol.service.ImagenCampeonesService;
import pe.lol.service.RolsupService;


@Controller
public class RolsupController {

		@Autowired
		private RolsupService rolsupService;
		
		@Autowired
		private ImagenCampeonesService imagenCampeonesService;
			
		@RequestMapping(value="/rolsup_listar",method= RequestMethod.GET)
		public String lista_GET(Map map)
		{

			map.put("bRolsup",rolsupService.findAll());
			
			return "/rolsup/listar";
		}
		
		@RequestMapping(value="/rolsup_registrar",method= RequestMethod.GET)
		public String registrar_GET(Model model, Map map)
		{
			Rolsup rolsupModel=new Rolsup(); //Equipos vacion
			model.addAttribute("rolsup", rolsupModel);
			
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/rolsup/registrar";
		}
		
		@RequestMapping(value="/rolsup_registrar",method=RequestMethod.POST)
		public String registrar_POST(Rolsup rolsup)
		{
			Imagencampeones imagencampeones=new Imagencampeones();
			
			//guardar equipo

			rolsupService.insert(rolsup);
			
			return "redirect:/campeones";
		}
		
		@RequestMapping(value="/rolsup_editar/{supId}",method= RequestMethod.GET)
		public String editar_GET(Model model,@PathVariable Integer supId,Map map)
		{
			// busqueda por ID
			Rolsup rolsupModel=rolsupService.findById(supId);
			
			model.addAttribute("rolsup",rolsupModel);
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/rolsup/editar";
		}
		@RequestMapping(value="/rolsup_editar/{topId}",method=RequestMethod.POST)
		public String editar_POST(Rolsup rolsup)
		{
			//guardar equipo
			rolsupService.update(rolsup);
			
			return "redirect:/campeones";
		}		
		
		@RequestMapping(value="/rolsup_borrar/{supId}",method= RequestMethod.GET)
		public String borrar_GET(Model model,@PathVariable Integer supId)
		{
			// busqueda por ID
			Rolsup rolsupModel=rolsupService.findById(supId);
			
			model.addAttribute("rolsup", rolsupModel);
			
			return "/rolsup/borrar";
		}
		@RequestMapping(value="/rolsup_borrar/{supId}",method=RequestMethod.POST)
		public String borrar_POST(Rolsup rolsup)
		{
			//guardar equipo
			rolsupService.delete(rolsup.getSupId());
			
			return "redirect:/campeones";
		}		
	}