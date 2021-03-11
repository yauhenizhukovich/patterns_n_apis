package by.compit.yauheni.zhukovich.business_initiative.controller.weblogic_users;

import java.util.ArrayList;
import java.util.List;

import org.example.GetWeblogicUsersResponse;
import org.example.TUser;
import org.example.TUsersResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import by.compit.yauheni.zhukovich.business_initiative.service.WebLogicUserService;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.WebLogicException;
import by.compit.yauheni.zhukovich.business_initiative.service.model.User;

import static by.compit.yauheni.zhukovich.business_initiative.constant.BusinessInitiativeConstant.NAMESPACE_URI;

@Endpoint
public class UserController {

    private final WebLogicUserService webLogicUserService;

    public UserController(WebLogicUserService webLogicUserService) {
        this.webLogicUserService = webLogicUserService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWeblogicUsersRequest")
    @ResponsePayload
    public GetWeblogicUsersResponse getWeblogicUsers() {
        GetWeblogicUsersResponse response = new GetWeblogicUsersResponse();
        TUsersResponse usersResponse = new TUsersResponse();
        try {
            List<User> users = webLogicUserService.getUsersList();
            List<TUser> soapUsers = getResponseUsers(users);
            usersResponse.getUsers().addAll(soapUsers);
            response.setWebLogicUsers(usersResponse);
        } catch (WebLogicException e) {
            usersResponse.setMessage(e.getMessage());
        }
        return response;
    }

    private List<TUser> getResponseUsers(List<User> users) {
        List<TUser> responseUsers = new ArrayList<>();
        for (User user : users) {
            TUser responseUser = new TUser();
            if (user.getName() != null) {
                responseUser.setName(user.getName());
            }
            if (user.getDepartmentNumber() != null) {
                responseUser.setDepartmentNumber(user.getDepartmentNumber());
            }
            if (user.getDescription() != null) {
                responseUser.setDescription(user.getDescription());
            }
            if (user.getEmail() != null) {
                responseUser.setEmail(user.getEmail());
            }
            responseUsers.add(responseUser);
        }
        return responseUsers;
    }

}
