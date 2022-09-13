package tn.itbs.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.itbs.dao.DAOFactory;
import tn.itbs.dao.ProduitDAOImpl;
import tn.itbs.entities.Produit;


/**
 * Servlet implementation class Traitement
 */
@WebServlet("/ProduitController")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory dao;
	ProduitDAOImpl PDAO;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
		 dao= 	DAOFactory.getInstance();
		 PDAO = new ProduitDAOImpl(dao);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<Produit> list = PDAO.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("./Affiche.jsp").forward(request, response);
		
	
	}

	
	
	

}
