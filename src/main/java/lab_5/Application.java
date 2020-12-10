package lab_5;


import lab_5.view.View;
import org.hibernate.Session;


public class Application {


    public static void main(String[] args) {

        System.err.close();
        System.setErr(System.out);
        try (Session SESSION = DatabaseConnector.getSession()) {
            System.out.println("Test session established. ");
            new View().show();
        } catch (Throwable ex) {
            System.err.println("Test session failed.");
            ex.printStackTrace();
        }
    }
}
