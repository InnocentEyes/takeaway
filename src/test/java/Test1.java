import com.takeaway.mapper.ProductMapper;
import com.takeaway.pojo.Product;
import com.takeaway.server.ProductServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {


    //测试数据库连接
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionFactory sqlFaction = (SqlSessionFactory)applicationContext.getBean("sqlFaction");
        System.out.println(sqlFaction.openSession() == null);
    }




    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        ProductMapper productMapper = (ProductMapper)applicationContext.getBean("productMapper");
        System.out.println(productMapper.queryAll());
    }
}
