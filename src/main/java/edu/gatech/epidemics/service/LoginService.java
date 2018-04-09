package edu.gatech.epidemics.service;

import edu.gatech.epidemics.dao.LoginRepository;
import edu.gatech.epidemics.entities.Person;
import edu.gatech.epidemics.viewmodel.LoginPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author atalati
 */
@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        Person person = loginRepository.findUserByUsername(username);
        if(person==null){
            System.out.println("ERROR: Login not found in LoginService: " + username);
        }
        return  new LoginPrincipal(person);
    }
}
