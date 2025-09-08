package com.JeevanJyotiHospital.Services;

import com.JeevanJyotiHospital.Entities.LoginUser;

public interface LoginService {
LoginUser	SaveLoginUser(LoginUser loginuser);
LoginUser findUserByEmail(String email,String password);



}
