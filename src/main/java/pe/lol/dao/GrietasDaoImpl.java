package pe.lol.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class GrietasDaoImpl implements GrietasDao
{
    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public boolean isEquipos(Integer grietasId) 
    {

        String SQL="select count(*) as 'cant_equipos' from equiposs where grietas_id=?1";
        Query  query=entitymanager.createNativeQuery(SQL);

        query.setParameter(1,grietasId);


        int equipos=((Number)query.getSingleResult()).intValue();

        if (equipos==0)
            return false;

        return true;
    }


}