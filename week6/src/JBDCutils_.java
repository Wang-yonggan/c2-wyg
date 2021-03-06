import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.sql.*;
import java.util.Properties;

/**
 * @ClassName : JBDCutils_
 * @Author : wang-yonggan
 * @Date: 2021-03-18 19:51
 */

public class JBDCutils_ implements JBDCmpl {

    public static String property_file = "druid.properties";
    static String url;
    static String username;
    static String password;
    static Connection conn = null;

    static {
        try {
            //获取配置⽂件的读⼊流
            InputStream inputStream = JBDCutils_.class.getClassLoader().getResourceAsStream(property_file);
            Properties properties = new Properties();
            properties.load(inputStream);
            //获取配置⽂件的信息
            String driverClassName = properties.getProperty("driverClassName");
            driverClassName = "com.mysql.jdbc.Driver";
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            //加载驱动
            Class.forName(driverClassName);


            //方法二
            Properties properties2 = new Properties();
            String propertyFile = JBDCutils_.class.getResource(property_file).getPath();
            propertyFile = new URLDecoder().decode(propertyFile, "UTF-8");
            properties2.load(JBDCutils_.class.getClassLoader().getResourceAsStream(property_file));
            DataSource data = DruidDataSourceFactory.createDataSource(properties2);
            conn = data.getConnection();
            System.out.println("连接成功");
        } catch (IOException e) {
            System.out.println("文件流操作失败");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
            e.printStackTrace();
        } catch (Exception e) {
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

    public static void printRs(ResultSet rs) throws SQLException {
        while (rs.next()) {
            String sno = rs.getString("sno");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String college = rs.getString("college");
            System.out.println(sno + "\t" + name + "\t\t" + age + "\t\t" + college);
        }
    }

    public static void showall1() {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from students");
            ResultSet rs = ps.executeQuery();
            printRs(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) {
        showall1();
    }

    @Override
    public void showall() {
        try {
            PreparedStatement ps = conn.prepareStatement("select * from students");
            ResultSet rs = ps.executeQuery();
            printRs(rs);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
