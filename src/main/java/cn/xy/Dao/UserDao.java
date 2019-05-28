package cn.xy.Dao;

import cn.xy.Bean.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser(int userId);


}
