import com.bobo.dao.DeptDao;
import com.bobo.dao.impl.DeptDaoImpl;
import com.bobo.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author tangkb
 * @create 2019-07-07 10:48
 */
public class DeptDaoTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        //1.加载数据库配置文件
        String resource = "SqlMapConfig";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2.通过SqlSessionFactoryBuild()类的build()方法，创建SqlSessionFactory会话工厂
        this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void selectDeptByDeptno() throws IOException {
        DeptDao deptDao = new DeptDaoImpl();
        Dept dept = deptDao.selectDeptByDeptno(10);
        System.out.println(dept);
    }
}