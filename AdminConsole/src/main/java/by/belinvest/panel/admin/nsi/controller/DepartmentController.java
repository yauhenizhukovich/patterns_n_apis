package by.belinvest.panel.admin.nsi.controller;

import by.belinvest.panel.admin.entity.AjaxResponseBody;
import by.belinvest.panel.admin.entity.Department;

import by.belinvest.panel.admin.nsi.db.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/nsi/department")
public class DepartmentController {

    @Autowired
    private DepartamentRepository departamentRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {
      //  departamentRepository.
        return "nsi/divisions";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/departments")
    @ResponseBody
    public List<Department> getDepList() {
         return departamentRepository.getAllDepartments();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/create")
    @ResponseBody
    public ResponseEntity<?> create(@RequestBody Department department){
        AjaxResponseBody result = null;
        if (department.getfDevelop()==null){
            department.setfDevelop("0");
        }else {
            department.setfDevelop("1");
        }
        try {
            departamentRepository.create(department);
        } catch (Exception e) {
            result = new AjaxResponseBody("Произошла ошибка");
            e.printStackTrace();
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно создано");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Department department){
        AjaxResponseBody result = null;

        if (department.getfDevelop()==null){
            department.setfDevelop("0");
        }else {
            department.setfDevelop("1");
        }


        try {
           departamentRepository.update(department);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно изменено");
        return ResponseEntity.ok().body(result);
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        AjaxResponseBody result = null;

        try {
            departamentRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResponseBody("Произошла ошибка");
            return ResponseEntity.badRequest().body(result);
        }
        result = new AjaxResponseBody("Успешно удалено");
        return ResponseEntity.ok().body(result);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/hasChild/{id}")
    @ResponseBody
    public boolean hasChildnren(@PathVariable Long id) {
        return departamentRepository.hasChildren(id);
    }

}
