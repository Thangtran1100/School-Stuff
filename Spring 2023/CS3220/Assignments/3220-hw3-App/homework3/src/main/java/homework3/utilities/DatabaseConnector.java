package homework3.utilities;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import homework3.model.PatientViewModel;
import homework3.model.UserEntry;
import homework3.model.VaccineEntry;

public class DatabaseConnector {

	private String url = "jdbc:mysql://localhost:3306/cs3220stu102";

	private String username = "root";

	private String password = "SummerOriginal$2022";

	private Connection connection;

	public DatabaseConnector() {
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

	public List<VaccineEntry> getVaccineEntries() {
		List<VaccineEntry> entries = new ArrayList<VaccineEntry>();


		
		try {
			Statement stmt = connection.createStatement();
			
		
			
			ResultSet rs = stmt.executeQuery("select * from vaccines");
			VaccineEntry entry = null;
			while (rs.next()) {
				int vaccineId = rs.getInt("id");
				String vaccineName = rs.getString("name");
				int dosesRequired = rs.getInt("doses_required");
				int daysBetweenDoses = rs.getInt("days_between_doses");
				int dosesReceived = rs.getInt("doses_received");
				int dosesLeft = rs.getInt("doses_left");
				
				
				// If a new vaccine is encountered, create a new vaccine object
				if (entry == null || entry.getVaccineId() != vaccineId) {
					entry = new VaccineEntry();
					entry.setVaccineId(vaccineId);
					entry.setVaccineName(vaccineName);
					entry.setDoseRequired(dosesRequired);
					entry.setDaysBetweenDose(daysBetweenDoses);
					entry.setTotalDoseReceived(dosesReceived);
					entry.setTotalDoseLeft(dosesLeft);
					entries.add(entry);
				}
				
				

			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entries;
	}

	public VaccineEntry getVaccineEntry(int id) {
		VaccineEntry entry = new VaccineEntry();

		try {
			String sql = "select * from vaccines where id = ?";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setVaccineId(rs.getInt("id"));
				entry.setVaccineName(rs.getString("name"));
				entry.setDoseRequired(rs.getInt("doses_required"));
				entry.setDaysBetweenDose(rs.getInt("days_between_doses"));
				entry.setTotalDoseReceived(rs.getInt("doses_received"));
				entry.setTotalDoseLeft(rs.getInt("doses_left"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}

	public int addVaccineEntry(String vaccineName, int dosesRequired, int daysBetweenDoses)
			throws ClassNotFoundException {

		int id = 0;

		try {
			String INSERT_VACCINES_SQL = "insert into vaccines (name, doses_required, days_between_doses) values (?,?,?);";

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, vaccineName);
			preparedStatement.setInt(2, dosesRequired);
			preparedStatement.setInt(3, daysBetweenDoses);

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();
			if (rs.next())
				id = rs.getInt(1);
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}
	
	public int addVaccineDose(String vaccineName, int dosesReceived)
			throws ClassNotFoundException {

		int id = 0;

		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from vaccines");
			
			while (rs.next()) {
				String dataVaccineName = rs.getString("name");
				int dataDosesReceived = rs.getInt("doses_received");
				int dataDosesLeft = rs.getInt("doses_left");

				if (dataVaccineName.equals(vaccineName)) {
					String INSERT_VACCINES_SQL = "update vaccines set doses_received = ?, doses_left = ? where name = ?;";

					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
							Statement.RETURN_GENERATED_KEYS);

					
					preparedStatement.setInt(1, dataDosesReceived + dosesReceived);
					preparedStatement.setInt(2, dataDosesLeft + dosesReceived);
					preparedStatement.setString(3, vaccineName);

					preparedStatement.executeUpdate();

					ResultSet rsk = preparedStatement.getGeneratedKeys();
					if (rsk.next())
						id = rsk.getInt(1);
					preparedStatement.close();
				}
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}
	
	public int updateVaccineInfo(String vaccineName, int doses_required, int days_between_doses)
			throws ClassNotFoundException {

		int id = 0;

		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from vaccines");
			
			while (rs.next()) {
				String dataVaccineName = rs.getString("name");

				// If a new vaccine is encountered, create a new vaccine object
				if (dataVaccineName.equals(vaccineName)) {
					String INSERT_VACCINES_SQL = "update vaccines set doses_required = ?, days_between_doses = ? where name = ?;";

					PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
							Statement.RETURN_GENERATED_KEYS);

					
					preparedStatement.setInt(1, doses_required);
					preparedStatement.setInt(2, days_between_doses);
					preparedStatement.setString(3, vaccineName);

					preparedStatement.executeUpdate();

					ResultSet rsk = preparedStatement.getGeneratedKeys();
					if (rsk.next())
						id = rsk.getInt(1);
					preparedStatement.close();
				}
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}
	
	public List<PatientViewModel> getPatientEntries() {
		List<PatientViewModel> entries = new ArrayList<PatientViewModel>();
		
		int id =0;

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select p.id as patient_id, p.name as patient_name, vaccine_id, \r\n"
					+ "	v.name as vaccine_name, doses_required, doses_left, first_dose_date, second_dose_date\r\n"
					+ "from patients p join vaccines v \r\n"
					+ "on p.vaccine_id = v.id;");
			
			PatientViewModel patientEntry = null;
			
			while (rs.next()) {
				int patientId = rs.getInt("patient_id");
				String patientName = rs.getString("patient_name");
				int vaccineId = rs.getInt("vaccine_id");
				String vaccineName = rs.getString("vaccine_name");
				int dosesRequired = rs.getInt("doses_required");
				int dosesLeft = rs.getInt("doses_left");
				Date firstDoseDate = rs.getDate("first_dose_date");
				Date secondDoseDate = rs.getDate("second_dose_date");
				
				

				// If a new patient is encountered, create a new patient object
				if (patientEntry == null || patientEntry.getVaccineId() != vaccineId || patientEntry.getId() != patientId) {
					patientEntry = new PatientViewModel();
					patientEntry.setId(patientId);
					patientEntry.setName(patientName);
					patientEntry.setVaccineId(vaccineId);
					patientEntry.setVaccineName(vaccineName);
					patientEntry.setVaccineDosesRequired(dosesRequired);
					patientEntry.setVaccineDosesLeft(dosesLeft);
					patientEntry.setFirstDoseDate(firstDoseDate);
					patientEntry.setSecondDoseDate(secondDoseDate);
	
					entries.add(patientEntry);
				}
				
			}

			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return entries;
	}
	
	public PatientViewModel getPatientEntry(int id) {
		PatientViewModel entry = new PatientViewModel();

		try {
			String sql = "select p.id as patient_id, p.name as patient_name,\r\n"
					+ "					v.name as vaccine_name, first_dose_date, second_dose_date\r\n"
					+ "					from patients p join vaccines v\r\n"
					+ "					on p.vaccine_id = v.id\r\n"
					+ "                    where p.id = ?;";
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				entry.setId(rs.getInt("patient_id"));
				entry.setName(rs.getString("patient_name"));
				entry.setVaccineId(rs.getInt("vaccine_id"));
				entry.setVaccineName(rs.getString("vaccine_name"));
				entry.setVaccineDosesRequired(rs.getInt("doses_required"));
				entry.setVaccineDosesLeft(rs.getInt("doses_left"));
				entry.setFirstDoseDate(rs.getDate("first_dose_date"));
				entry.setSecondDoseDate(rs.getDate("second_dose_date"));
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entry;
	}

	public int addPatientEntry(String patientName, String vaccineName)
			throws ClassNotFoundException {

		int id = 0;
		
		int vaccineId = 0;
		
		LocalDate currDate = LocalDate.now();
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String firstDoseDateStr = formatDate.format(currDate);

		Date firstDoseDate = null;
		try {
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    
		    java.util.Date utilDate = format.parse(firstDoseDateStr);
		    
		    long mSeconds = utilDate.getTime();
		    
		    firstDoseDate = new java.sql.Date(mSeconds);
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		try {
			
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from vaccines");
			
			while (rs.next()) {
				
				String dataVaccineName = rs.getString("name");

				if (dataVaccineName.equals(vaccineName)) {
					vaccineId = rs.getInt("id");
					int dosesLeft = rs.getInt("doses_left");
					
					String UPDATE_VACCINES_SQL = "update vaccines set doses_left = ? where name = ?;";

					PreparedStatement preparedStatementVaccine = connection.prepareStatement(UPDATE_VACCINES_SQL,
							Statement.RETURN_GENERATED_KEYS);


					preparedStatementVaccine.setInt(1, dosesLeft - 1);
					preparedStatementVaccine.setString(2, vaccineName);

					preparedStatementVaccine.executeUpdate();

					ResultSet rsk = preparedStatementVaccine.getGeneratedKeys();
					if (rsk.next())
						id = rsk.getInt(1);
					preparedStatementVaccine.close();
				}
		
			}
			
			String INSERT_VACCINES_SQL = "insert into patients (name, vaccine_id, first_dose_date) values (?, ?, ?);";

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, patientName);
			preparedStatement.setInt(2, vaccineId);
			preparedStatement.setDate(3, firstDoseDate);

			preparedStatement.executeUpdate();

			ResultSet rsk = preparedStatement.getGeneratedKeys();
			if (rsk.next())
				id = rsk.getInt(1);
			preparedStatement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}
	
	public int updateVaccineReceivedInfo(int patientId, String vaccineName)
			throws ClassNotFoundException {

		int id = 0;
		
		LocalDate currDate = LocalDate.now();
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String secondDoseDateStr = formatDate.format(currDate);

		Date secondDoseDate = null;
		try {
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    
		    java.util.Date utilDate = format.parse(secondDoseDateStr);
		    
		    long mSeconds = utilDate.getTime();
		    
		    secondDoseDate = new java.sql.Date(mSeconds);
		} catch (ParseException e) {
		    e.printStackTrace();
		}

		try {
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from vaccines");
			
			while (rs.next()) {
				
				String dataVaccineName = rs.getString("name");

				if (dataVaccineName.equals(vaccineName)) {

			
					
					String UPDATE_VACCINES_SQL = "update vaccines set doses_left = doses_left - 1 where name = ?;";

					PreparedStatement preparedStatementVaccine = connection.prepareStatement(UPDATE_VACCINES_SQL,
							Statement.RETURN_GENERATED_KEYS);


		
					preparedStatementVaccine.setString(1, vaccineName);

					preparedStatementVaccine.executeUpdate();

					ResultSet rsk = preparedStatementVaccine.getGeneratedKeys();
					if (rsk.next())
						id = rsk.getInt(1);
					preparedStatementVaccine.close();
				}
		
			}
			
			String INSERT_VACCINES_SQL = "update patients set second_dose_date = ? where id = ?;";

			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setDate(1, secondDoseDate);
			preparedStatement.setInt(2, patientId);

			preparedStatement.executeUpdate();

			ResultSet rsk = preparedStatement.getGeneratedKeys();
			if (rsk.next())
				id = rsk.getInt(1);
			preparedStatement.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}
	
	
	
	
	public void addUser(UserEntry user) {
		try {
		String sql = "INSERT INTO users (name, username, password, role) VALUES (?, ?, ?, ?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getUsername());
		statement.setString(3, user.getPassword());
		statement.setString(4, user.getRole());
		statement.executeUpdate();
		} catch(SQLException e) {
		e.printStackTrace();
		}
		}
			
			public List<UserEntry> getUserEntries() {
				List<UserEntry> entries = new ArrayList<UserEntry>();
				
				try {
					Statement stmt = connection.createStatement();
					
					ResultSet rs = stmt.executeQuery("select * from users");
					UserEntry entry = null;
					while (rs.next()) {
						int userId = rs.getInt("id");
						String name = rs.getString("name");
						String username = rs.getString("username");
						String password = rs.getString("password");
						String role = rs.getString("role");
						
						// If a new user is encountered, create a new user object
						if (entry == null || entry.getId() != userId) {
							entry = new UserEntry();
							entry.setId(userId);
							entry.setName(name);
							entry.setUsername(username);
							entry.setPassword(password);
							entry.setRole(role);
							entries.add(entry);
						}
					}
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return entries;
			}
			
			public UserEntry getUserEntry(int id) {
				UserEntry entry = new UserEntry();
				try {
					String sql = "select * from users where id = ?";
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setInt(1, id);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						entry.setId(rs.getInt("id"));
						entry.setName(rs.getString("name"));
						entry.setUsername(rs.getString("username"));
						entry.setPassword(rs.getString("password"));
						entry.setRole(rs.getString("role"));
			
					}
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return entry;
			}
			
			public int updateUser(UserEntry user)
					throws ClassNotFoundException {
				int id = 0;
				try {
					
							String INSERT_VACCINES_SQL = "update users set name = ?, password = ? where username = ?;";
							PreparedStatement preparedStatement = connection.prepareStatement(INSERT_VACCINES_SQL,
									Statement.RETURN_GENERATED_KEYS);
							
							preparedStatement.setString(1, user.getName());
							preparedStatement.setString(2, user.getPassword());
							preparedStatement.setString(3, user.getUsername());
							preparedStatement.executeUpdate();
							ResultSet rsk = preparedStatement.getGeneratedKeys();
							if (rsk.next())
								id = rsk.getInt(1);
							preparedStatement.close();
			
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return id;
			}



	
	

}