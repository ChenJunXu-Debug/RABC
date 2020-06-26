/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UserMapper
 * Author:   ASUS
 * Date:     2020/6/20 18:15
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cjx.mapper;

import com.cjx.pojo.Menu;
import com.cjx.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author ASUS
 * @create 2020/6/20
 * @since 1.0.0
 */
@Repository
public interface UserMapper {
    @Select("select * from users where username = #{param1} and password = #{param2}")
    User login(String username, String password);

    @Select("select m.* from menu m left join user_menu um on m.id = um.mid " +
            "where um.uid = #{param1}")
    List<Menu> findMenuByUid(int uid);

    @Select("select p.name from permission p left join user_permission up on p.id = up.pid " +
            "where up.uid = #{param1}")
    List<String> findPermissionByUid(int uid);

    @Select("select r.name from role r left join user_role ur on r.id = ur.rid " +
            "where ur.uid = #{param1}")
    List<String> findRolesByUid(int uid);
}
