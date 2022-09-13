package tn.itbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

	private String login;
	private String mdp;
	private String url;
	public DAOFactory(String login, String mdp, String url) {
		this.login = login;
		this.mdp = mdp;
		this.url = url;
	}
	
	public static DAOFactory getInstance() throws ClassNotFoundException {
		
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		DAOFactory dao = new DAOFactory("root", "", "jdbc:mysql://localhost:3308/tpbd");
		return dao;
	}
	
	public Connection getConnection() throws SQLException  {
		
		return DriverManager.getConnection(url, login, mdp);
	}
	
	public IProduitDAO getProduit() {
		return new ProduitDAOImpl(this);
	}
	
}
