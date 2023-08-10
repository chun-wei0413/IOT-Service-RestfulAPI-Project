package com.example.Fproject.handler;

import com.example.Fproject.apibody.UserBean;

public interface UserHandler {
    String deleteUser(UserBean.DeleteUserBean deleteUserBean);
    String authorUser(UserBean.AuthorUserBean authorUserBean);
    String registerUser(UserBean.RegisterUserBean registerUserBean);
}
