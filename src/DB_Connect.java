import java.sql.*; // imports all the sql classes

public class DB_Connect {

    //variables that will help to connect to DB
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private final String query = "SELECT * FROM theDreamers WHERE id=";
    private String answer1 = "", answer2 = "", answer3 = "", answer4 = "";


    public DB_Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theDreamersMain", "root", "");
            //connection to my personal database
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public String getDataQuestion(int number) {
        String question = "";
        try {
            rs = st.executeQuery(query + number);

            while (rs.next())
                question = rs.getString("Question");

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return question;
    }

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer1(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer1 = rs.getString("Answer1"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer1;
    }

    public String getAnswer2(int number){
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer2 = rs.getString("Answer2"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer2;
    }
    public String getAnswer3(int number){
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer3 = rs.getString("Answer3"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer3;
    }
    public String getAnswer4(int number){
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer4 = rs.getString("Answer4"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer4;
    }

}
