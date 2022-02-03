package pe.lol.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


@Repository
public class LidergDaoImpl implements LidergDao
{
    @PersistenceContext
    private EntityManager entitymanager;

    @Override
    public boolean isEquipos(Integer lidergId) 
    {

        String SQL="select count(*) as 'cant_equipos' from equiposs where liderg_id=?1";
        Query  query=entitymanager.createNativeQuery(SQL);

        query.setParameter(1,lidergId);


        int equipos=((Number)query.getSingleResult()).intValue();

        if (equipos==0)
            return false;

        return true;
    }


}