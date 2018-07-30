import com.zxl.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations = { "classpath*:/spring/applicationcontext-base.xml", "classpath*:/spring/applicationcontext-database.xml", "classpath*:/spring/springmvc-context.xml" })
public class myTest {

    @Resource
    private IUserService userService;
    @Test
    public void tt(){
          //userService.getTest();
    }
}
