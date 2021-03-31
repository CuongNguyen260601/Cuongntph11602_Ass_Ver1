package com.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.model.User;
import com.utils.JpaUtils;

/**
 * Servlet implementation class Bai4
 */
@WebServlet({"/Bai4","/Bai4/SignIn","/Bai4/Show","/Bai4/Update","/Bai4/Create"})
public class Bai4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		 if(uri.contains("Show")) {
			EntityManager em = JpaUtils.getEntityManager();
			EntityTransaction tran = em.getTransaction();
			try {
				tran.begin();
					User user = em.find(User.class, request.getParameter("idUser"));
					request.setAttribute("user",user);
				tran.commit();
			} catch (Exception e) {
				tran.rollback();
			}finally {
				em.close();
			}
		}
		request.getRequestDispatcher("/Views/Bai4/Info.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if(uri.contains("SignIn")) {
			User user = signIn(request, response);
			if(user!=null) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("/Views/Bai4/Profile.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("/Views/Bai4/Login.jsp").forward(request, response);
			}
		}else if (uri.contains("Update")) {
			this.updateUser(request, response);
			request.getRequestDispatcher("/Views/Bai4/Profile.jsp").forward(request, response);
		}else if (uri.contains("Create")) {
			this.createUser(request, response);
			request.getRequestDispatcher("/Views/Bai4/Login.jsp").forward(request, response);
		}
	}

	public User signIn(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
				String jpql = "SELECT u FROM User u WHERE u.email=:email AND u.passWord=:pw";
				TypedQuery<User> query = em.createQuery(jpql,User.class);
				query.setParameter("email", request.getParameter("email"));
				query.setParameter("pw", request.getParameter("pw"));
				User user = query.getSingleResult();
				tran.commit();
				return user;
		
		} catch (Exception e) {
			tran.rollback();
			return null;
		}finally {
			em.close();
		}
	}
	private int createUser(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
				User user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				em.persist(user);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			return -1;
		}finally {
			em.close();
		}
		return 1;
	}
	private int updateUser(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
				User user = em.find(User.class, request.getParameter("id"));
				BeanUtils.populate(user, request.getParameterMap());
				em.merge(user);
				User user1 = em.find(User.class, user.getId());
				request.setAttribute("user", user1);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			return -1;
		}finally {
			em.close();
		}
		return 1;
	}
}
