package com.temosho.application.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.temosho.application.exchange.LoginForm;
import com.temosho.application.exchange.SignUpForm;
import com.temosho.application.exception.ResourceNotFoundException;
import com.temosho.application.exchange.JwtResponse;
import com.temosho.application.exchange.ResponseMessage;
import com.temosho.application.model.Role;
import com.temosho.application.model.RoleName;
import com.temosho.application.model.User;
import com.temosho.application.repository.RoleRepository;
import com.temosho.application.repository.UserRepository;
import com.temosho.application.security.JwtProvider;
import com.temosho.application.services.UserDetailsServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")


@RestController
@RequestMapping("/api/auth")
public class UserController {
 
  @Autowired
  AuthenticationManager authenticationManager;
 
  @Autowired
  UserRepository userRepository;
 
  @Autowired
  RoleRepository roleRepository;
 
  @Autowired
  PasswordEncoder encoder;
 
  @Autowired
  JwtProvider jwtProvider;
  
  @Autowired
  private UserDetailsServiceImpl userService;
  
  
  //list user
  @CrossOrigin
  @RequestMapping(value = "/Users" , method = RequestMethod.GET)
  public List<User> getAllUsers(){
      return userService.getAllUsers();
  }
  
  
 
  //login
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
 
    SecurityContextHolder.getContext().setAuthentication(authentication);
 
    String jwt = jwtProvider.generateJwtToken(authentication);
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
 
    return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
  }
 
  
  //registration
  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return new ResponseEntity<>(new ResponseMessage("Username exist!"),
          HttpStatus.BAD_REQUEST);
    }
 
    
 
    // Creating user's account
    User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
        encoder.encode(signUpRequest.getPassword()));
 
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();
 
    strRoles.forEach(role -> {
      switch (role) {
      case "admin":
        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(adminRole);
 
        break;
     
        
      case "customer":
          Role customerRole = roleRepository.findByName(RoleName.ROLE_CUSTOMER)
              .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
          roles.add(customerRole);
   
          break;
          
          
      case "driver":
          Role driverRole = roleRepository.findByName(RoleName.ROLE_DRIVER)
              .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
          roles.add(driverRole);
   
          break;
          
          
      default:
        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        roles.add(userRole);
      }
    });
 
    user.setRoles(roles);
    userRepository.save(user);
 
    return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
  }
  
  
  //update user details
  @PutMapping("/update/{id}")
	  public ResponseEntity<User> updateUser(
	      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
	      throws ResourceNotFoundException {
	    User user =
	        userRepository
	            .findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
	    user.setName(userDetails.getName());
	    user.setUsername(userDetails.getUsername());
	    user.setEmail(userDetails.getEmail());
	    user.setPassword(encoder.encode(userDetails.getPassword()));
	   
	    
	    final User userUpdated = userRepository.save(user);
	    return ResponseEntity.ok(userUpdated);
	  }
  
}