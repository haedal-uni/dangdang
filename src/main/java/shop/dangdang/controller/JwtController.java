package shop.dangdang.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import shop.dangdang.domain.Membership;
import shop.dangdang.dto.JoinDto;
import shop.dangdang.dto.LoginDto;
import shop.dangdang.jwt.JwtFilter;
import shop.dangdang.jwt.TokenProvider;
import shop.dangdang.service.JwtService;

import javax.validation.Valid;

@RestController
public class JwtController {
    private final JwtService jwtService;

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public JwtController(JwtService jwtService, TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.jwtService = jwtService;
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    // 가입
    @PutMapping("/api/membership")
    public ResponseEntity<Membership> join(@Valid @RequestBody final JoinDto.Request userDto) {
        return ResponseEntity.ok(jwtService.join(userDto));
    }

    // 로그인 -> 스프링 시큐리티 사용자와 비교하여 일치하면 헤더에 JWT 정보를 업데이트 한다.
    @PostMapping("/api/login")
    public ResponseEntity<LoginDto.Response> login(@Valid @RequestBody LoginDto.Request loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getNickName(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new ResponseEntity<>(new LoginDto.Response(200L, "로그인에 성공했습니다", jwt), httpHeaders, HttpStatus.OK);
    }
}