import com.bobo.entity.Dept;
import com.bobo.mapper.DeptMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author tangkb
 * @create 2019-07-07 11:19
 */
public class DeptMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        //1.加载数据库配置文件
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2.通过SqlSessionFactoryBuild()类的build()方法，创建SqlSessionFactory会话工厂
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectDeptByDeptno() {
        //3.使用会话工厂开启SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.使用mapper代理方式获取代理接口
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);

        //5.调用接口操作数据库
        Dept dept = deptMapper.selectDeptByDeptno(10);

        //6.输出结果
        System.out.println(dept);

        //7.关闭会话
        sqlSession.close();
    }
}