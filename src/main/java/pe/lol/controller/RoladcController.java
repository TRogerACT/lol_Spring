package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pe.lol.entity.Imagencampeones;
import pe.lol.entity.Roladc;
import pe.lol.entity.Rolmid;
import pe.lol.service.ImagenCampeonesService;
import pe.lol.service.RoladcService;
import pe.lol.service.RolmidService;

@Controller
public class RoladcController {

		@Autowired
		private RoladcService roladcService;
		
		@Autowired
		private ImagenCampeonesService imagenCampeonesService;
			
		@RequestMapping(value="/roladc_listar",method= RequestMethod.GET)
		public String lista_GET(Map map)
		{

			map.put("bRoladc",roladcService.findAll());
			
			return "/roladc/listar";
		}
		
		@RequestMapping(value="/roladc_registrar",method= RequestMethod.GET)
		public String registrar_GET(Model model, Map map)
		{
			Roladc roladcModel=new Roladc(); //Equipos vacion
			model.addAttribute("roladc", roladcModel);
			
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/roladc/registrar";
		}
		
		@RequestMapping(value="/roladc_registrar",method=RequestMethod.POST)
		public String registrar_POST(Roladc roladc)
		{
			Imagencampeones imagencampeones=new Imagencampeones();
			
			//guardar equipo

			roladcService.insert(roladc);
			
			return "redirect:/campeones";
		}
		
		@RequestMapping(value="/roladc_editar/{adcId}",method= RequestMethod.GET)
		public String editar_GET(Model model,@PathVariable Integer adcId,Map map)
		{
			// busqueda por ID
			Roladc roladcModel=roladcService.findById(adcId);
			
			model.addAttribute("roladc",roladcModel);
			
			
			map.put("bImagenc",imagenCampeonesService.findAll());

			
			return "/roladc/editar";
		}
		@RequestMapping(value="/roladc_editar/{adcId}",method=RequestMethod.POST)
		public String editar_POST(Roladc roladc)
		{
			//guardar equipo
			roladcService.update(roladc);
			
			return "redirect:/campeones";
		}		
		
		@RequestMapping(value="/roladc_borrar/{adcId}",method= RequestMethod.GET)
		public String borrar_GET(Model model,@PathVariable Integer adcId)
		{
			// busqueda por ID
			Roladc roladcModel=roladcService.findById(adcId);
			
			model.addAttribute("roladc", roladcModel);
			
			return "/roladc/borrar";
		}
		@RequestMapping(value="/roladc_borrar/{adcId}",method=RequestMethod.POST)
		public String borrar_POST(Roladc roladc)
		{
			//guardar equipo
			roladcService.delete(roladc.getAdcId());
			
			return "redirect:/campeones";
		}		
	}