import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    public static void main(String[] args){

        ApplicationContext context =new ClassPathXmlApplicationContext(
                new String[]{"classpath:spring/applicationcontext-base.xml","classpath:spring/applicationcontext-database.xml"});

        context.getBean("IUserDao");
        //context.getBean("userServiceImpl");
        //  String s =  userService.getTest();
        //System.out.println(userDao);
    }
}
