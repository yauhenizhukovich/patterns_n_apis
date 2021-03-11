package by.compit.yauheni.zhukovich.weblogic_users.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.springframework.stereotype.Service;

import by.compit.yauheni.zhukovich.weblogic_users.service.connection.ConnectionSQLAuthMethod;
import by.compit.yauheni.zhukovich.weblogic_users.service.model.User;

@Service
public class WebLogicUserService {

    private static final String STRING_CLASS = "java.lang.String";
    private static final String INTEGER_CLASS = "java.lang.Integer";

    public List<User> getUsers() throws MalformedObjectNameException, ReflectionException, IOException, InstanceNotFoundException, AttributeNotFoundException, MBeanException, IntrospectionException {
        List<User> users = new ArrayList<>();
        try (ConnectionSQLAuthMethod userMethod = new ConnectionSQLAuthMethod()) {
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
                String position = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "employeetype"}, new String[] {STRING_CLASS, STRING_CLASS});
                String displayName = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "displayname"}, new String[] {STRING_CLASS, STRING_CLASS});
                String telephone = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "telephonenumber"}, new String[] {STRING_CLASS, STRING_CLASS});
                String manager = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "title"}, new String[] {STRING_CLASS, STRING_CLASS});
                String curator = (String) connection.invoke(userEditor,
                        "getUserAttributeValue", new Object[] {currentName, "street"}, new String[] {STRING_CLASS, STRING_CLASS});
                User user = new User();
                user.setName(currentName);
                user.setEmail(email);
                user.setDescription(currentDescription);
                user.setDepartmentNumber(departmentNumber);
                user.setPosition(position);
                user.setDisplayName(displayName);
                user.setTelephone(telephone);
                user.setManager(manager);
                user.setCurator(curator);
                users.add(user);
                connection.invoke(userEditor, "advance", new Object[] {cursor}, new String[] {STRING_CLASS});
                haveCurrent = (Boolean) connection.invoke(userEditor,
                        "haveCurrent",
                        new Object[] {cursor},
                        new String[] {STRING_CLASS});
            }
            setManagerPositionAndName(users);
            setManagerDepartment(users);
            setCuratorPositionAndName(users);
            setCuratorDepartment(users);
        }
        return users;
    }

    private void setManagerPositionAndName(List<User> users) {
        for (User user : users) {
            String managerName = user.getManager();
            if (managerName != null) {
                Optional<User> optionalUser = users.stream()
                        .filter(userToManager -> Objects.equals(userToManager.getName(), managerName))
                        .findFirst();
                if (optionalUser.isPresent()) {
                    User manager = optionalUser.get();
                    String position = manager.getPosition();
                    if (position != null) {
                        user.setManagerPosition(position);
                    }
                    String displayName = manager.getDisplayName();
                    if (displayName != null) {
                        user.setManagerName(displayName);
                    }
                }
            }
        }
    }

    private void setCuratorPositionAndName(List<User> users) {
        for (User user : users) {
            String curatorLogin = user.getCurator();
            if (curatorLogin != null) {
                Optional<User> optionalUser = users.stream()
                        .filter(userToCurator -> Objects.equals(userToCurator.getName(), curatorLogin))
                        .findFirst();
                if (optionalUser.isPresent()) {
                    User curator = optionalUser.get();
                    String position = curator.getPosition();
                    if (position != null) {
                        user.setCuratorPosition(position);
                    }
                    String displayName = curator.getDisplayName();
                    if (displayName != null) {
                        user.setCuratorName(displayName);
                    }
                }
            }
        }
    }

    private void setManagerDepartment(List<User> users) {
        for (User user : users) {
            String managerName = user.getManager();
            Optional<User> optionalManager = users.stream()
                    .filter(streamUser -> Objects.equals(streamUser.getName(), managerName))
                    .findFirst();
            if (optionalManager.isPresent()) {
                User manager = optionalManager.get();
                user.setManagerDepartment(manager.getDepartmentNumber());
            }
        }
    }

    private void setCuratorDepartment(List<User> users) {
        for (User user : users) {
            user.setCuratorDepartment("company");
        }
    }

}
