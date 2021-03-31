package com.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	public static EntityManager getEntityManager() {
		EntityManagerFactory etm = Persistence.createEntityManagerFactory("Cuongntph11602_Lab5");
		return etm.createEntityManager();
	}
}
