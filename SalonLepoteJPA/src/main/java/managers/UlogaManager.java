package managers;

import java.util.List;

import javax.persistence.EntityManager;

import model.Uloga;

public class UlogaManager {
	
	public List<Uloga> getSveUloge(){
		EntityManager em = JPAUtil.getEntityManager();
		List<Uloga> uloge = em.createQuery("from Uloga u", Uloga.class).getResultList();
		return uloge;
	}

}
