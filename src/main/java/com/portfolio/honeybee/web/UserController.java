package com.portfolio.honeybee.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.portfolio.honeybee.domain.club.Club;
import com.portfolio.honeybee.domain.club.ClubRepository;
import com.portfolio.honeybee.domain.user.User;
import com.portfolio.honeybee.domain.user.UserRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    // private final Session session;

    @PostMapping("/auth/login")
    public @ResponseBody String googleLogin(@RequestBody User user) {
        System.out.println(user.getEmail() + "-----------------------------------------");
        System.out.println(user.getName() + "=======================================");
        User userEntity = userRepository.mfindByEmail(user.getEmail());

        if (userEntity == null) {
            System.out.println("NULLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL");
            userRepository.save(user);
            userEntity = userRepository.mfindByEmail(user.getEmail());
            session.setAttribute("userEntity", userEntity);
        } else {
            session.setAttribute("userEntity", userEntity);
        }
        System.out.println(user.getEmail() + "ooooooooooooooooooooooooooooooooooooooo");
        System.out.println(user.getName() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        System.out.println(session.getAttribute("userEntity"));
        return "OK";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("clubsEntity", clubRepository.findAll());
        return "index";
    }

    @GetMapping("/user/logout")
    public String googleLogout() {
        session.invalidate();
        return "redirect:/";
    }

}
