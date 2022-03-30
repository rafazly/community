package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


//Mapper标记注解之后才可以被容器扫描这个接口，才可以去自动实现它，自动装配它
@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);//达到分页的效果，offset起始行的行号，limit规定显示多少行

    //如果我需要动态的拼一个条件，并且这个方法有且只有这一个条件，这个时候参数之前就必须要加Param来取别名
    //@Param注解用于给参数取别名
    //如果只有一个参数，并且在<if>里使用，则必须使用别名
    int selectDiscussPostRows(@Param("userId") int userId);

}
