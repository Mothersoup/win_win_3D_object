import com.sun.j3d.utils.applet.MainFrame;
import com.sun.tools.javac.Main;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class Combin {
    String sql="Select  x,y,z From xyz;";
    boolean repeat=true;
public Combin()
{
    try{
        ///int change=15;
        Connection connection=Conne.getConnection();
        Statement statement=connection.createStatement();
        while (repeat){
ResultSet resultSet=statement.executeQuery(
        sql);
while (resultSet.next()) {
    int x = resultSet.getInt("x");
    int y = resultSet.getInt("y");
    int z = resultSet.getInt("z");
   /// change=change+5;

   MainFrame use= new MainFrame(new MoudleObjectApp(MoudleObjectApp.createBranch(x+270, y, z+90)), 1500, 1500);
    ///TimeUnit.SECONDS.sleep(100)
    Thread.sleep(450);
   use.dispose();


}
        }
    } catch (SQLException | InterruptedException e) {
        e.printStackTrace();
    }
}

private int abs(int x)
{
    return x%360;
}
}
