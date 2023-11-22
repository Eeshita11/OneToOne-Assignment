package com.one.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.model.User;
import com.one.repository.UserRepository;
import com.one.service.UserNotFoundException;
import com.one.service.UserService;

@RestController
@RequestMapping("/oneToOne")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user)
	{
		return userService.saveUser(user);
	}
	
	@GetMapping("/fetchAll")
	public List< User> fetchAllUsers()
	{
		return userService.fetchAll();
	}
	
	@GetMapping("/fetch/{id}")
	public  User fetchById(@PathVariable Integer id)
	{
		return userService.fetchById(id);
	}
	
	@PutMapping("/fetch/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Integer id, @RequestBody User updatedUser) throws UserNotFoundException 
	{
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) 
        {
            // Update the user with the new information
            User existingUser = optionalUser.get();
            
            existingUser.setName(updatedUser.getName());
            existingUser.setName(updatedUser.getName());
            userRepository.save(existingUser);

            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } 
        else 
        {
            throw new UserNotFoundException("User not found with ID: " + id);
        }
	}
    
	  @DeleteMapping("/delete/{id}")
	    public String deleteUser(@PathVariable Integer id) 
	  {
	        userService.deleteUserById(id);
	        return "User with ID " + id + " has been deleted.";
	    }
	
}
