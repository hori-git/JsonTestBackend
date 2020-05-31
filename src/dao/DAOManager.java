package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOManager {

	Connection conn = null;
	String url = "jdbc:mysql://jsondb-rds.cswexgepmive.ap-northeast-1.rds.amazonaws.com:3306/rdsEmployeedb";
//	String url = "jdbc:mysql://localhost:3306/jsondb";
	String user = "hori";
	String password = "password";

	//コンストラクタ
	public DAOManager() {
		//コネクションの確立
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
			System.out.println("接続できました。");
//			File file = new File("~/text.txt");
//            FileWriter filewriter = new FileWriter(file);
//
//            filewriter.write("DBと接続に成功しました");
//            filewriter.close();
		} catch (Exception e) {//コネクションの確立に失敗
			System.out.println("DBとの接続に失敗しました");
			e.printStackTrace();
		}
	}

	public String searchEmployee(int id) {

		String name = "";

		//dao
		try {
			//パスワード取得用のSQLを用意
			PreparedStatement pre_statement = conn.prepareStatement("SELECT name FROM EmployeeList WHERE id = ?;");
			pre_statement.setInt(1, id);

			//SQL実行
			ResultSet result_set = pre_statement.executeQuery();
			result_set.next();
			name = result_set.getString("name");
//			File file = new File("~/textSearch.txt");
//            FileWriter filewriter = new FileWriter(file);
//
//            filewriter.write("値を取得しました。名前：" + name);
//            filewriter.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("エラー");

		}

		return name;
	}
}
