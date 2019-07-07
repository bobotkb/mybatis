package com.bobo.entity;

/**
 * 部门实体
 * @author tangkb
 * @create 2019-07-07 10:08
 */
public class Dept {
    /**
     * 部门编号
     */
    private Integer deptno;
    /**
     * 部门名称
     */
    private String dname;
    /**
     * 部门所属区域名称
     */
    private String loc;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
