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

    private String[] questions = new String[3];

    public DB_Connect() {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theDreamers", "root", "");
            //connection to my personal database
            //con = DriverManager.getConnection("jdbc:mysql://hareshvekriyacom.ipagemysql.com/the_dreamers", "hareshvekriyacom", "thedreamers");

            st = con.createStatement();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void getData() {
        try {
            Scanner input = new Scanner( System.in );
            double questionNum = Math.random() * 2 + 1;
            int random = (int) questionNum;
            System.out.println("Please enter the question number out 1-2");
            int squareNum = input.nextInt(); // its random printing from 1-4, input your number here if you want specific row out of 4
//            String query = "SELECT * FROM test";
            String query = "SELECT * FROM theDreamers WHERE id=" + squareNum;
            rs = st.executeQuery(query);
            System.out.println("Records from the database");


            while (rs.next()) {
                String question = rs.getString("Questions");
                String answers = rs.getString("Answers");
                System.out.println("Question: "+question);
                System.out.println("Answer: "+answers);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
