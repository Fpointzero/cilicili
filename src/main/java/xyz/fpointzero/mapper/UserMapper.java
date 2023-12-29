package xyz.fpointzero.mapper;

import xyz.fpointzero.model.User;

public interface UserMapper {
    User getById(int id);
    User getByEmail(String email);
    User getByUsername(String username);
}
