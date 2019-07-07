import com.bobo.dao.UserDao;
import com.bobo.dao.impl.UserDaoImpl;
import com.bobo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author tangkb
 * @create 2019-07-06 15:56
 */
public class SqlSessionFactoryTest {

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
    public void findUserById() throws IOException {
        //3、调用dao层处操作数据库
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(1);

        //输出结果
        System.out.println(user);
    }

    @Test
    public void findUserListByName() throws IOException {
        //3、调用dao层处操作数据库
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        List<User> userList = userDao.findUserListByName("张");

        //输出结果
        System.out.println(userList);
    }
}
