import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Q on 2017/2/5.
 */
public class BasicTest {
    @Test
    public void printTest(){
        System.out.println("test print success.");
    }

    @Test
    public void integerTest(){
        Integer a=128,b=128;
        System.out.println(a==b);
        Integer c=-128,d=-128;
        System.out.println(c==d);
    }

    @Test
    public void springTest(){
        String configLocation="spring/spring-application.xml";
        String beanName="test";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
        Object o=applicationContext.getBean(beanName);
        System.out.println(o.getClass());
    }

    @Test
    public void baseJavaSpringTest(){
        String configLocation="spring/springBaseJava.xml";
        String beanName="person";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
        Object o=applicationContext.getBean(beanName);
        System.out.println(o.getClass());
    }
}
