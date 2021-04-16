import javax.sql.RowSet;
import java.sql.*;
public class Conne {
    private boolean repeat=true;
    public void Driver()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("can't find jdbc");
        e.printStackTrace();
        }
        /**
        try{
            Connection connection=  getConnection();
            Statement statement=connection.createStatement();
            ///statement include query
            while (repeat) {
                try (ResultSet resultSet = statement.executeQuery("SELECT *FROM xyz")) {
           int x= resultSet.getInt("x");
           int y= resultSet.getInt("y");
           int z= resultSet.getInt("z");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }**/

    }
    protected static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/con?serverTimezone=UTC";
        // 帳號和密碼
        String user = "root";
        String password = "kk95681932";
        return DriverManager.getConnection(url, user, password);
    }
    }

