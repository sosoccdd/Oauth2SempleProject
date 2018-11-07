package cn.crscube.portal.sevice.impl;

import cn.crscube.portal.model.user.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserDetailsImpl extends User {

    public UserDetailsImpl(String id, List<GrantedAuthority> authorities) {
        super(id, "", authorities);
    }

    public UserDetailsImpl(Member member, List<GrantedAuthority> authorities) {
        super(member.getId(), member.getPassword(), authorities);
    }
}
