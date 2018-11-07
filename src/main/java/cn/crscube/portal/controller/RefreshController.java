package cn.crscube.portal.controller;

import cn.crscube.portal.jwt.JwtInfo;
import cn.crscube.portal.sevice.impl.UserDetailsImpl;
import cn.crscube.portal.utils.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/refresh")
public class RefreshController {
    @GetMapping
    public ResponseEntity<String> refreshToken(Authentication authentication) {
        System.out.println("refreshToken");
        UserDetails userDetails = new UserDetailsImpl(authentication.getPrincipal().toString(), new ArrayList<>(authentication.getAuthorities()));

        String token = JwtUtil.refreshToken(userDetails);

        HttpHeaders headers = new HttpHeaders();
        headers.add(JwtInfo.HEADER_NAME, token);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }
}
