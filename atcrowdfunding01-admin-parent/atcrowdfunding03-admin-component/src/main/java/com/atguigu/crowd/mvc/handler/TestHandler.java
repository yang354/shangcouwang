package com.atguigu.crowd.mvc.handler;




import com.atguigu.crowd.entity.*;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.ResultEntity;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.List;
import java.util.logging.Logger;


@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;


    @ResponseBody
    @RequestMapping("/send/array/one.json")
    public ResultEntity testReceiveArrayOne(@RequestParam(value = "pn",defaultValue = "99")Integer pn){
//        for (Integer number:array){
//            System.out.println("number="+number);
//        }
        ResultEntity<Integer> integerResultEntity = ResultEntity.successWithData(pn);
        System.out.println(integerResultEntity);
        return integerResultEntity;
    }

    @ResponseBody
    @RequestMapping("/send/array/two.json")
    public String testReceiveArrayTwo(@RequestBody Admin admin) {
        System.out.println(admin.getId());
        System.out.println(admin.toString());

        return "success";
    }

    @ResponseBody
    @RequestMapping("/send/array/three.json")
    public ResultEntity<List<Integer>> testReceiveArrayThree(@RequestBody List<Integer> array,
                                                             HttpServletRequest request){

//        boolean judegResult = CrowdUtil.judgeRequestType(request);
//        System.out.println("judegResult="+judegResult);
//
//        for (Integer number:array){
//            System.out.println("number="+number);
//        }

//        String a = null;
//        System.out.println(a.length());
        System.out.println(10/0);
        return ResultEntity.successWithData(array);
    }


    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap, HttpServletRequest request) {
        boolean judegResult = CrowdUtil.judgeRequestType(request);
        System.out.println("judegResult="+judegResult);
//        String a = null;
//        System.out.println(a.length());
        //System.out.println(10/0);

        return "target";
    }






    @RequestMapping("/abc.json")
    @ResponseBody
    public Admin testSsm(){
        Admin admin = adminService.getId();
        return admin;
    }

    @RequestMapping("/aaa.html")
    public String testSsm2(ModelMap modelMap){
        Admin admin = adminService.getId();
        modelMap.addAttribute("admin",admin);
        return "target";
    }
}
