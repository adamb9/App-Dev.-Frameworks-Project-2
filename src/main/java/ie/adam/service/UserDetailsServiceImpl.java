package ie.adam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ie.adam.entities.User> optionalUser = userService.findById(username);
        if(optionalUser.isPresent())
        {
            ie.adam.entities.User myUser = optionalUser.get();
            // Create an instance of Spring's User class using data from our database
            return User.builder()
                    .username(myUser.getUserEmail())
                    .password( myUser.getUserPassword() )
                    .disabled( false )
                    .accountExpired( false )
                    .accountLocked( false )
                    .roles( myUser.getUserRole() )
                    .build();
        } else {
            throw new UsernameNotFoundException("Email " + username + " is not Found");
        }
    }
}
