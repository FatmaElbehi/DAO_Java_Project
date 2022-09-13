package tn.itbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tn.itbs.entities.Produit;


//implemente l'ensemble des méthodes CRUD
public class ProduitDAOImpl implements IProduitDAO {

	DAOFactory FDAO;
	
	public ProduitDAOImpl(DAOFactory fDAO) {
		FDAO = fDAO;
	}

	@Override
	public void save(Produit d) {
		String req = "INSERT INTO Produit values (?,?,?)";
		try {
			Connection con = FDAO.getConnection();
			PreparedStatement pst = con.prepareStatement(req);
			pst.setInt(1, d.getId());
			pst.setString(2, d.getNom());
			pst.setInt(3, d.getQte());
			 pst.executeUpdate();			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Produit> findAll() {
		
		String req = "SELECT * FROM produit";
		ArrayList<Produit> list = new ArrayList<Produit>();

		try {
			Connection con = FDAO.getConnection();
			PreparedStatement pst = con.prepareStatement(req);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new Produit(rs.getInt("id"),rs.getString("nom"), rs.getInt("qte")));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
		return list;
	}

	@Override
	public Produit findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
