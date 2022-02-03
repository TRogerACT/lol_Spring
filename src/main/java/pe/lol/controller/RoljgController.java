package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pe.lol.entity.Imagencampeones;
import pe.lol.entity.Roljg;
import pe.lol.service.ImagenCampeonesService;
import pe.lol.service.RoljgService;


@Controller
public class RoljgController {

		@Autowired
		private RoljgService roljgService;
		
		@Autowired
		private ImagenCampeonesService imagenCampeonesService;
			
		@RequestMapping(value="/roljg_listar",method= RequestMethod.GET)
		public String lista_GET(Map map)
		{

			map.put("bRoljg",roljgService.findAll());
			
			return "/roljg/listar";
		}
		
		@RequestMapping(value="/roljg_registrar",method= RequestMethod.GET)
		public String registrar_GET(Model model, Map map)
		{
			Roljg roljgModel=new Roljg(); //Equipos vacion
			model.addAttribute("roljg", roljgModel);
			
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/roljg/registrar";
		}
		
		@RequestMapping(value="/roljg_registrar",method=RequestMethod.POST)
		public String registrar_POST(Roljg roljg)
		{
			Imagencampeones imagencampeones=new Imagencampeones();
			
			//guardar equipo

			roljgService.insert(roljg);
			
			return "redirect:/campeones";
		}
		
		@RequestMapping(value="/roljg_editar/{jgId}",method= RequestMethod.GET)
		public String editar_GET(Model model,@PathVariable Integer jgId,Map map)
		{
			// busqueda por ID
			Roljg roljgModel=roljgService.findById(jgId);
			
			model.addAttribute("roljg",roljgModel);
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/roljg/editar";
		}
		@RequestMapping(value="/roljg_editar/{jgId}",method=RequestMethod.POST)
		public String editar_POST(Roljg roljg)
		{
			//guardar equipo
			roljgService.update(roljg);
			
			return "redirect:/campeones";
		}		
		
		@RequestMapping(value="/roljg_borrar/{jgId}",method= RequestMethod.GET)
		public String borrar_GET(Model model,@PathVariable Integer jgId)
		{
			// busqueda por ID
			Roljg roljgModel=roljgService.findById(jgId);
			
			model.addAttribute("roljg", roljgModel);
			
			return "/roljg/borrar";
		}
		@RequestMapping(value="/roljg_borrar/{topId}",method=RequestMethod.POST)
		public String borrar_POST(Roljg roljg)
		{
			//guardar equipo
			roljgService.delete(roljg.getJgId());
			
			return "redirect:/campeones";
		}		
	}