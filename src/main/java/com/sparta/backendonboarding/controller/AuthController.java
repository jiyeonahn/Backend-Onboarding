package com.sparta.backendonboarding.controller;

import com.sparta.backendonboarding.dto.SignUpRequestDto;
import com.sparta.backendonboarding.dto.SignUpResponseDto;
import com.sparta.backendonboarding.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignUpRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.signup(requestDto));
    }
}
