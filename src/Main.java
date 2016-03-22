
public class Main {

    public static void main(String[] args) {

        Data data = new Data();
        GUI gui = new GUI();

        /*Testing Database*/

        DB_Connect connect = new DB_Connect();
        //connect.deleteData();
        connect.writeData();
        System.out.println(connect.getAnswer1(1));

    }

}
