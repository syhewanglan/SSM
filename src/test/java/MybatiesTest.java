import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.syhewanglan.ssm.entity.Department;
import com.syhewanglan.ssm.entity.Employee;
import com.syhewanglan.ssm.mapper.DepartmentMapper;
import com.syhewanglan.ssm.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-21 10:43
 **/
public class MybatiesTest {

    SqlSessionFactory sessionFactory = null;

    @Before
    public void createFactory() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(is);
    }

    @Test
    public void m1() throws IOException {
//        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
//        final SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession session = sessionFactory.openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);

        List<Department> list = mapper.selectAllDepts();

        for (Department d : list) {
            System.out.println(d);
        }
        session.close();
    }

    @Test
    public void m2() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<Employee> list = mapper.selectAllEmps();

        for (Employee e : list) {
            System.out.println(e);
        }
        session.close();
    }

    @Test
    public void m3() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee employee = mapper.selectByEid(1001);
        System.out.println(employee);
        session.close();
    }

    @Test
    public void m4() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee e = new Employee();
        e.setEmpId(1001);
        e.setEmpName("钟卓辉");
        e.setGender("M");
        e.setEmail("13123@gmail.com");
        e.setDeptId(3);

        Integer result = mapper.updateEmployee(e);
        System.out.println(result);

        session.close();
    }

    @Test
    public void m5() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Employee e = new Employee();
        e.setEmpId(1501);
        e.setEmpName("钟卓辉");
        e.setGender("M");
        e.setEmail("13123@gmail.com");
        e.setDeptId(3);

        Integer result = mapper.saveEmployee(e);
        System.out.println(result);
        session.commit();
        session.close();
    }

    @Test
    public void m6() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        Integer result = mapper.deleteByEid(1001);

        System.out.println(result);
//        session.commit();
        session.close();
    }

    @Test
    public void m7() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        PageHelper.startPage(2,10);
        List<Employee> list = mapper.selectAllEmps();
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo);

        session.close();
    }

    @Test
    public void m8() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

//        List<Employee> result = mapper.selectByName("张三");
//        Employee result = mapper.selectByEid(1001);
//        System.out.println(result);
//        session.commit();
        session.close();
    }

    @Test
    public void m9() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        List<Employee> result = mapper.search("张", 1);
        System.out.println(result);
//        session.commit();
        session.close();
    }

    @Test
    public void m10() {
        SqlSession session = sessionFactory.openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        String[] data = {"982","983"};
        Integer result = mapper.deleteAll(data);
        System.out.println(result);
//        session.commit();
        session.close();
    }

}
