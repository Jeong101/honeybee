package com.portfolio.honeybee.web;

import javax.servlet.http.HttpSession;

import com.portfolio.honeybee.domain.user.UserRepository;

import com.portfolio.honeybee.domain.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserRepository userRepository;

    // private final Session session;

    @PostMapping("/auth/login")
    public @ResponseBody String googleLogin(@RequestBody User user) {
        User userEntity = userRepository.mfindByEmail(user.getEmail());

        if (userEntity == null) {
            user.setNickname(user.getUsername());
            if (user.getEmail().equals("climbhoneybee5sound@gmail.com")) {
                user.setMember(2);
            }
            userRepository.save(user);
            userEntity = userRepository.mfindByEmail(user.getEmail());
            session.setAttribute("userEntity", userEntity);
        } else {
            session.setAttribute("userEntity", userEntity);
        }

        System.out.println(session.getAttribute("userEntity"));
        return "OK";
    }

    @GetMapping("/")
    public String home(Model users) {
        users.addAttribute("usersEntity", userRepository.userList());

        return "index";
    }

    @GetMapping("/user/logout")
    public String googleLogout() {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/doEdit/{id}")
    public String doJoin(@PathVariable int id, String nickname) {
        User editUser = userRepository.findById(id).get();
        editUser.setNickname(nickname);
        userRepository.save(editUser);
        session.setAttribute("userEntity", editUser);

        return "redirect:/";
    }

    @GetMapping("/admitMember/{id}")
    public String admitMember(@PathVariable int id) {
        User admitUser = userRepository.findById(id).get();
        admitUser.setMember(1);
        userRepository.save(admitUser);

        return "redirect:/";
    }

}
