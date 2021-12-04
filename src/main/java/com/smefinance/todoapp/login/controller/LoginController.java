package com.smefinance.todoapp.login.controller;

import com.smefinance.todoapp.common.model.DBData;
import com.smefinance.todoapp.common.model.Parameters;
import com.smefinance.todoapp.login.model.AuthenticationError;
import com.smefinance.todoapp.login.model.UsersEntity;
import com.smefinance.todoapp.login.procedure.LoginPro;
import com.smefinance.todoapp.login.service.LoginService;
import com.smefinance.todoapp.securityconfiguration.jwt.JwtInMemoryUserDetailsServiceImpl;
import com.smefinance.todoapp.securityconfiguration.jwt.JwtTokenUtil;
import com.smefinance.todoapp.securityconfiguration.jwt.JwtUserDetails;
import com.smefinance.todoapp.securityconfiguration.jwt.resource.AuthenticationException;
import com.smefinance.todoapp.securityconfiguration.jwt.resource.JwtTokenRequest;
import com.smefinance.todoapp.securityconfiguration.jwt.resource.JwtTokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(origins = DBData.CROSS_ORIGIN)
@Slf4j
public class LoginController {

    @Autowired
    private LoginPro oLoginPro;

    @Value("${jwt.http.request.header}")
    private String sTokenHeader;

    @Autowired
    private AuthenticationManager oAuthenticationManager;

    @Autowired
    private JwtTokenUtil oJwtTokenUtil;

    @Autowired
    private JwtInMemoryUserDetailsServiceImpl oJwtInMemoryUserDetailsService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationError authenticationError;

    private String sUserId = "";
    private String sPassword = "";

    @RequestMapping(value = "${jwt.get.token.uri}", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtTokenRequest oAuthenticationRequest, HttpServletRequest request)
            throws AuthenticationException {
        Map<String, Object> map = new HashMap<>();

        sUserId = oAuthenticationRequest.getUsername();
        sPassword = oAuthenticationRequest.getPassword();

        if (sUserId.equals("")) {
            authenticationError.setStatus("FATAL");
            authenticationError.setMessage("Userid Required!");
            map.put("errorMsg", "Userid Required!");
            return new ResponseEntity(authenticationError, HttpStatus.BAD_REQUEST);
        } else if (sPassword.equals("")) {
            authenticationError.setStatus("FATAL");
            authenticationError.setMessage("Password Required!");
            map.put("errorMsg", "Password Required!");
            return new ResponseEntity(authenticationError, HttpStatus.BAD_REQUEST);
        }
        Parameters parameters = new Parameters();
        parameters.setUserId(sUserId);
        parameters.setPassword(sPassword);
        //Calling procedure for Sign
        parameters = oLoginPro.signinPro(parameters);
        map.put("errorMsg", parameters.getErrorMessage());
        log.info("Login Code : " + parameters.getErrorCode());
        log.info("Login Message : " + parameters.getErrorMessage());
        String sToken = "";
        if (parameters.getErrorMessage().equals("Success")) {
            parameters.setUserId(parameters.getUserId());
            parameters.setPassword(sPassword);
            log.info(parameters.getUserId() + " : " + " : " + parameters.getPassword());
            UserDetails oUserDetails = oJwtInMemoryUserDetailsService.loadUserByUsernamePassword(parameters);
            sToken = oJwtTokenUtil.generateToken(oUserDetails);
            UsersEntity userInfo = loginService.getUserInfoByUserId(parameters);
            map.put("userInfo", userInfo);
//            SyRightsEntity userBranchCode = loginService.getUserBranchCodeByUserId(parameters);
//            map.put("userBranchCode", userBranchCode);
            log.info("sToken: " + sToken);
            return ResponseEntity.ok(new JwtTokenResponse(sToken, map));
        } else if (!parameters.getErrorMessage().equals("Success")) {
            log.info("sToken2: " + sToken);
            return ResponseEntity.ok(new JwtTokenResponse(sToken, map));

        }
         else {
            log.info("sToken3: " + sToken);
            return ResponseEntity.ok(new JwtTokenResponse(sToken, null));
        }
    }

    @RequestMapping(value = "${jwt.refresh.token.uri}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest oRequest) {
        Parameters parameters = new Parameters();
        parameters.setUserId(sUserId);
        parameters.setPassword(sPassword);
        String authToken = oRequest.getHeader(sTokenHeader);
        log.info("authToken: " + authToken);
        final String sToken = authToken.substring(7);
        JwtUserDetails user = (JwtUserDetails) oJwtInMemoryUserDetailsService.loadUserByUsernamePassword(parameters);
        if (oJwtTokenUtil.canTokenBeRefreshed(sToken)) {
            String sRefreshedToken = oJwtTokenUtil.refreshToken(sToken);
            log.info("refreshedToken: " + sRefreshedToken);
            return ResponseEntity.ok(new JwtTokenResponse(sRefreshedToken, null));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    private void authenticate(String sUserName, String sPassword) {
        Objects.requireNonNull(sUserName);
        Objects.requireNonNull(sPassword);
        try {
            oAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(sUserName, sPassword));
        } catch (DisabledException e) {
            throw new AuthenticationException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("INVALID_CREDENTIALS", e);
        }
    }

}