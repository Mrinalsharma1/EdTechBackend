package com.happiest.apigateway.controller;

import com.happiest.apigateway.model.AuthResponse;
import com.happiest.apigateway.model.RefreshToken;
import com.happiest.apigateway.model.RefreshTokenRequest;
import com.happiest.apigateway.model.Users;
import com.happiest.apigateway.service.JWTService;
import com.happiest.apigateway.service.RefreshTokenService;
import com.happiest.apigateway.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@Tag(name="ApiGatewayService",description="Operations related to apigatewayservice testing")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private RefreshTokenService refreshTokenService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

   @Operation(summary="Register the user")
    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);

    }
//    @PostMapping("/forgot-password")
//    public Users findByUsername(String email){
//        return userService.findByUsername(email);
//    }
//
//    @PostMapping("/reset-password")
//    public Users findByResetToken(String token){
//        return userService.findByResetToken(token);
//    }

//hey i am checking conflict issue

    @Operation(summary="Login of user")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        try {
            AuthResponse authResponse = userService.verify(user);

            if (authResponse != null) {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("message", "User logged in successfully");
                responseBody.put("token", authResponse.getToken());

                // Create a nested map for user data
                Map<String, Object> userData = new HashMap<>();
                userData.put("id", authResponse.getId());
                userData.put("username", authResponse.getUsername());
                userData.put("profilename", authResponse.getProfilename());
                userData.put("role", authResponse.getRole());
                userData.put("status", "success");

                responseBody.put("userdata", userData); // Add userdata to the response

                responseBody.put("refreshtoken",refreshTokenService.createRefreshToken(authResponse.getId()).getToken());
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            } else {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("message", "Invalid username or password");
                responseBody.put("status", "fail");

                return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Internal Server Error");
            responseBody.put("status", "error");

            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/check")
    public String checkServiceCenter(){
        return "i am in check methods";
    }

//
//

//
//
//
//
//
//        }
//
//    }

    /*@GetMapping("/getallmessages")
    public ResponseEntity<Map<String, Object>> getAllMessages(){
        return userServiceInterface.getAllMessages();
    }

    @GetMapping("/users/count")
    public ResponseEntity<Map<String, Object>> countUsers(@RequestParam(defaultValue = "user") String role){
        Map<String, Object> response = new HashMap<>();
        try {
            return userServiceInterface.countUsers(role);
        } catch (Exception e) {
            response.put("status", "fail");
            response.put("message", "" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/managers/count")
    public ResponseEntity<Map<String, Object>> countManagers(@RequestParam(defaultValue = "manager") String role){
        Map<String, Object> response = new HashMap<>();
        try {
            return userServiceInterface.countManagers(role);
        } catch (Exception e) {
            response.put("status", "fail");
            response.put("message", "" + e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
*/
    @Operation(summary="Refresh User Token")
    @PostMapping("/refreshtoken")
    public ResponseEntity<?> refreshtoken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        try {
            Optional<RefreshToken> refreshTokenResponse = refreshTokenService.findByToken(refreshTokenRequest.getRefreshToke());

            if (refreshTokenResponse.isPresent()) {
                RefreshToken refreshToken = refreshTokenService.verifyExpiration(refreshTokenResponse.get());
                String token = jwtService.generateToken(refreshToken.getUser().getUsername());
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("token", token);
                responseBody.put("refreshtoken",refreshTokenRequest.getRefreshToke());
                return new ResponseEntity<>(responseBody, HttpStatus.OK);
            } else {
                Map<String, Object> responseBody = new HashMap<>();
                responseBody.put("message", "Invalid username or password");
                responseBody.put("status", "fail");

                return new ResponseEntity<>(responseBody, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Internal Server Error");
            responseBody.put("status", "error");

            return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/logout")
    public Integer findByUsername(Long userId){
        System.out.println("Logout Initialized");
        return refreshTokenService.deleteByUserId(userId);
    }

}


