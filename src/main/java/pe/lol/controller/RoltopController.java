package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.lol.entity.Equipos;
import pe.lol.entity.Imagencampeones;
import pe.lol.entity.Roltop;
import pe.lol.service.ImagenCampeonesService;
import pe.lol.service.RoltopService;

@Controller
public class RoltopController {

		@Autowired
		private RoltopService roltopService;
		
		@Autowired
		private ImagenCampeonesService imagenCampeonesService;
			
		@RequestMapping(value="/roltop_listar",method= RequestMethod.GET)
		public String lista_GET(Map map)
		{

			map.put("bRoltop",roltopService.findAll());
			
			return "/roltop/listar";
		}
		
		@RequestMapping(value="/roltop_registrar",method= RequestMethod.GET)
		public String registrar_GET(Model model, Map map)
		{
			Roltop roltopModel=new Roltop(); //Equipos vacion
			model.addAttribute("roltop", roltopModel);
			
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/roltop/registrar";
		}
		
		@RequestMapping(value="/roltop_registrar",method=RequestMethod.POST)
		public String registrar_POST(Roltop roltop)
		{
			Imagencampeones imagencampeones=new Imagencampeones();
			
			//guardar equipo

			roltopService.insert(roltop);
			
			return "redirect:/campeones";
		}
		
		@RequestMapping(value="/roltop_editar/{topId}",method= RequestMethod.GET)
		public String editar_GET(Model model,@PathVariable Integer topId,Map map)
		{
			// busqueda por ID
			Roltop roltopModel=roltopService.findById(topId);
			
			model.addAttribute("roltop",roltopModel);
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/roltop/editar";
		}
		@RequestMapping(value="/roltop_editar/{topId}",method=RequestMethod.POST)
		public String editar_POST(Roltop roltop)
		{
			//guardar equipo
			roltopService.update(roltop);
			
			return "redirect:/campeones";
		}		
		
		@RequestMapping(value="/roltop_borrar/{topId}",method= RequestMethod.GET)
		public String borrar_GET(Model model,@PathVariable Integer topId)
		{
			// busqueda por ID
			Roltop roltopModel=roltopService.findById(topId);
			
			model.addAttribute("roltop", roltopModel);
			
			return "/roltop/borrar";
		}
		@RequestMapping(value="/roltop_borrar/{topId}",method=RequestMethod.POST)
		public String borrar_POST(Roltop roltop)
		{
			//guardar equipo
			roltopService.delete(roltop.getTopId());
			
			return "redirect:/campeones";
		}		
	}