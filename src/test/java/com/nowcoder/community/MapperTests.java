package com.nowcoder.community;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    //@Autowired注解：把我们写的mapper注入进来
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectUser()
    {
        User user = userMapper.selectById(11);
        System.out.println(user);

        user = userMapper.selectByName("nowcoder11");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser()
    {
        User user = new User();
        user.setUsername("zly");
        user.setPassword("123456");
        user.setEmail("rafazly@163.com");
        user.setSalt("abc");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser()
    {
        int rows = userMapper.updateStatus(150,1);
        System.out.println(rows);
        rows = userMapper.updateHeader(150,"http://www.nowcoder.com/102.png");
        System.out.println(rows);
        rows = userMapper.updatePassword(150,"mydream_473944");
        System.out.println(rows);
    }

    @Test
    public void testSelectPosts()
    {
        List<DiscussPost> list =  discussPostMapper.selectDiscussPosts(149,0,10);
        Iterator<DiscussPost> it = list.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }
}
