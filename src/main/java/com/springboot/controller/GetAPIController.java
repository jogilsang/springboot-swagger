package com.springboot.controller;

import com.springboot.model.SearchVO;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class GetAPIController {
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public HashMap<String, Object> test() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("abc", "ddd");
        return map;
    }

    // EX : // localhost:8080/api/getRequest
    @RequestMapping(method = RequestMethod.GET, path = "/getRequest")
    public String getRequest() {
        return "this is getRequest";
    }

    // EX : localhost:8080/api/getParameters?id=shlee0882&email=shlee0882@gmail.com
    @GetMapping("/getParametersDefault")
    public String getParametersDefault(@RequestParam String id, @RequestParam String email) {
        return "아이디는 " + id + " 이메일은 " + email;
    }

    // EX : http://localhost:8080/api/getParameters?id=shlee0882&email=shlee0882@gmail.com
    @GetMapping("/getParameters")
    public String getParameters(@RequestParam(name = "id") String userId
            , @RequestParam(name = "email") String userEmail) {
        return "아이디는 " + userId + " 이메일은 " + userEmail;
    }

    // EX : http://localhost:8080/api/getMultiParameters?id=shlee0882&email=shlee0882@gmail.com
    @GetMapping("/getMultiParameters")
    public String getMultiParameters(SearchVO searchVo) {
        return "VO사용 아이디는 " + searchVo.getId() + " 이메일은 " + searchVo.getEmail();
    }


}
