package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.taskdetail;

public class dbservice {

	private String url = "jdbc:mysql://localhost:3306/new";

	private String username = "root";

	private String password = "root";

	private Connection connection;

	public dbservice() {
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<taskdetail> get_all_details() {
		List<taskdetail> entries = new ArrayList<>();
		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tasks");
			while (rs.next()) {
				taskdetail ob = new taskdetail();
				ob.setTask(rs.getString("task"));
				ob.setId(rs.getInt("id"));
				ob.setDetail(rs.getString("detail"));
				ob.setStat(rs.getString("stats"));
				ob.setAssignto(rs.getString("Assigned"));
				ob.setTastodo(rs.getString("tastodo"));
				entries.add(ob);
			}
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entries;
	}

	public void addnewTask(String task, String detail) {
		try {
			String sql = "insert into tasks (task,detail,stats,tastodo) values (?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, task);
			pstmt.setString(2, detail);
			pstmt.setString(3, "new");
			pstmt.setString(4, "assign");
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public taskdetail getparticularmem(int id) {
		taskdetail ob = new taskdetail();
		try {

			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tasks where id = '" + id + "'");
			while (rs.next()) {
				ob.setTask(rs.getString("task"));
				ob.setId(rs.getInt("id"));
				ob.setDetail(rs.getString("detail"));
				ob.setStat(rs.getString("stats"));
				ob.setAssignto(rs.getString("Assigned"));
				ob.setTastodo(rs.getString("tastodo"));
			}
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ob;
	}

	public void updateassignperson(int id, String name) {
		taskdetail ob = new taskdetail();
		try {

			Statement stmt = connection.createStatement();
			stmt.executeUpdate("update tasks set stats = 'in-progress' , Assigned = '" + name
					+ "', tastodo = 'complete' where id = '" + id + "'");
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void removeparticularmem(int id) {
		try {

			Statement stmt = connection.createStatement();
			stmt.executeUpdate("delete from tasks where id = '" + id + "'");
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

/* create table tasks(
id int auto_increment primary key,
detail varchar(255),
stats varchar(255),
Assigned varchar(255),
tastodo varchar(255));

alter table tasks add task varchar(255);

select * from tasks;
insert into tasks values(1,'send mail','in-progress','jim','complete','mail');
insert into tasks values(2,'send money','in-progress','john','complete','call');
insert into tasks values(3,'buy biscit for eating','new','john','assign','call');
delete from tasks where id = 3;


*/
