import java.sql.*;

public class PostgreSQLJDBCConnection {

    private Connection conn;
    private static final String url = "jdbc:postgresql://localhost:5432/Assignment3";
    private static final String user = "postgres";
    private static final String password = "azur@2011";

    public PostgreSQLJDBCConnection() {
      try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);

            if(conn != null) {
                System.out.println("SUCCESS");


            updateStudentEmail(4, "ilyaashussein@cmail.carleton.ca");

            addStudent("Ilyaas",
                        "Hussein",
                        "jane@123.com",
                        new Date(2024-1900, 2, 19));
              deleteStudent(1);

                getAllStudents();
            } else {
                System.out.println("Unsuccessful Connection. :(");
            }

            assert conn != null;
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
            System.exit(1);
        }
    }
    public void getAllStudents() {
        try {
            Statement stmt = conn.createStatement();
            String SQL = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String enrollment_date = String.valueOf(rs.getDate("enrollment_date"));

                System.out.printf("Name: %s %s - Email: %s - Enrollment: %s\n", first_name, last_name, email, enrollment_date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent(String fName, String lName, String email, Date date) {

        String insertSQL = "INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES (?, ?, ?, ?)";
        try{
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, fName);
                pstmt.setString(2, lName);
                pstmt.setString(3, email);
                pstmt.setDate(4, date);
                pstmt.executeUpdate();
                System.out.println("A new student was inserted successfully!");
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudentEmail(int student_id, String new_email) {
        String SQL = "UPDATE students SET email = ? WHERE student_id = ? ";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int student_id) {
        String SQL = "DELETE FROM students WHERE student_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, student_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        PostgreSQLJDBCConnection p = new PostgreSQLJDBCConnection();
    }

}
