import java.util.Formatter;

public class Data {

    public Data() {
//        writeData();
    }

    public void writeData(){
        try
        {
            Formatter output = new Formatter("data.txt");

            DB_Connect connect = new DB_Connect();

            String question = connect.getDataQuestion(1);
            String answer1 = connect.getAnswer1(1);
            String answer2 = connect.getAnswer2(1);
            String answer3 = connect.getAnswer3(1);
            String answer4 = connect.getAnswer4(1);

            connect.closeConnection();

            output.format(question + "," + answer1 + "," + answer2 + "," + answer3 + "," + answer4 + ",");
            output.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
    }

}
