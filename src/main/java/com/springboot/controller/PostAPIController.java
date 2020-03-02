package com.springboot.controller;

// src : https://shlee0882.tistory.com/249?category=809647
import com.springboot.model.SearchVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostAPIController {
    // http통신할때 post는 body에다 data를 집어넣어서 받아오겠다.
    // @RequestBody에 SearchVO에 있는 값을 매칭해서 보내줘라.

    // usetool : postman
    // setting :
    // 1. Authentication
    // no auth

    // 2. header
    // Content-Type : application/json

    // 3. body
    //    {
    //        "id": "조길상",
    //            "email": "2020-02-27",
    //            "page": 3
    //    }

    @RequestMapping(method = RequestMethod.POST, path = "/postRequest")
    public SearchVO postRequest(@RequestBody SearchVO searchVO){
        return searchVO;
    }

    @PostMapping(value = "/postMapping")
    public SearchVO postMapping(@RequestBody SearchVO searchVO){
        return searchVO;
    }

}
