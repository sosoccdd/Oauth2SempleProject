package cn.crscube.portal.ajax;

import cn.crscube.portal.model.user.Member;
import cn.crscube.portal.repository.MemberRepository;
import cn.crscube.portal.sevice.impl.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AjaxUserDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Member user = repository.findById(username).orElse(null);

        if (user == null) {
            throw new UsernameNotFoundException(username + "라는 사용자가 없습니다.");
        }

        return new UserDetailsImpl(user, AuthorityUtils.createAuthorityList(user.getRole()));
    }
}
