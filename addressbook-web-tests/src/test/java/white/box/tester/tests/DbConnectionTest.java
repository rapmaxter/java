package white.box.tester.tests;

import org.eclipse.jetty.io.Connection;
import org.testng.annotations.Test;
import white.box.tester.model.GroupData;
import white.box.tester.model.Groups;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Max on 10/21/2016.
 */
public class DbConnectionTest {

  @Test
  public void testDbConnection() {
    java.sql.Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
      Statement st = conn.createStatement(); // начинаем извлекать инфу из БД
      ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");// создаем запрос на языке SQL
      Groups groups = new Groups();
      while (rs.next()) {
        groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                .withHeader(rs.getString("group_header")).withFooter(rs.getString("group_footer")));
      }
      rs.close();
      st.close();
      conn.close();

      System.out.println(groups);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
}