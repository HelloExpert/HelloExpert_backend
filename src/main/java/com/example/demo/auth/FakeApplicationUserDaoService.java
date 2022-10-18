package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.demo.security.ApplicationUserRole.STUDENT;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {


    private PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("HansSprengers",
                        passwordEncoder.encode("password"),
                        (Set<? extends GrantedAuthority>) STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser("KarstenSmits",
                        passwordEncoder.encode("password"),
                        (Set<? extends GrantedAuthority>) STUDENT.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true)

        );
        return applicationUsers;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }
}
