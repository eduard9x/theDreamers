import java.util.Formatter;

public class Data {

    public Data() {
        writeData();
    }

    public void writeData(){
        int count ;
        String question, answer1, answer2, answer3, answer4, subject;
        StringBuilder builder = new StringBuilder();

        try
        {
            Formatter output = new Formatter("databaseLocalFile.txt");

            databaseManager connect = new databaseManager();
            // delete the previous data
            connect.deleteData();
            // write the new data
            connect.writeData();
            // get the row count
            count = connect.getRowCount();

            //get all questions and answers inside a string in order to save it inside a text file
            for(int i=1;i<=count;i++){
                 question = connect.getDataQuestion(i);
                 answer1 = connect.getAnswer1(i);
                 answer2 = connect.getAnswer2(i);
                 answer3 = connect.getAnswer3(i);
                 answer4 = connect.getAnswer4(i);
                 subject = connect.getSubject(i);

                builder.append(question + ";;;" + answer1 + ";;;" + answer2 + ";;;" + answer3 + ";;;" + answer4 + ";;;" + subject + ";;;");
            }

            connect.closeConnection();

            output.format(builder.toString());
            output.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
    }

}
