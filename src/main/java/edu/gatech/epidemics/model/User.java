package edu.gatech.epidemics.model;

import org.springframework.stereotype.Repository;

@Repository
public class User
{
	int id;
	String userName;
	String password;
	Boolean active;

	public User()
	{
	}

	public User(int id, String userName, String password, Boolean active)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.active = active;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public Boolean getActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}
}
