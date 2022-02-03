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

import pe.lol.entity.Imagen;
import pe.lol.entity.Liderg;
import pe.lol.service.ImagenService;


@Controller
public class ImagenController 
{
	@Autowired
	private ImagenService imagenService;

	@RequestMapping(value="/imagen_listar",method=RequestMethod.GET)
	public String listar_GET(Map map)
	{
		map.put("bImagen",imagenService.findAll());
		return "/imagen/listar";
	}
	
	
	@RequestMapping(value="/imagen_registrar",method=RequestMethod.GET)
	public String registrar_GET(Model model)
	{
		model.addAttribute("imagen",new Imagen());
		return "/imagen/registrar";
	}
	@RequestMapping(value="/imagen_registrar",method=RequestMethod.POST)
	public String registrar_POST(@RequestPart("picture") MultipartFile picture) throws IOException
	{
		Imagen imagen=new Imagen();
		
		imagen.setNombre(picture.getOriginalFilename());
		imagen.setFile(picture.getBytes());
		
		imagenService.insert(imagen);
		
		
		return "redirect:/imagen_listar";
	}
	
	@RequestMapping(value="/imagen_editar/{imagenId}",method=RequestMethod.GET)
    public String editar_GET(Model model,@PathVariable Integer imagenId)
	{
		Imagen imagenModel= imagenService.findById(imagenId);
		model.addAttribute("imagen",imagenModel);
		
		return "/imagen/editar";
	}
	
    @RequestMapping(value="/imagen_editar/{imagenId}",method=RequestMethod.POST)
    public String editar_POST(Imagen imagen,@PathVariable Integer imagenId, 
            @RequestParam("picture") MultipartFile picture) throws IOException//modificar      
    {
        if(picture.isEmpty()) 
        {
        	
    		
        	Imagen imagenmodel=imagenService.findById(imagenId);
        	imagen.setFile(imagenmodel.getFile());
        }
        else {
            imagen.setFile(picture.getBytes());
        }     
        
   		imagen.setNombre(picture.getOriginalFilename());
		
        
        
        imagenService.update(imagen);
		
		
		return "redirect:/imagen_listar";
	}

    @RequestMapping(value="/imagen_borrar/{imagenId}",method=RequestMethod.GET)
    public String borrar_GET(Model model,@PathVariable Integer imagenId)
    {
		Imagen imagenModel= imagenService.findById(imagenId);
		model.addAttribute("imagen",imagenModel);        
        
        return "/imagen/borrar";
    }
    @RequestMapping(value="/imagen_borrar/{imagenId}",method=RequestMethod.POST)
    public String borrar_POST(Imagen imagen)
    {
    	imagenService.delete(imagen.getImagenId());
        
        return "redirect:/imagen_listar";
    }
}
