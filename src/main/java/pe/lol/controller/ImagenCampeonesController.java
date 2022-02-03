package pe.lol.controller;



import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import pe.lol.entity.Imagencampeones;
import pe.lol.service.ImagenCampeonesService;




@Controller
public class ImagenCampeonesController 
{
	@Autowired
	private ImagenCampeonesService imagenCampeonesService;

	@RequestMapping(value="/imagen_campeones_listar",method=RequestMethod.GET)
	public String listar_GET(Map map)
	{
		map.put("bImagenc",imagenCampeonesService.findAll());
		return "/imagencampeones/listar";
	}
	
	
	@RequestMapping(value="/imagen_campeones_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model)
	{
		model.addAttribute("imagencampeones",new Imagencampeones());
		return "/imagencampeones/registrar";
	}
	@RequestMapping(value="/imagen_campeones_registrar",method=RequestMethod.POST)
	public String registrar_POST(@RequestPart("picture") MultipartFile picture) throws IOException
	{
		Imagencampeones imagencampeones=new Imagencampeones();
		
		imagencampeones.setNombre(picture.getOriginalFilename());
		imagencampeones.setFile(picture.getBytes());
		
		imagenCampeonesService.insert(imagencampeones);
		
		
		return "redirect:/imagen_campeones_listar";
	}
	
	@RequestMapping(value="/imagen_campeones_editar/{imagenId}",method=RequestMethod.GET)
    public String editar_GET(Model model,@PathVariable Integer imagenId)
	{
		Imagencampeones imagencampeonesModel=imagenCampeonesService.findById(imagenId);
		model.addAttribute("imagencampeones",imagencampeonesModel);
		
		return "/imagencampeones/editar";
	}
	
    @RequestMapping(value="/imagen_campeones_editar/{imagenId}",method=RequestMethod.POST)
    public String editar_POST(Imagencampeones imagencampeones,@PathVariable Integer imagenId,
            @RequestParam("picture") MultipartFile picture) throws IOException//modificar
    {
        if(picture.isEmpty())
        {
        	
    		
        	Imagencampeones imagencampeonesModel=imagenCampeonesService.findById(imagenId);
        	imagencampeones.setFile(imagencampeonesModel.getFile());
        }
        else {
            imagencampeones.setFile(picture.getBytes());
        }     
        
   		imagencampeones.setNombre(picture.getOriginalFilename());
		
        
        
        imagenCampeonesService.update(imagencampeones);
		
		
        return "redirect:/imagen_campeones_listar";
	}

    @RequestMapping(value="/imagen_campeones_borrar/{imagenId}",method=RequestMethod.GET)
    public String borrar_GET(Model model,@PathVariable Integer imagenId)
    {
		Imagencampeones imagencampeonesModel= imagenCampeonesService.findById(imagenId);
		model.addAttribute("imagencampeones",imagencampeonesModel);
        
        return "/imagencampeones/borrar";
    }
    @RequestMapping(value="/imagen_campeones_borrar/{imagenId}",method=RequestMethod.POST)
    public String borrar_POST(Imagencampeones imagencampeones)
    {
    	imagenCampeonesService.delete(imagencampeones.getImagenId());
        
    	return "redirect:/imagen_campeones_listar";
    }
}

