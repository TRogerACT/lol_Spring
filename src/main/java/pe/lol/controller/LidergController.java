package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import pe.lol.entity.Liderg;
import pe.lol.service.LidergService;



@Controller
public class LidergController {
	
	@Autowired
	private LidergService lidergService;

	@RequestMapping(value="/liderg_listar",method=RequestMethod.GET)
	public String lista_GET(Map map)
	{
		map.put("bLiderg",lidergService.findAll());
		
		return "/liderg/liderg_listar";
	}
	
	@RequestMapping(value="/liderg_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model)
	{
		Liderg lidergModel=new Liderg(); // vacion
		model.addAttribute("liderg",lidergModel);
		
		return "/liderg/liderg_registrar";
	}
	
	@RequestMapping(value="/liderg_registrar",method=RequestMethod.POST)
	public String registrar_POST(Liderg liderg) //eq
	{
		//guardar
		lidergService.insert(liderg);
		
		return "redirect:/liderg_listar";
	}
	@RequestMapping(value="//liderg_editar/{lidergId}",method=RequestMethod.GET)
    public String editar_GET(Model model,@PathVariable Integer lidergId)
    {
        Liderg lidergModel=lidergService.findById(lidergId);
        model.addAttribute("liderg",lidergModel);  
       
        
        return "/liderg/liderg_editar";
    }
    @RequestMapping(value="//liderg_editar/{lidergId}",method=RequestMethod.POST)
    public String editar_POST(Liderg liderg)           
    {
        
        lidergService.update(liderg);
        
        return "redirect:/liderg_listar";
    }
    @RequestMapping(value="//liderg_borrar/{lidergId}",method=RequestMethod.GET)
    public String borrar_GET(Model model,@PathVariable Integer lidergId, Map map)
    {

        boolean isEquipos=lidergService.isEquipos(lidergId);
        Liderg lidergModel=lidergService.findById(lidergId);


        if(isEquipos) 
        {
            map.put("errorliderg", lidergModel.getNombre());
            return "/liderg/liderg_error";
        }


        model.addAttribute("liderg",lidergModel);  
        
        return "/liderg/liderg_borrar";
    }
    
	
    @RequestMapping(value="//liderg_borrar/{lidergId}",method=RequestMethod.POST)
    public String borrar_POST(Liderg liderg)
    {
        lidergService.delete(liderg.getLidergId());
        
        return "redirect:/liderg_listar";
    }
}
