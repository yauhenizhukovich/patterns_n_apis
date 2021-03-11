package by.compit.yauheni.zhukovich.weblogic_users.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MalformedObjectNameException;
import javax.management.ReflectionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.compit.yauheni.zhukovich.weblogic_users.service.impl.WebLogicUserService;
import by.compit.yauheni.zhukovich.weblogic_users.service.model.User;

@RestController
public class UserController {

    private final WebLogicUserService webLogicUserService;

    public UserController(WebLogicUserService webLogicUserService) {
        this.webLogicUserService = webLogicUserService;
    }

    @GetMapping(value = "/users", produces = "application/json;charset=utf-8")
    public Object getUserByParameter(
            @RequestParam(required = false) String login,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String department,
            @RequestParam(required = false) String position
    ) {
        List<User> users;
        try {
            users = webLogicUserService.getUsers();
        } catch (MalformedObjectNameException | ReflectionException | IOException | InstanceNotFoundException | AttributeNotFoundException | MBeanException | IntrospectionException e) {
            return e.getMessage();
        }
        if (login != null) {
            return getByLogin(login, users);
        }
        if (name != null) {
            return getByName(name, users);
        }
        if (department != null && position == null) {
            return getByDepartment(department, users);
        }
        if (department == null && position != null) {
            return getByPosition(position, users);
        }
        if (department != null && position != null) {
            return getByDepartmentAndPosition(department, position, users);
        }
        return users;
    }

    @GetMapping(value = "/departments", produces = "application/json;charset=utf-8")
    public Object getDepartments(
            @RequestParam(required = false) Boolean isDeveloper
    ) {
        List<User> users;
        try {
            users = webLogicUserService.getUsers();
        } catch (MalformedObjectNameException | ReflectionException | InstanceNotFoundException | AttributeNotFoundException | MBeanException | IntrospectionException | IOException e) {
            return e.getMessage();
        }
        if (isDeveloper != null && isDeveloper) {
            return users.stream()
                    .map(User::getDepartmentNumber)
                    .filter(Objects::nonNull)
                    .filter(dept -> dept.contains("developer"))
                    .distinct()
                    .collect(Collectors.toList());
        }
        return users.stream()
                .map(User::getDepartmentNumber)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/positions", produces = "application/json;charset=utf-8")
    public Object getPositions(
            @RequestParam(required = false) String department
    ) {
        List<User> users;
        try {
            users = webLogicUserService.getUsers();
        } catch (MalformedObjectNameException | ReflectionException | IOException | InstanceNotFoundException | AttributeNotFoundException | MBeanException | IntrospectionException e) {
            return e.getMessage();
        }
        if (department != null) {
            return users.stream()
                    .filter(user -> Objects.equals(user.getDepartmentNumber(), department))
                    .map(User::getPosition)
                    .filter(Objects::nonNull)
                    .distinct()
                    .collect(Collectors.toList());
        }
        return users.stream()
                .map(User::getPosition)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
    }

    private Object getByDepartmentAndPosition(@RequestParam(required = false) String department, @RequestParam(required = false) String position, List<User> users) {
        users = users.stream()
                .filter(user -> Objects.equals(user.getDepartmentNumber(), department))
                .filter(user -> Objects.equals(user.getPosition(), position))
                .collect(Collectors.toList());
        if (users.isEmpty()) {
            return "There are no users with this department and position.";
        }
        return users;
    }

    private Object getByPosition(@RequestParam(required = false) String position, List<User> users) {
        users = users.stream()
                .filter(user -> Objects.equals(user.getPosition(), position))
                .collect(Collectors.toList());
        if (users.isEmpty()) {
            return "There are no users with this position.";
        }
        return users;
    }

    private Object getByDepartment(@RequestParam(required = false) String department, List<User> users) {
        users = users.stream()
                .filter(user -> Objects.equals(user.getDepartmentNumber(), department))
                .collect(Collectors.toList());
        if (users.isEmpty()) {
            return "There are no users with this department.";
        }
        return users;
    }

    private Object getByName(@RequestParam(required = false) String name, List<User> users) {
        Optional<User> optionalUser = users.stream()
                .filter(user -> Objects.equals(user.getDisplayName(), name))
                .findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return "There are no user with this display name.";
        }
    }

    private Object getByLogin(@RequestParam(required = false) String login, List<User> users) {
        Optional<User> optionalUser = users.stream()
                .filter(user -> Objects.equals(user.getName(), login))
                .findFirst();
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return "There are no user with this login.";
        }
    }

}
