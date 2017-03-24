package io.linx.etoll.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by lingani on 3/24/17.
 *
 * Service used to authenticate user coming from another service.
 * When other services say, hey is this token valid?... we want to make sure they validate the user using the token.
 */

@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
