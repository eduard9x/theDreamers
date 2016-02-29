import java.sql.*; // imports all the sql classes
import java.util.Scanner;

/**
 * Created by Harvey on 22/02/2016.
 */
public class DB_Connect {

    //variables that will help to connect to DB
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private final String query = "SELECT * FROM theDreamers WHERE id=";

    private String[] questions = new String[3];

    public DB_Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theDreamers2", "root", "");
            //connection to my personal database
            //con = DriverManager.getConnection("jdbc:mysql://hareshvekriyacom.ipagemysql.com/the_dreamers", "hareshvekriyacom", "thedreamers");

            st = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public String getDataQuestion(int number) {
        String question = "";
        try {
            rs = st.executeQuery(query+number);

            while (rs.next())
                question = rs.getString("Questions");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return question;
    }

    public String getDataAnswer(int number) {
        String answer = "";
        try {

            rs = st.executeQuery(query+number);

            while (rs.next())
                answer = rs.getString("Answers");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return answer;
    }

}
