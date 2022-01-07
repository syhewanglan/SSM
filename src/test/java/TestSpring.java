import com.syhewanglan.ssm.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: SSM
 * @author: syhewanglan
 * @create: 2021-12-20 18:27
 **/
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSpring {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void m1(){
        System.out.println(employeeService == null);
        System.out.println(employeeService);
    }
}
