package database;

import com.mysql.cj.Session;
import control.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.IOException;
import java.io.InputStream;


public class MyBatisConnection {
    private static InputStream inputStream;
    private static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();
    static {
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public MyBatisConnection() {
    }

    private static SqlSession getSqlSession(boolean commit){
        SqlSession session = sqlSessionThreadLocal.get();

        if( null == session ){
            if (commit){
                session = sqlSessionFactory.openSession(true);
            }else{
                session = sqlSessionFactory.openSession(false);
            }

            sqlSessionThreadLocal.set(session);
        }

        return session;
    }

    public static EmployeeMapper getEmployeeMapper(boolean commit)  {
        SqlSession session = getSqlSession(commit);

        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);

        return employeeMapper;
    }


    public static void closeSqlSession() {
        SqlSession session = sqlSessionThreadLocal.get();
        if( null != session ) {
            session.close();
        }
        sqlSessionThreadLocal.remove();
    }

}
