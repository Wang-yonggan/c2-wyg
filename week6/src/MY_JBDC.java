//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.sql.*;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * @ClassName : MY_JBDC
// * @Author : wang-yonggan
// * @Date: 2021-03-17 19:29
// */
//
//public class MY_JBDC {
//    public static void insertBytxt(Connection conn, String path) {
//        try {
//            String sql = "insert into students value(?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            List<String> all_lines = Files.readAllLines(Paths.get(path));
//            for (String line : all_lines) {
//                line = line.substring(1, line.length() - 1);//去除小括号
//                String columns[] = line.split(",");
//                String sno = columns[0].substring(1, columns[0].length() - 1);
//                String name = columns[1].substring(1, columns[1].length() - 1);
//                int age = Integer.valueOf(columns[2]);
//                String college = columns[3].substring(1, columns[3].length() - 1);
//                insert(ps, sno, name, age, college);
//            }
//            conn.commit();
//            System.out.println("插入成功");
//        } catch (IOException e) {
//            System.out.println("未找到文件");
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            try {
//                if (conn == null && !conn.isClosed())
//                    conn.rollback();
//                System.out.println("插入失败");
//                throwables.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        } finally {
//            //close(conn);
//        }
//    }
//
//    public static void insert(PreparedStatement ps, String sno, String name, int age, String college) throws SQLException {
//        /*
//        只负责插入一条进入ps，而不负责commit,所以最终插入几条还是外面决定
//         */
//        ps.setString(1, sno);
//        ps.setString(2, name);
//        ps.setInt(3, age);
//        ps.setString(4, college);
//        //ps.addBatch();//批处理
//        ps.executeUpdate();
//
//    }
//
//    public static void insertByhand(Connection conn) {
//        String sql_insert = "insert into students values(?,?,?,?)";
//        Scanner sc = new Scanner(System.in);
//        String YN = "Y";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql_insert);
//            while (YN.equals("Y") || YN.equals("y")) {
//                System.out.print("请输入学号:");
//                String sno = sc.next();
//                System.out.print("请输入姓名:");
//                String name = sc.next();
//                System.out.print("请输入年龄:");
//                int age = sc.nextInt();
//                System.out.print("请输入学院:");
//                String college = sc.next();
//                insert(ps, sno, name, age, college);
//                conn.commit();
//                System.out.print("是否继续插入(y/n)");
//                YN = sc.next();
//            }
//        } catch (SQLException throwables) {
//            try {
//                if (conn == null && !conn.isClosed())
//                    conn.rollback();
//                System.out.println("插入失败");
//                throwables.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("操作结束");
//    }
//
//    public static void close(Connection conn) {
//        //发现此函数不会发生作用
//        try {
//            if (conn == null && !conn.isClosed())
//                conn.close();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//    }
//
//    public static void showAll(Connection conn) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("select * from students");
//            ResultSet rs = ps.executeQuery();
//            print___("showAll");
//            System.out.println("sno\t\t name\t age\t\t college");
//            while (rs.next()) {
//                String sno = rs.getString("sno");
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String college = rs.getString("college");
//                System.out.println(sno + "\t" + name + "\t\t" + age + "\t\t" + college);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            // close(conn);
//        }
//
//    }
//
//    public static void deleteAll(Connection conn) {
//        try {
//            Statement st = conn.createStatement();
//            st.executeUpdate("delete from students");
//            System.out.println("删除成功");
//        } catch (SQLException throwables) {
//            System.out.println("删除失败");
//        }
//    }
//
//    public static void print___(String msg) {
//        System.out.println("----------------" + msg + "------------------");
//    }
//
//    public static void showBysno(Connection conn, String sno) {
//        try {
//
//            PreparedStatement ps = conn.prepareStatement("select * from students where sno=?");
//            ps.setString(1, sno);
//            ResultSet rs = ps.executeQuery();
//            print___("showBysno=" + sno);
//            System.out.println("sno\t\t name\t age\t\t college");
//            while (rs.next()) {
//                String name = rs.getString("name");
//                int age = rs.getInt("age");
//                String college = rs.getString("college");
//                System.out.println(sno + "\t" + name + "\t\t" + age + "\t\t" + college);
//            }
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            close(conn);
//        }
//
//    }
//
//    public static void deleteBysno(Connection conn, String sno) {
//        String sql = "delete from students where sno=?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, sno);
//            int cnt = ps.executeUpdate();
//            if (cnt >= 1)
//                System.out.println("成功删除学号为" + sno + "的学生");
//            else System.out.println("删除失败:未找到sno为" + sno + "的学生");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }
//
//    public static void updateBysno(Connection conn, String old_sno, String new_sno, String name, int age, String college) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("update students set sno=?,name=?,age=?,college=? where sno=?");
//            ps.setString(1, new_sno);
//            ps.setString(2, name);
//            ps.setInt(3, age);
//            ps.setString(4, college);
//            ps.setString(5, old_sno);
//            ps.executeUpdate();
//            System.out.print("修改成功");
//            showBysno(conn, new_sno);
//        } catch (SQLException throwables) {
//            System.out.println("修改失败");
//            throwables.printStackTrace();
//        }
//
//    }
//
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        // create table students(sno  Varchar(20),name varchar(10),age integer, college varchar(30));
//        String dbDriver = "com.mysql.jdbc.Driver";
//        String dbURL = "jdbc:mysql://localhost:3306/db1?serverTimezone=Asia/Shanghai&useUnicode=true&character=utf-8";
//        String user = "root";
//        String password = "154666";
//        Class.forName(dbDriver);
//        Connection conn = DriverManager.getConnection(dbURL, user, password);
//        try {
//            conn.setAutoCommit(false);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//        deleteBysno(conn, "s004"); //删除 s004
//        deleteAll(conn);  //删除所所有
//        showAll(conn);  //显示所有
//        System.out.println();
//        String path = System.getProperty("user.dir") + "/week6/src/data.txt";
//        insertBytxt(conn, path); //  插入data.txt中的数据
//        showAll(conn);
//        showBysno(conn, "s003");
//        updateBysno(conn, "s001", "s001", "老大", 20, "通信学院");
//    }
//}
//
//
//
//
///*
//错误1：nextLine 会因为上一次的回车而输入失败
//错误2：str最好使用equal进行判断
//错误3：foreach需要自己解决异常
//错误4：项目路径：system.getProperty("user.dir")---->  +"/"
//错误5：命名为driverClassName
//
//
// */