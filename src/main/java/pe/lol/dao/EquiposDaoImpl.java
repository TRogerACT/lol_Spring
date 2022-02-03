package pe.lol.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class EquiposDaoImpl implements EquiposDao
{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
	public Collection<Object[]> find_AllEquiposCampeones() {

	        String SQL="select e.equiposId, e.nombres, t.nombre, j.nombre, m.nombre, a.nombre, s.nombre \n" +
	                   "from equipos_campeones ec \n" +
	                   "inner join equiposs e on ec.equiposId=e.equiposId \n" +
	                   "inner join topp t on ec.topId=t.topId \n" +
	                   "inner join jgg j on ec.jgId=j.jgId \n" +
	                   "inner join midd m on ec.midId=m.midId \n" +
	                   "inner join adcc a on ec.adcId=a.adcId \n" +
	                   "inner join supp s on ec.supId=s.supId";
	        
	        
	        Query query=entityManager.createNativeQuery(SQL);
	        
	        return query.getResultList();         
	    }
}
