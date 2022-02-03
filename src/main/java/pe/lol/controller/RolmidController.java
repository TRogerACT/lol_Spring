package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pe.lol.entity.Imagencampeones;
import pe.lol.entity.Rolmid;
import pe.lol.service.ImagenCampeonesService;
import pe.lol.service.RolmidService;

@Controller
public class RolmidController {

		@Autowired
		private RolmidService rolmidService;
		
		@Autowired
		private ImagenCampeonesService imagenCampeonesService;
			
		@RequestMapping(value="/rolmid_listar",method= RequestMethod.GET)
		public String lista_GET(Map map)
		{

			map.put("bRolmid",rolmidService.findAll());
			
			return "/rolmid/listar";
		}
		
		@RequestMapping(value="/rolmid_registrar",method= RequestMethod.GET)
		public String registrar_GET(Model model, Map map)
		{
			Rolmid rolmidModel=new Rolmid(); //Equipos vacion
			model.addAttribute("rolmid", rolmidModel);
			
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/rolmid/registrar";
		}
		
		@RequestMapping(value="/rolmid_registrar",method=RequestMethod.POST)
		public String registrar_POST(Rolmid rolmid)
		{
			Imagencampeones imagencampeones=new Imagencampeones();
			
			//guardar equipo

			rolmidService.insert(rolmid);
			
			return "redirect:/campeones";
		}
		
		@RequestMapping(value="/rolmid_editar/{midId}",method= RequestMethod.GET)
		public String editar_GET(Model model,@PathVariable Integer midId,Map map)
		{
			// busqueda por ID
			Rolmid rolmidModel=rolmidService.findById(midId);
			
			model.addAttribute("rolmid",rolmidModel);
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/rolmid/editar";
		}
		@RequestMapping(value="/rolmid_editar/{midId}",method=RequestMethod.POST)
		public String editar_POST(Rolmid rolmid)
		{
			//guardar equipo
			rolmidService.update(rolmid);
			
			return "redirect:/campeones";
		}		
		
		@RequestMapping(value="/rolmid_borrar/{midId}",method= RequestMethod.GET)
		public String borrar_GET(Model model,@PathVariable Integer midId)
		{
			// busqueda por ID
			Rolmid rolmidModel=rolmidService.findById(midId);
			
			model.addAttribute("rolmid", rolmidModel);
			
			return "/rolmid/borrar";
		}
		@RequestMapping(value="/rolmid_borrar/{midId}",method=RequestMethod.POST)
		public String borrar_POST(Rolmid rolmid)
		{
			//guardar equipo
			rolmidService.delete(rolmid.getMidId());
			
			return "redirect:/campeones";
		}		
	}