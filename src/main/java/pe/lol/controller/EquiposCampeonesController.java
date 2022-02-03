package pe.lol.controller;

import java.util.Map;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.lol.entity.Equipos;
import pe.lol.entity.Roladc;
import pe.lol.entity.Roljg;
import pe.lol.entity.Rolmid;
import pe.lol.entity.Rolsup;
import pe.lol.entity.Roltop;
import pe.lol.service.EquiposService;
import pe.lol.service.RoladcService;
import pe.lol.service.RoljgService;
import pe.lol.service.RolmidService;
import pe.lol.service.RolsupService;
import pe.lol.service.RoltopService;

@Controller
public class EquiposCampeonesController
{
	
	@Autowired
	private EquiposService equiposService;
	
	@Autowired
	private RoltopService roltopService;
	
	@Autowired
	private RoljgService roljgService;
	
	@Autowired
	private RolmidService rolmidService;
	
	@Autowired
	private RoladcService roladcService;
	
	@Autowired
	private RolsupService rolsupService;
	
	private Collection<Roltop> carrito1=new ArrayList<>();
	
	private Collection<Roljg>  carrito2=new ArrayList<>();
	
	private Collection<Rolmid> carrito3=new ArrayList<>();
	
	private Collection<Roladc> carrito4=new ArrayList<>();
	
	private Collection<Rolsup> carrito5=new ArrayList<>();
	
	@RequestMapping(value="/equipos_campeones_listar",method= RequestMethod.GET)
	public String listacampeones_GET(Map map)
	{
		map.put("bEquiposcampeones",equiposService.find_AllEquiposCampeones());
		carrito1.clear();
		carrito2.clear();
		carrito3.clear();
		carrito4.clear();
		carrito5.clear();
		return "/equiposcampeones/listar";
	}	
	
    @RequestMapping(value="/equipos_campeones_registrar",method=RequestMethod.GET)
    public String registrar_GET(Map map)
    {
        map.put("bequipos",equiposService.findAll());
        
        map.put("btop",roltopService.findAll());
        
        map.put("bjg",roljgService.findAll());
        
        map.put("bmid",rolmidService.findAll());
        
        map.put("badc",roladcService.findAll());
        
        map.put("bsup",rolsupService.findAll());
        
        map.put("bcarrito1",carrito1);
        
        map.put("bcarrito2",carrito2);
        
        map.put("bcarrito3",carrito3);
        
        map.put("bcarrito4",carrito4);
        
        map.put("bcarrito5",carrito5);
        
        return"equipos_campeones_registrar";
    }
    
    @RequestMapping(value="/agregar1/{topId}",method=RequestMethod.GET)
    public String agregar1(@PathVariable Integer topId)
    {
    	Roltop topBD=roltopService.findById(topId);
       carrito1.add(topBD);
       return "redirect:/equipos_campeones_registrar";
    }   
    
    @RequestMapping(value="/agregar2/{jgId}",method=RequestMethod.GET)
    public String agregar2(@PathVariable Integer jgId)
    {
    	Roljg jgBD=roljgService.findById(jgId);
       carrito2.add(jgBD);
       return "redirect:/equipos_campeones_registrar";
    }   
    
    @RequestMapping(value="/agregar3/{midId}",method=RequestMethod.GET)
    public String agregar3(@PathVariable Integer midId)
    {
    	Rolmid midBD=rolmidService.findById(midId);
       carrito3.add(midBD);
       return "redirect:/equipos_campeones_registrar";
    }   
	
    @RequestMapping(value="/agregar4/{adcId}",method=RequestMethod.GET)
    public String agregar4(@PathVariable Integer adcId)
    {
    	Roladc adcBD=roladcService.findById(adcId);
       carrito4.add(adcBD);
       return "redirect:/equipos_campeones_registrar";
    }   
    
    @RequestMapping(value="/agregar5/{supId}",method=RequestMethod.GET)
    public String agregar5(@PathVariable Integer supId)
    {
    	Rolsup supBD=rolsupService.findById(supId);
       carrito5.add(supBD);
       return "redirect:/equipos_campeones_registrar";
    } 
    
    @RequestMapping(value="/equipos_campeones_registrar",method=RequestMethod.POST)
    public String registrar_POST(@RequestParam("equiposId") Integer equiposId)
    {
        Equipos equiposBD=equiposService.findById(equiposId);
        
        for(Roltop roltop:carrito1)
        {
            equiposBD.addRoltop(roltop);
        }
        
        for(Roljg roljg:carrito2)
        {
            equiposBD.addRoljg(roljg);
        }
        
        for(Rolmid rolmid:carrito3)
        {
            equiposBD.addRolmid(rolmid);
        }
        
        for(Roladc roladc:carrito4)
        {
            equiposBD.addRoladc(roladc);
        }
        
        for(Rolsup rolsup:carrito5)
        {
            equiposBD.addRolsup(rolsup);
        }
        
        equiposService.update(equiposBD);
                
        return "equipos_campeones_listar";
    }
}
