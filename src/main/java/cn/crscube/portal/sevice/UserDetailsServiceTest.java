package cn.crscube.portal.sevice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDetailsServiceTest extends UserDetailsService {
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException;

}
