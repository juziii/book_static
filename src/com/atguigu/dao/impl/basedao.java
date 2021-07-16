package com.atguigu.dao.impl;

import com.atguigu.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

public class basedao {
    private QueryRunner queryRunner=new QueryRunner();
    public int update(String sql,Object ... args){
        Connection conn= JdbcUtils.getConnection();
        try{return queryRunner.update(conn,sql,args);}catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return -1;

    }
    public <T> T queryForOne(Class<T> type,String sql,Object ... args){
        Connection conn= JdbcUtils.getConnection();
        try{return queryRunner.query(conn,sql,new BeanHandler<T>(type),args);}catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;

    }
    public <T> List<T> queryForList(Class<T> type, String sql, Object ... args){
        Connection conn= JdbcUtils.getConnection();
        try{return queryRunner.query(conn,sql,new BeanListHandler<T>(type),args);}catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;

    }
    public Object queryForSingleValue(String sql, Object ... args){
        Connection conn= JdbcUtils.getConnection();
        try{return queryRunner.query(conn,sql,new ScalarHandler(),args);}catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.close(conn);
        }
        return null;

    }

}
