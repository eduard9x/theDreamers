import java.sql.*; // imports all the sql classes

public class DB_Connect {

    //variables that will help to connect to DB
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private final String query = "SELECT * FROM theDreamersTable WHERE id=";
    private String answer1 = "", answer2 = "", answer3 = "", answer4 = "";


    public DB_Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/theDreamersDatabase", "root", "");
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

    public String getSubject(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer1 = rs.getString("Subject"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer1;
    }

    public String getAnswer2(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer2 = rs.getString("Answer2"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer2;
    }

    public String getAnswer3(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer3 = rs.getString("Answer3"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer3;
    }

    public String getAnswer4(int number) {
        try {
            rs = st.executeQuery(query + number);
            while (rs.next())
                answer4 = rs.getString("Answer4"); // Always the right answer

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return answer4;
    }

    public void deleteData() {
        try {
            String sql = "DELETE  FROM  theDreamersTable ";
            st.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // DB WRITE
    public void writeData() {
        try {
            //("INSERT INTO theDreamers " + "VALUES (id, 'Question', 'Answer1(Correct)', 'Answer2', 'Answer3', 'Answer4', 'Subject')");
            // Q //
            /* 1 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (1, 'Solve (11-5)*(63-59+6)/12', '5', '7', '8', '10', 'Maths')");
            /* 2 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (2, 'Find the HCF(Highest Common Factor) and LCM(Lowest Common " +
                    "Multiple) of the following pair of numbers: 120,336', '24 and 1680', '16 and 1820', '2 and 203', '23 and 1680', 'Maths')");
            /* 3 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (3, 'Convert to the decimal form to 4 decimal places: -6/13'," +
                    " '-0.4615', '-0.3615', '-0.9615', '-0.2615', 'Maths')");
            /* 4 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (4, 'Complete the square: x2 - 12x + 18'," +
                    " '(x-6)2 - 18', '(y-6)2 - 18', '(x-3)5 - 16', '(x-4)3 - 12', 'Maths')");
            /* 5 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (5, 'Find the sum of the roots of quadratic equation: x2 - 15x + 2.5 = 0', " +
                    "'15', '17', '19', '10', 'Maths')");
            /* 6 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (6, 'Solve by factor method: x2+11x+18=0', " +
                    "'x=−2 and x=−9', 'x=−3 and x=−6', 'x=−5 and x=−10', 'x=−7 and x=−11', 'Maths')");
            /* 7 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (7, 'Solve using factor method: 5x2−26x+24=0', " +
                    "'x=6, x=224', 'x=3, x=213', 'x=2, x=124', 'x=8, x=367', 'Maths')");
            /* 8 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (8, 'Solve (11-5)*(63-59+6)/12', " +
                    "'5', '7', '8', '10', 'Maths')");
            /* 8 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (9, 'Find the gradient of a straight line with the points P(5,3) and Q(8,12).', " +
                    "'3', '7', '8', '10', 'Maths')");
            /* 10 */
            st.executeUpdate("INSERT INTO theDreamersTable " + "VALUES (10, 'Find the factors of 2x3+7x2−5x−4', " +
                    "'5', '7', '8', '10', 'Maths')");

            System.out.println("Data inserted into the database!!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // create a Statement from the connection

// insert the data

    public int getRowCount(){
        int count = 0;
        try{
            Statement s = con.createStatement();
            ResultSet r = s.executeQuery("SELECT COUNT(*) AS rowcount FROM theDreamersTable");
            r.next();
            count = r.getInt("rowcount");
            r.close();
            System.out.println("MyTable has " + count + " row(s).");
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return count;
    }


}
