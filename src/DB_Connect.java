import java.sql.*; // imports all the sql classes

/**
 * Created by Harvey on 22/02/2016.
 */
public class DB_Connect {

    //variables that will help to connect to DB
    private Connection con;
    private Statement st;
    private ResultSet rs;

    private String[] questions = new String[3];

    public DB_Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theDreamers", "root", "");
            st = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void getData() {
        try {
            double questionNum = Math.random() * 4 + 1;
            int random = (int) questionNum;
            int squareNum = random; // its random printing from 1-4, input your number here if you want specific row out of 4
//            String query = "SELECT * FROM test";
            String query = "SELECT * FROM test WHERE QNumber=" + squareNum;
            rs = st.executeQuery(query);
            System.out.println("Records from the database");


            while (rs.next()) {
                String question = rs.getString("Questions");
                String answers = rs.getString("Answers");
                System.out.println(question + " " + answers);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
