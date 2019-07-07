import com.bobo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author tangkb
 * @create 2019-07-06 13:00
 */
public class MybatisFirst {

    @Test
    public void findUserByIdTest() throws IOException {
        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4、SqlSession执行statement，并返回映射结果
        //第一个参数：statement的id，建议：namespace.statementId（确保唯一）
        //第二个参数：入参的值，它的类型要和映射文件中对应的statement的入参类型一致
        User user = sqlSession.selectOne("test.findUserById", 1);

        //打印输出结果集
        System.out.println(user);

        //5、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void findUserByNameTest() throws IOException {
        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4、SqlSession执行statement，并返回映射结果
        //第一个参数：statement的id，建议：namespace.statementId（确保唯一）
        //第二个参数：入参的值，它的类型要和映射文件中对应的statement的入参类型一致
        List<User> userList = sqlSession.selectList("test.findUserByName", "张");

        //打印输出结果集
        System.out.println(userList);

        //5、关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void addUserTest() throws IOException, ParseException {
        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2、根据配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3、SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4、SqlSession执行statement，并返回映射结果
        User user = new User();
        user.setUsername("方一勺");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = simpleDateFormat.parse("1998-05-05");
        user.setBirthday(birth);
        user.setAddress("东巷府");
        user.setSex("2");
        int insert = sqlSession.insert("test.addUser", user);

        //5.提交事务
        sqlSession.commit();

        //打印输出结果集
        System.out.println("成功插入" + insert + "条数据" + ",该条数据的主键是" + user.getId());

        //5、关闭SqlSession
        sqlSession.close();
    }
}
