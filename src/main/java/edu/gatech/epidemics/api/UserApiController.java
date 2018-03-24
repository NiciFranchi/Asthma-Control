package edu.gatech.epidemics.api;

import edu.gatech.epidemics.model.User;
import edu.gatech.epidemics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author atalati
 *
 * /api/user
 *
 */
@RestController
public class UserApiController
{

	@Autowired
	Environment environment;

	@Autowired
	private UserService userService;

	@RequestMapping("/api/user/hello")
	public String Hello() throws UnknownHostException
	{
		String datePattern = "MM/dd/yyyy HH:mm:ss";
		DateTimeFormatter df = DateTimeFormatter.ofPattern(datePattern);
		LocalDateTime now = LocalDateTime.now();

		String hostName = InetAddress.getLocalHost().getHostName();
		String port = environment.getProperty("local.server.port");

		return "Do you speak whale? - Web server @ " + df.format(now) + ". <br/><br/><br/><b>Host:</b> " + hostName
				+ " <span style=\"color:red;\">:</span> " + port;
	}

	/*
		GET: /api/user/
		Returns all users from the database
	 */
	@GetMapping(value = "/api/user")
	public List<User> get()
	{
		return userService.findAll();
	}

	@GetMapping(value = "/api/user/{id}")
	public User get(@PathVariable int id)
	{
		return userService.findById(id);
	}
}