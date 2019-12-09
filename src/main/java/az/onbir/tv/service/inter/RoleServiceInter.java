package az.onbir.tv.service.inter;

import az.onbir.tv.entity.AuthRole;

import java.util.List;

public interface RoleServiceInter {
    public AuthRole findById(Integer id);

    public List<AuthRole> findAll();

    public AuthRole save(AuthRole role);
    
}
