package az.onbir.tv.service.inter;


import az.onbir.tv.entity.User;

import java.util.List;

public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public int save(User user);

    public User update(az.onbir.tv.bean.User user);
}
