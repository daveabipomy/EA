package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

import java.util.List;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User>  implements UserDao {

	public User findByEmail(String email) {

		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();


	}

	public void flush(){
		entityManager.flush();
	}
	public  void clear(){
		entityManager.clear();
	}


}