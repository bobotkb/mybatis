package com.bobo.dao.impl;

import com.bobo.dao.DeptDao;
import com.bobo.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 部门操作接口实现类
 * @author tangkb
 * @create 2019-07-07 10:29
 */
public class DeptDaoImpl implements DeptDao {
    /**
     * 通过部门编号查询部门信息方法实现
     * @param deptno
     * @return
     */
    @Override
    public Dept selectDeptByDeptno(Integer deptno) throws IOException {
        //1.采用输入流的方式，加载mybatis全局配置文件
        String resource = "SqlMapConfig.xml";
        //使用资源文件加载器，通过文件名称得到文件的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //2.使用SqlSessionFactoryBuild类的build方法创建SQLSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3.使用SqlSessionFactory打开SqlSession会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.使用sqlSession操作数据库
        Dept dept = sqlSession.selectOne("test.findDeptByDeptno", deptno);

        //5.关闭会话
        sqlSession.close();

        return dept;
    }
}
