package pe.lol.controller;



import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import pe.lol.entity.Equipos;
import pe.lol.entity.Imagen;
import pe.lol.entity.Liderg;
import pe.lol.service.EquiposService;
import pe.lol.service.GrietasService;
import pe.lol.service.ImagenService;
import pe.lol.service.LidergService;

@Controller
public class EquiposController
{
	
	@Autowired
	private EquiposService equiposService;
	
	@Autowired
	private ImagenService imagenService;
	
	@Autowired
	private LidergService lidergService;

	@Autowired
	private GrietasService grietasService;
		
	
	@RequestMapping(value="/equipos_listar",method= RequestMethod.GET)
	public String lista_GET(Map map)
	{
		map.put("bEquipos",equiposService.findAll());
		
		return "equipos_listar";
	}
	@RequestMapping(value="/equipos_registrar",method= RequestMethod.GET)
	public String registrar_GET(Model model, Map map)
	{
		Equipos equiposModel1=new Equipos(); //Equipos vacion
		model.addAttribute("equipos", equiposModel1);
		
		map.put("bImagen",imagenService.findAll());
		map.put("bLiderg",lidergService.findAll());
		map.put("bGrietas",grietasService.findAll());
		
		return "equipos_registrar";
	}
	
	@RequestMapping(value="/equipos_registrar",method=RequestMethod.POST)
	public String registrar_POST(Equipos equipos)
	{
		Imagen imagen=new Imagen();
		
		
		
		//guardar equipo
		equiposService.insert(equipos);
		
		return "redirect:/equipos_listar";
	}
	@RequestMapping(value="/equipos_editar/{equiposId}",method= RequestMethod.GET)
	public String editar_GET(Model model,@PathVariable Integer equiposId,Map map)
	{
		// busqueda por ID
		Equipos equiposModel=equiposService.findById(equiposId);
		
		model.addAttribute("equipos", equiposModel);
		
		
		map.put("bImagen",imagenService.findAll());
		map.put("bLiderg",lidergService.findAll());
		map.put("bGrietas",grietasService.findAll());
		
		
		return "equipos_editar";
	}
	@RequestMapping(value="/equipos_editar/{equiposId}",method=RequestMethod.POST)
	public String editar_POST(Equipos equipos)
	{
		//guardar equipo
		equiposService.update(equipos);
		
		return "redirect:/equipos_listar";
	}
	@RequestMapping(value="/equipos_borrar/{equiposId}",method= RequestMethod.GET)
	public String borrar_GET(Model model,@PathVariable Integer equiposId)
	{
		// busqueda por ID
		Equipos equiposModel=equiposService.findById(equiposId);
		
		model.addAttribute("equipos", equiposModel);
		
		return "equipos_borrar";
	}
	@RequestMapping(value="/equipos_borrar/{equiposId}",method=RequestMethod.POST)
	public String borrar_POST(Equipos equipos)
	{
		//guardar equipo
		equiposService.delete(equipos.getEquiposId());
		
		return "redirect:/equipos_listar";
	}
	@RequestMapping(value="/equipos_detalle/{nombres}",method=RequestMethod.GET)
	public String detalle_GET(Map map,@PathVariable String nombres)
	{
		Equipos equiposModel=equiposService.findByNombres(nombres);
		map.put("equipos",equiposModel);
		
		map.put("bImagen",imagenService.findAll());
		map.put("bLiderg",lidergService.findAll());
		map.put("bGrietas",grietasService.findAll());
		
		return "equipos_detalle";
	}
	
}
