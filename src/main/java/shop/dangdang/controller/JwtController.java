package shop.dangdang.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import shop.dangdang.domain.Membership;
import shop.dangdang.dto.UserJoinDto;
import shop.dangdang.service.JwtService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class JwtController {
    private final JwtService jwtService;

    public JwtController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PutMapping("/membership")
    public ResponseEntity<Membership> signup(@Valid @RequestBody final UserJoinDto.Request userDto) {
        return ResponseEntity.ok(jwtService.signup(userDto));
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Membership> getMyUserInfo() {
        return ResponseEntity.ok(jwtService.getMyUserWithAuthorities().get());
    }

    @GetMapping("/user/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Membership> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(jwtService.getUserWithAuthorities(username).get());
    }
}