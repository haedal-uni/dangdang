package shop.dangdang.controller;

import shop.dangdang.domain.User;
import shop.dangdang.dto.UserRequestDto;
import shop.dangdang.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    // User 데이터 가져오기
    @GetMapping("/api/Users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    // User 데이터 저장하기
    @PostMapping("/api/Users")
    public User createUser(@RequestBody UserRequestDto requestDto){
        User user = userService.createUser(requestDto);
        return user;
    }
}

