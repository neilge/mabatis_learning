import com.neilge.dao.UserDao;
import com.neilge.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author Neo
 * @since 09/26/2020-12:25 PM
 */
public class MybatisTest {

    public static void main(String[] args) throws Exception {
        // 1. 读取配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2. 创建SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        // 3. 使用Factory生产SqlSession对象
        SqlSession session = factory.openSession();
        // 4. 使用SqlSession创建Dao代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        // 5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        // 6. 释放资源
        session.close();
        stream.close();
    }
}
