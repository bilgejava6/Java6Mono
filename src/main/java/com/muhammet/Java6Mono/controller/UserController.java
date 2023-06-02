package com.muhammet.Java6Mono.controller;

import com.muhammet.Java6Mono.dto.request.DoLoginRequestDto;
import com.muhammet.Java6Mono.dto.request.UserSaveResuestDto;
import com.muhammet.Java6Mono.dto.response.DoLoginResponseDto;
import com.muhammet.Java6Mono.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @CrossOrigin("*")
    public void save(@RequestBody UserSaveResuestDto dto){
        userService.save(dto.getUsername(),dto.getEmail(),dto.getPassword());
    }

    @PostMapping("/dologin")
    @CrossOrigin("*")
    public ResponseEntity<DoLoginResponseDto> doLoign(@RequestBody DoLoginRequestDto dto){
        boolean isLogin = userService.isUser(dto.getUsername(), dto.getPassowrd());
        if(isLogin){
            return ResponseEntity.ok(DoLoginResponseDto.builder().token("token").build());
        }
        return ResponseEntity.badRequest().build();
    }
}
