package fr.steakmans.ww3mod.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import fr.steakmans.ww3mod.WW3Mod;

public class MoneyManager {
	
	public void add(UUID uuid, long amount) {
		if(!hasAccount(uuid)) return;
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("UPDATE money SET money=? WHERE uuid=?");
			sts.setLong(1, getMoney(uuid) + amount);
			sts.setString(2, uuid.toString());
			sts.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean hasAccount(UUID uuid) {
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("SELECT * FROM money WHERE uuid=?");
			sts.setString(1, uuid.toString());
			ResultSet rs = sts.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public long getMoney(UUID uuid) {
		if(!hasAccount(uuid)) return 0;
		try {
			PreparedStatement sts = WW3Mod.instance.mysql.getConnection().prepareStatement("SELECT * FROM money WHERE uuid=?");
			sts.setString(1, uuid.toString());
			ResultSet rs = sts.executeQuery();
			if(rs.next()) {
				return rs.getLong("money");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
