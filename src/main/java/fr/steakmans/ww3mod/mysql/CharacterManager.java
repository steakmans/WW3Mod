package fr.steakmans.ww3mod.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.steakmans.ww3mod.WW3Mod;

public class CharacterManager {
	
	public void insert(UUID uuid, String nom, String prenom, int age) {
		if(contains(uuid)) return;
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("INSERT INTO Characters (uuid, nom, prenom, age) VALUES (?, ?, ?, ?)");
			sts.setString(1, uuid.toString());
			sts.setString(2, nom);
			sts.setString(3, prenom);
			sts.setInt(4, age);
			sts.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getName(UUID uuid) {
		if(!contains(uuid)) return null;
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("SELECT * FROM Characters WHERE uuid=?");
			sts.setString(1, uuid.toString());
			ResultSet rs = sts.executeQuery();
			if(rs.next()) return rs.getString("prenom");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLastName(UUID uuid) {
		if(!contains(uuid)) return null;
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("SELECT * FROM Characters WHERE uuid=?");
			sts.setString(1, uuid.toString());
			ResultSet rs = sts.executeQuery();
			if(rs.next()) return rs.getString("nom");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int getAge(UUID uuid) {
		if(!contains(uuid)) return 0;
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("SELECT * FROM Characters WHERE uuid=?");
			sts.setString(1, uuid.toString());
			ResultSet rs = sts.executeQuery();
			if(rs.next()) return rs.getInt("age");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean contains(UUID uuid) {
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("SELECT * FROM Characters WHERE uuid=?");
			sts.setString(1, uuid.toString());
			ResultSet rs = sts.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
