import com.qin.isys.modules.user.web.UserController;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * simple test.
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
        String configLocation= "spring/spring-application.xml";
        String beanName="test";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(configLocation);
        Object o=applicationContext.getBean(beanName);
        System.out.println(o.getClass());
    }

    @Test
    public void testStringBuffer(){
        StringBuffer stringBuffer=new StringBuffer("一骑红尘妃子笑，无人知是荔枝来。");
        System.out.println(stringBuffer.substring(1,2));
    }

    @Test
    public void test1223131231(){
    }
}
