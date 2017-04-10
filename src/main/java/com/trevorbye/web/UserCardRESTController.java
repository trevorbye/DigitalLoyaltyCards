package com.trevorbye.web;

import com.trevorbye.service.UserCardJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCardRESTController {

    @Autowired
    private UserCardJoinService service;
}
