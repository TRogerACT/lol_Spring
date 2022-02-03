package pe.lol.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.lol.entity.Grietas;
import pe.lol.entity.Liderg;
import pe.lol.service.GrietasService;



@Controller
public class GrietasController {

	@Autowired
	private GrietasService grietasService;
	
	@RequestMapping(value="/grietas_listar",method=RequestMethod.GET)
	public String lista_GET(Map map)
	{
		map.put("bGrietas",grietasService.findAll());
		
		return "/grietas/grietas_listar";
	}
	
	@RequestMapping(value="/grietas_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model)
	{
		Grietas grietasModel=new Grietas(); // vacion
		model.addAttribute("grietas",grietasModel);
		
		return "/grietas/grietas_registrar";
	}
	
	@RequestMapping(value="/grietas_registrar",method=RequestMethod.POST)
	public String registrar_POST(Grietas grietas) //eq
	{
		//guardar
		grietasService.insert(grietas);
		
		return "redirect:/grietas_listar";
	}
	
	@RequestMapping(value="//grietas_editar/{grietasId}",method=RequestMethod.GET)
    public String editar_GET(Model model,@PathVariable Integer grietasId)
    {
        Grietas grietasModel=grietasService.findById(grietasId);
        model.addAttribute("grietas",grietasModel);  
       
        
        return "/grietas/grietas_editar";
    }
    @RequestMapping(value="//grietas_editar/{grietasId}",method=RequestMethod.POST)
    public String editar_POST(Grietas grietas)           
    {
        
    	grietasService.update(grietas);
        
        return "redirect:/grietas_listar";
    }
    
    @RequestMapping(value="//grietas_borrar/{grietasId}",method=RequestMethod.GET)
    public String borrar_GET(Model model,@PathVariable Integer grietasId,  Map map)
    {

        boolean isEquipos=grietasService.isEquipos(grietasId);
        Grietas grietasModel=grietasService.findById(grietasId);


        if(isEquipos) 
        {
            map.put("errorgrietas", grietasModel.getNombre());
            return "/grietas/grietas_error";
        }


        model.addAttribute("grietas",grietasModel);  
        
        return "/grietas/grietas_borrar";
    }
    @RequestMapping(value="//grietas_borrar/{grietasId}",method=RequestMethod.POST)
    public String borrar_POST(Grietas grietas)
    {
    	grietasService.delete(grietas.getGrietasId());
        
        return "redirect:/grietas_listar";
    }
}
