import com.takeaway.mapper.MemberMapper;
import com.takeaway.service.MemberService;
import com.takeaway.service.MemberServiceImpl;
import com.takeaway.util.BASE64;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class Test1 {


    //测试数据库连接
    @Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        SqlSessionFactory sqlFaction = (SqlSessionFactory)applicationContext.getBean("sqlFaction");
        System.out.println(sqlFaction.openSession() == null);
    }



    //测试Member数据接口是否正常读取数据
    @Test
    public void test2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        MemberMapper productMapper = (MemberMapper)applicationContext.getBean("memberMapper");
        System.out.println(productMapper.queryById(1,"111111"));
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",1);
        map.put("password",555555);
        System.out.println(productMapper.updateMember(map));
        map.clear();
        map.put("email","2222222@qq.com");
        map.put("nick","adfadfasd10");
        map.put("password","100000000");
        System.out.println(productMapper.signinMember(map));
    }



    //测试Service调用情况
    @Test
    public void test3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-server.xml");
        MemberServiceImpl memberServiceImple = (MemberServiceImpl)applicationContext.getBean("memberServiceImpl");
        System.out.println(memberServiceImple.queryById(1, "555555"));
    }

    //加密密码
    @Test
    public void test4(){
        String password = "qzl200919yya";
        String encode = BASE64.encode(password);
        System.out.println(encode);
        String decode = BASE64.decode(encode);
        System.out.println(decode);
    }
}
