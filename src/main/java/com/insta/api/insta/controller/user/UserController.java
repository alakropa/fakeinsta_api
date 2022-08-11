package com.insta.api.insta.controller.user;

import com.insta.api.insta.command.user.UserDto;
import com.insta.api.insta.command.user.UserUpdateDto;
import com.insta.api.insta.service.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private IUserService userService;

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/search")
    public List <UserDto> searchUsers(@RequestParam(value = "username", required = false) String username,
                                      @RequestParam(value = "email", required = false) String email,
                                      @RequestParam(value = "name", required = false) String name) {
        return this.userService.searchUsers(username, email, name);
    }

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PostMapping
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return this.userService.registerUser(userDto);
    }

    @PatchMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserUpdateDto userUpdateDto) {
        return this.userService.updateUser(id, userUpdateDto);
    }

   /*
    GET getUserByUsername(String username)
    GET getAllFollowers(userId)
    GET getAllFollows(userId)
    Login JWT
    POST/ PATCH follow(userId, otherUserId)
    POST/ PATCH unfollow(userId, otherUserId)
    DELETE deleteUser(userId)*/

}
