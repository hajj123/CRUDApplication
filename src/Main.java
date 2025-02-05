import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

        public static void main (String[]args ) throws Exception {
            //We load the postgresql16 driver
            Class.forName("org.postgresql.Driver");
            //We build the connection url and connect
            Connection cx = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/mydatabase"
                    ,
                    "postgres"
                    ,
                    "Str@ngeL@m@123");
            //We create a statement for the select
            Statement st = cx.createStatement();
            //We put the result of the select statement in a result set
            ResultSet rs = st.executeQuery("SELECT * FROM personnes");
            //We iterate as long as their are rows in the result set
            while (rs.next()) {
                //We fetch name
                String nom = rs.getString("nom");
                //We fetch age
                int age = rs.getInt("age");
                //We output them
                System.out.println(nom + " a " + age + " ans");
            }
            //We close the result set
            rs.close();
            //We close statement
            st.close();
            //We close the connection
            cx.close();


        }


}