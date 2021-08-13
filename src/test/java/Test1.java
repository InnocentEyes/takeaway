import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {



    //测试数据库连接
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionFactory sqlFaction = (SqlSessionFactory)applicationContext.getBean("sqlFaction");
        System.out.println(sqlFaction == null);
    }
}
