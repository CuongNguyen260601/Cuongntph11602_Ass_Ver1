package com.controller;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet({"/Bai2","/Bai2/Create","/Bai2/Update","/Bai2/Delete","/Bai2/Reset","/Bai2/Search","/Bai2/Show"})
public class Bai2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.util.List<User> list = new ArrayList<User>();
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		String uri = request.getRequestURI();
 		 if(uri.contains("Show")) {
			EntityManager em = JpaUtils.getEntityManager();
			EntityTransaction tran = em.getTransaction();
			try {
				tran.begin();
					User user = em.find(User.class, request.getParameter("idUser"));
					request.setAttribute("user",user);
					String jpql = "SELECT u FROM User u";
					TypedQuery<User> query = em.createQuery(jpql,User.class);
					list = query.getResultList();
					request.setAttribute("list", list);
				tran.commit();
			} catch (Exception e) {
				tran.rollback();
			}finally {
				em.close();
			}
		}
		request.getRequestDispatcher("/Views/Bai123.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if(uri.contains("Create")) {
			this.createUser(request, response);
		}else if(uri.contains("Update")) {
			this.updateUser(request, response);
		}else if(uri.contains("Delete")) {
			this.deleteUser(request, response);
		}
		else if(uri.contains("Search")) {
			this.searchUser(request, response);
		}
		else if(uri.contains("Reset")) {
			EntityManager em = JpaUtils.getEntityManager();
			EntityTransaction tran = em.getTransaction();
			try {
				tran.begin();
					String jpql = "SELECT u FROM User u";
					TypedQuery<User> query = em.createQuery(jpql,User.class);
					list = query.getResultList();
					request.setAttribute("list", list);
				tran.commit();
			} catch (Exception e) {
				tran.rollback();
			}finally {
				em.close();
			}
		}
		request.getRequestDispatcher("/Views/Bai123.jsp").forward(request, response);
	}

	private int createUser(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
				User user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				em.persist(user);
				String jpql = "SELECT u FROM User u";
				TypedQuery<User> query = em.createQuery(jpql,User.class);
				list = query.getResultList();
				request.setAttribute("list", list);
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
				String jpql = "SELECT u FROM User u";
				TypedQuery<User> query = em.createQuery(jpql,User.class);
				list = query.getResultList();
				request.setAttribute("list", list);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			return -1;
		}finally {
			em.close();
		}
		return 1;
	}
	private int deleteUser(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
				User user = em.find(User.class, request.getParameter("id"));
				em.remove(user);
				String jpql = "SELECT u FROM User u";
				TypedQuery<User> query = em.createQuery(jpql,User.class);
				list = query.getResultList();
				request.setAttribute("list", list);
			tran.commit();
		} catch (Exception e) {
			tran.rollback();
			return -1;
		}finally {
			em.close();
		}
		return 1;
	}
	private int searchUser(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction tran = em.getTransaction();
		try {
			tran.begin();
				String jpql = "SELECT u FROM User u WHERE u.fullName LIKE ?0";
				TypedQuery<User> query = em.createQuery(jpql,User.class);
				query.setParameter(0, request.getParameter("search"));
				list = query.getResultList();
				request.setAttribute("list", list);
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
