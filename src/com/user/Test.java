package com.user;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {

    public static void main(String[] args) throws IOException {
        String resource = "mybatisConfig.xml";
        InputStream res = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(res);
        SqlSession session = factory.openSession();
        String statement = "com.user.UserMapper.getUserById";
        User user = session.selectOne(statement, 1);
        //System.out.println(user.toString());
    }
}
