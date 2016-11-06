package lesson.j2ee.ex6.model;

import java.util.*;
import java.sql.*;

public class BeerExpert {

//	public List getBrands(String rootpath, String color) {
//		Connection conn = null;
//		List brands = new ArrayList();
//		try {
//			conn = AccessJDBCUtil.getAccessDBConnection(rootpath + "db/ex6.mdb");
//			Statement stmt = conn.createStatement();
//
//			if (color.equals("light")) {
//				String queryString = "SELECT name FROM beer WHERE color = 'light'";
//				ResultSet rs = stmt.executeQuery(queryString);
//				while (rs.next()) {
//					brands.add(rs.getString(1));
//				}
//			} else if (color.equals("amber")) {
//				String queryString = "SELECT name FROM beer WHERE color = 'amber'";
//				ResultSet rs = stmt.executeQuery(queryString);
//				while (rs.next()) {
//					brands.add(rs.getString(1));
//				}
//			} else if (color.equals("brown")) {
//				String queryString = "SELECT name FROM beer WHERE color = 'brown'";
//				ResultSet rs = stmt.executeQuery(queryString);
//				while (rs.next()) {
//					brands.add(rs.getString(1));
//				}
//			} else {
//				String queryString = "SELECT name FROM beer WHERE color = 'dark'";
//				ResultSet rs = stmt.executeQuery(queryString);
//				while (rs.next()) {
//					brands.add(rs.getString(1));
//				}
//			}
//			return (brands);
//		} catch (SQLException s) {
//			System.out.println(s);
//			return null;
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException ignore) {
//				}
//			}
//		}
//	}

	//从数据库中找出相应的颜色啤酒
	public List getBrands(String color) {
		List list = new ArrayList<BeerItem>();
		String sql = "select * from beer where color = \"" + color + "\"";
		MySQLDBHelper dbHelper = new MySQLDBHelper(sql);
		try {
			ResultSet ret = dbHelper.pst.executeQuery();
			while (ret.next()){
				BeerItem beer = new BeerItem(ret.getInt(1),ret.getString(2),ret.getString(3),ret.getString(4));
				list.add(beer);
			}
			ret.close();
			dbHelper.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

}
