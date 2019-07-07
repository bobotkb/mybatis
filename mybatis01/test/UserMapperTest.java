import com.bobo.mapper.UserMapper;
import com.bobo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author tangkb
 * @create 2019-07-06 16:59
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        //1、读取配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2、根据配置文件创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserById() {
        //创建会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建userMapper代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = userMapper.findUserById(2);

        //输出结果
        System.out.println(user);

        //关闭会话
        sqlSession.close();
    }

    @Test
    public void findUserListByName() {
    }

    @Test
    public void addUser() {
    }
}