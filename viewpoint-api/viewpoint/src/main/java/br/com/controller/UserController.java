package br.com.controller;

import br.com.model.entity.User;
import br.com.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes =  MediaType.APPLICATION_JSON_VALUE)
    public User create(@Validated @RequestBody UserDTO userDTO) {
        return getUserService().create(userDTO.getEmail(), userDTO.getPassword(), userDTO.getPassword());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public User update(@RequestParam(required = true) Long id,
                       @RequestBody UserDTO userDTO) throws NotFoundException {
        return getUserService().update(id, userDTO.getEmail(), userDTO.getPassword(), userDTO.getName());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void update(@RequestParam(required = true) Long id) throws NotFoundException {
        getUserService().delete(id);
    }

    @RequestMapping(value = "/findByKey", method = RequestMethod.GET)
    public User findByKey(@RequestParam(required = true) String key) {
        return getUserService().findByKey(key);
    }

    @RequestMapping(value = "/findByEmail", method = RequestMethod.GET)
    public User findByEmail(@RequestParam(required = true) String email) {
        return getUserService().findByEmail(email);
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
