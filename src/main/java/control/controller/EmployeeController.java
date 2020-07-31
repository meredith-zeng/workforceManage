package control.controller;

import com.github.pagehelper.PageInfo;
import control.service.EmployeeService;
import model.Employee;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


@Controller
@RequestMapping("/Employee")
public class EmployeeController {
    private static final Log logger = LogFactory.getLog(UserController.class);
    private EmployeeService employeeService;

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * addEmployee
     **/
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String getAddEmp(@ModelAttribute("addEmployee") Employee addEmployee) {
        return "/employee/addEmp";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("addEmployee") Employee addEmployee,
                              @RequestParam("img") MultipartFile img,
                              HttpServletRequest request,
                              Model model) {
        if (img != null){
            String originalFileName = img.getOriginalFilename();
            String suffix = originalFileName.substring(originalFileName.lastIndexOf(".") );
            String fileName = addEmployee.getEmpNo() + suffix;

            // 图片存储路径
            String filePath =  request.getServletContext().getRealPath("/WEB-INF/static/img/");
            try {
                img.transferTo(new File(filePath, fileName));
                addEmployee.setEmpImg( fileName );
                //<img src="/static/img/${emp.empImg}"
                //model.addAttribute("empImg",saveFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            model.addAttribute("empImg",filePath);
        }

        if (employeeService.addEmployee(addEmployee)) {
            logger.info("添加员工" + addEmployee.getEmpName() + addEmployee.getEmpNo() + addEmployee.getWorkSection());
            return "/employee/add_success";
        } else {
            logger.info("阿鲲今天也没有添加成功员工" + addEmployee.getEmpName() + addEmployee.getEmpNo() + addEmployee.getWorkSection());
            return "/employee/addEmp";
        }


    }

    /**
     * deleteEmployee
     **/
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public String getDeleteEmp(HttpSession session, Model model) {
        return "/employee/deleteEmp";
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam int empNo, HttpSession session, Model model) {
        if (employeeService.deleteEmployee(empNo)) {
            logger.info("成功删除工号为" + empNo + "的员工");
            model.addAttribute("empNo", empNo);
            return "/employee/delete_success";
        } else {
            logger.info("删除工号为" + empNo + "的员工失败");
            return "/employee/deleteEmp";
        }
    }

    /**
     * selectEmployee
     **/
    @RequestMapping(value = "/selectEmployee", method = RequestMethod.GET)
    public String getSelectEmp(HttpSession session, Model model) {
        return "/employee/selectEmp";
    }

    @RequestMapping(value = "/selectEmployee", method = RequestMethod.POST)
    public String selectEmployee(@RequestParam("empNo") String empNo, Model model) {
        int empNumber = Integer.parseInt(empNo);
        Employee selectEmp = employeeService.selectEmployee(empNumber);

        if (employeeService.selectEmployee(empNumber) != null) {
            model.addAttribute("selectEmp", selectEmp);
            logger.info("查询到员工id为" + empNo + "员工所有信息" + selectEmp);
            return "/employee/select_success";
        } else {
            logger.info("哦豁，曾雨琳你又搞错啥了");
            return "/employee/selectEmp";
        }
    }

    /**
     * queryEmployee
     **/
    @RequestMapping(value = "/queryEmployee", method = RequestMethod.GET)
    public String getQueryEmp(HttpSession session, Model model) {
        return "/employee/selectEmp";
    }

    @RequestMapping(value = "/queryEmployee", method = RequestMethod.POST)
    public String queryEmployee(
            Model model,
            @RequestParam(required = true,value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam (required = true,value = "pageSize", defaultValue = "9")int pageSize) {

        PageInfo<Employee> pageInfo = employeeService.queryEmployee(pageNum,pageSize);

            model.addAttribute("pageInfo", pageInfo);
            logger.info("成功查询到所有员工信息");
            return "/employee/query_success";
    }

    @RequestMapping(value = "/queryEmployeeShow", method = RequestMethod.GET)
    public String queryEmployeeShow(
            Model model,
           HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(required = true,value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam (required = true,value = "pageSize", defaultValue = "9")int pageSize) {

        int crurentPageNum= Integer.parseInt(request.getParameter("pageNum"));   //pageNum对应的值
        PageInfo<Employee> pageInfo = employeeService.queryEmployee(crurentPageNum,pageSize);
        model.addAttribute("pageInfo", pageInfo);
        logger.info("显示"+crurentPageNum+"的员工查询结果");
        return "/employee/query_success";
    }


    /**
     * updateEmployee
     **/
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String getUpdateEmployee(@ModelAttribute("updateEmployee") Employee updateEmployee) {
        return "/employee/updateEmp";
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute("updateEmployee") Employee updateEmployee) {
        if (employeeService.updateEmployee(updateEmployee)) {
            logger.info("更新员工" + updateEmployee.getEmpName() + updateEmployee.getEmpNo() + updateEmployee.getWorkSection());
            return "/employee/update_success";
        } else {
            logger.info("阿鲲今天也没有修改员工" + updateEmployee.getEmpName() + updateEmployee.getEmpNo() + updateEmployee.getWorkSection());
            return "/employee/updateEmp";
        }
    }

    /**
     * fireEmployee
     **/
    @RequestMapping(value = "/fireEmployee", method = RequestMethod.GET)
    public String getFireEmployee(HttpSession session, Model model) {
        return "/employee/fireEmp";
    }


    @RequestMapping(value = "/fireEmployee", method = RequestMethod.POST)
    public String fireEmployee(@RequestParam int empNo, HttpSession session, Model model) {
        Employee fireEmployee = employeeService.selectEmployee(empNo);
        if (employeeService.fireEmployee(empNo)) {
            logger.info("成功开除工号为" + empNo + "的员工");
            model.addAttribute("fireEmployee", fireEmployee);
            return "/employee/fire_success";
        } else {
            logger.info("开除工号为" + empNo + "的员工失败");
            return "/employee/fireEmp";
        }
    }


}