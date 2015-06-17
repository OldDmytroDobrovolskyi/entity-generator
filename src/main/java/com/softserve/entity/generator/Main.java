package com.softserve.entity.generator;

import com.softserve.entity.generator.config.EntityManagerConfigurator;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class Main
{
    private static final Logger logger = Logger.getLogger(Main.class);
    private static final EntityManager entityManager = EntityManagerConfigurator.getEntityManager();

    public static void main(String[] args)
    {
        logger.info("Configured.");
        Query query = entityManager.createNativeQuery("SELECT name FROM Test");
        logger.info(query.getResultList());
        EntityManagerConfigurator.closeSession();
    }
}
