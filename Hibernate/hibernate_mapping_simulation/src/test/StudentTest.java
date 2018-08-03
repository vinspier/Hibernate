package test;

import com.fxb.model.Session;
import com.fxb.model.Student;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public class StudentTest {
    public static void main(String[] args) throws Exception{
        Student student = new Student();
        student.setId(10);
        student.setName("fxb");
        student.setAge(22);

        Session session = new Session();
        session.save(student);
    }

}
