package by.compit.yauheni.zhukovich.business_initiative.service;

import java.util.List;

import by.compit.yauheni.zhukovich.business_initiative.service.exception.WebLogicException;
import by.compit.yauheni.zhukovich.business_initiative.service.model.User;

public interface WebLogicUserService {

    List<User> getUsersList() throws WebLogicException;

}
