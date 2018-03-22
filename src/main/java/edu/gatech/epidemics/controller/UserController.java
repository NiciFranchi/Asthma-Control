package edu.gatech.epidemics.controller;

import edu.gatech.epidemics.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController
{
	// database
	private static Map<Integer, User> users;

	static
	{
		users = new HashMap<Integer, User>()
		{
			{
				put(1, new User(1, "aarsh", "talati", true));
				put(2, new User(2, "ramesh", "mainan", true));
			}
		};
	}

	// service
	private Collection<User> getData()
	{
		return this.users.values();
	}

	@RequestMapping(method = RequestMethod.GET)
	private Collection<User> get()
	{
		return getData();
	}


}
