package my.test;

import com.entity.User;
import com.init.SqlSessionUtils;
import com.mapper.UserMapper;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liu peng bo
 * @date 2018/8/29
 */
@Slf4j
public class TestBase {
    public static void main(String[] args) {

        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //List<User> list = userMapper.findByName("张");

        //userMapper.save(user);
        //userMapper.multipleSave(list);
        //User result = userMapper.getById("3");
        List resultList;
        resultList= userMapper.findByName("张三");
        //resultList = userMapper.findAll2();
        //resultList= userMapper.findAll();
        sqlSession.commit();
        resultList.forEach(
                l -> {
                    System.out.println(l.toString());
                }
        );
        /*List<User> list = new ArrayList<>();
        User user = new User();
        user.setCode("126");
        user.setName("126");
        list.add(user);
        User user2 = new User();
        user2.setCode("127");
        user2.setName("127");
        list.add(user2);
        userMapper.multipleSave(list);
        //userMapper.save(user);
        sqlSession.commit();
        System.out.println(user.toString());
        System.out.println(user2.toString());*/
    }
}
