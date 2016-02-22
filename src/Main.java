
public class Main {

    public static void main(String[] args) {
        //javax.swing.SwingUtilities.invokeLater(new Runnable(){
        //public void run(){
        // data base class
        DB_Connect connect = new DB_Connect();
        connect.getData();

        GUI gui = new GUI();

    }
    //});
    //}
}
