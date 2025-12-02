package com.blog.app.config;

import com.blog.app.annotation.RequireRole;
import com.blog.app.model.User.Role;
import com.blog.app.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // If we reach here, it means the path requires authentication
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Missing or invalid token\"}");
            return false;
        }

        String token = authHeader.substring(7);
        if (!jwtService.isTokenValid(token)) {
            response.setStatus(401);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"Invalid token\"}");
            return false;
        }

        // For now, just validate token - role checking can be added per endpoint if needed
        return true;
    }
}