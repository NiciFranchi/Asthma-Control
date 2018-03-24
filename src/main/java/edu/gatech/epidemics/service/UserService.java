/**
 *
 */
package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.UserRepository;
import edu.gatech.epidemics.model.User;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author atalati
 */
@Service
public class UserService
{
	@Autowired
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	public List<User> findAll()
	{

		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User findById(Integer id)
	{
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent())
		{
			return user.get();
		} else
		{
			return null;
		}
	}
}