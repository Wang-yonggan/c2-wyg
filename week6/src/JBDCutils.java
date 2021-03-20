import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @ClassName : JBDCutils
 * @Author : wang-yonggan
 * @Date: 2021-03-18 19:51
 */

public class JBDCutils implements JBDCmpl {

    public static String property_file = "druid_config.properties";
    static String url;
    static String username;
    static String password;

    static {
        try {
            //获取配置⽂件的读⼊流
            InputStream inputStream = JBDCutils.class.getClassLoader().getResourceAsStream(property_file);
            Properties properties = new Properties();
            properties.load(inputStream);
            //获取配置⽂件的信息
            String driverClassName = properties.getProperty("driverClassName");
            driverClassName = "com.mysql.cj.jdbc.Driver";
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            //加载驱动
            Class.forName(driverClassName);
        } catch (IOException e) {
            System.out.println("文件流操作失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }
    }

    public static void release(Connection conn) {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }

    public Connection get_connection() {
        try {
            System.out.println(url);
            url = "jdbc:mysql://localhost:3306/db1?serverTimezone=Asia/Shanghai&useUnicode=true&character=utf-8";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private void setPre(PreparedStatement ps, Student s) throws SQLException {
        ps.setString(1, s.getSno());
        ps.setString(2, s.getName());
        ps.setInt(3, s.getAge());
        ps.setString(4, s.getCollege());
    }

    @Override
    public void add(Student s) {
        Connection conn = get_connection();
        try {
            PreparedStatement ps = conn.prepareStatement("insert into students values(?,?,?,?)");
            setPre(ps, s);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            release(conn);
        }
    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public void updata(Student s) {
    }

    @Override
    public void showall() {
    }
}
