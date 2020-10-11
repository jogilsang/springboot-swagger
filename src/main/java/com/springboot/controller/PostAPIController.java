package com.springboot.controller;

// src : https://shlee0882.tistory.com/249?category=809647
import com.springboot.model.SearchVO;
import io.swagger.annotations.*;
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

    @ApiOperation(value = "사용자 정보등록" , notes = "상세한 사용자 정보에 대해서 출력한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK !!"),
            @ApiResponse(code = 500, message = "Internal Server Error !!"),
            @ApiResponse(code = 404, message = "Not Found !!")
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "사용자의 이메일을 입력한다", required = false, dataType = "SearchVO", paramType = "string", defaultValue = ""),
            @ApiImplicitParam(name = "id", value = "사용자의 id값", required = false, dataType = "SearchVO", paramType = "string", defaultValue = ""),
            @ApiImplicitParam(name = "page", value = "페이지 숫자", required = false, dataType = "SearchVO", paramType = "int", defaultValue = ""),
    })
    @RequestMapping(method = RequestMethod.POST, path = "/postRequest")
    public SearchVO postRequest(@RequestBody SearchVO searchVO){
        return searchVO;
    }

    @ApiOperation(value = "사용자 정보등록2")
    @PostMapping(value = "/postMapping")
    public SearchVO postMapping(@RequestBody SearchVO searchVO){
        return searchVO;
    }

}
