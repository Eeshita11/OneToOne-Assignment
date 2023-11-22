package com.one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.model.User;
import com.one.repository.UserInfoRepository;
import com.one.repository.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public User saveUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> fetchAll()
	{
		return userRepository.findAll();
	}
	
	public User fetchById(Integer id)
	{
		return userRepository.findById(id).orElse(null);
	}


	public User fetchById1(Integer id) throws UserNotFoundException 
	{
	    Optional<User> optionalUser = userRepository.findById(id);

	    if (optionalUser.isPresent()) 
	    {
	        return optionalUser.get();
	    } 
	    else 
	    {
	        throw new UserNotFoundException("User not found with ID: " + id);
	    }
	}

	public void deleteUserById(Integer id) 
	{
        userRepository.deleteById(id);
    }
}
