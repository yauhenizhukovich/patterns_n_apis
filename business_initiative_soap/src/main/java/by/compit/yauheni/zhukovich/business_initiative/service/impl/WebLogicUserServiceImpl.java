package by.compit.yauheni.zhukovich.business_initiative.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.business_initiative.service.WebLogicUserService;
import by.compit.yauheni.zhukovich.business_initiative.service.connection.ConnectionSQLAuthMethod;
import by.compit.yauheni.zhukovich.business_initiative.service.exception.WebLogicException;
import by.compit.yauheni.zhukovich.business_initiative.service.model.User;

@Service
public class WebLogicUserServiceImpl implements WebLogicUserService {

    private static final String STRING_CLASS = "java.lang.String";
    private static final String INTEGER_CLASS = "java.lang.Integer";

    public WebLogicUserServiceImpl() {}

    @Override
    public List<User> getUsersList() throws WebLogicException {
        try (ConnectionSQLAuthMethod userMethod = new ConnectionSQLAuthMethod()) {
            List<User> users = new ArrayList<>();
            ObjectName userEditor = userMethod.getUserEditor();
            MBeanServerConnection connection = userMethod.getConnection();
            String cursor = (String) connection.invoke(userEditor, "listUsers",
                    new Object[] {"*", 9999}, new String[] {STRING_CLASS, INTEGER_CLASS});
            boolean haveCurrent = (Boolean) connection.invoke(userEditor,
                    "haveCurrent", new Object[] {cursor}, new String[] {STRING_CLASS});
            while (haveCurrent) {
                String currentName = (String) connection.invoke(userEditor,
                        "getCurrentName", new Object[] {cursor}, new String[] {STRING_CLASS});
                String currentDescription = (String) connection.invoke(userEditor,
                        "getUserDescription", new Object[] {currentName}, new String[] {STRING_CLASS});
                String email = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "mail"}, new String[] {STRING_CLASS, STRING_CLASS});
                String departmentNumber = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "departmentnumber"}, new String[] {STRING_CLASS, STRING_CLASS});
                users.add(
                        new User(
                                currentName,
                                email,
                                currentDescription,
                                departmentNumber
                        ));
                connection.invoke(userEditor, "advance", new Object[] {cursor}, new String[] {STRING_CLASS});
                haveCurrent = (Boolean) connection.invoke(userEditor,
                        "haveCurrent",
                        new Object[] {cursor},
                        new String[] {STRING_CLASS});
            }
            return users;
        } catch (ReflectionException | IOException | InstanceNotFoundException | MBeanException e) {
            throw new WebLogicException(e);
        }
    }

}
