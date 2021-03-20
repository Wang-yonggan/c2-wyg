import java.sql.Connection;

/**
 * @ClassName : Student
 * @Author : wang-yonggan
 * @Date: 2021-03-18 22:29
 */

public class Student {
    private String sno;
    private String name;
    private Integer age;
    private String college;

    public Student() {

    }

    public Student(String sno, String name, Integer age, String college) {
        this.sno = sno;
        this.name = name;
        this.age = age;
        this.college = college;
    }

    public static void main(String[] args) {
        JBDCutils jbdCutils = new JBDCutils();
        Connection conn = jbdCutils.get_connection();

    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", college='" + college + '\'' +
                '}';
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


}
