package com.portfolio.honeybee.web;

import javax.persistence.PostRemove;
import javax.servlet.http.HttpSession;
import javax.swing.text.DefaultStyledDocument.ElementSpec;

import com.portfolio.honeybee.domain.user.UserRepository;
import com.portfolio.honeybee.domain.post.PostRepository;
import com.portfolio.honeybee.domain.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final HttpSession session;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    // private final Session session;

    @PostMapping("/auth/login")
    public @ResponseBody String googleLogin(@RequestBody User user) {
        User userEntity = userRepository.mfindByEmail(user.getEmail());
        session.setAttribute("userEntity", userEntity);
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

        return "OK";
    }

    @GetMapping("/")
    public String home(Model users) {
        users.addAttribute("usersEntity", userRepository.userList());

        users.addAttribute("postsEntity", postRepository.postList());

        return "index";
    }

    @PostMapping("/")
    public String usersUpload(Model posts, int userId) {
        posts.addAttribute("usersEntity", userRepository.userList());
        posts.addAttribute("postsEntity", postRepository.userUpload(userId));
        return "index";
    }

    @GetMapping("/upload/user/{id}")
    public String searchVideo(@PathVariable int id, Model posts) {
        posts.addAttribute("usersEntity", userRepository.userList());
        posts.addAttribute("postsEntity", postRepository.userUpload(id));

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

    @DeleteMapping("/deleteMember/{id}")
    public @ResponseBody String deleteMember(@PathVariable int id) {

        postRepository.deleteUserPosts(id);
        userRepository.deleteById(id);

        return "ok";
    }

    @GetMapping("admitMember/{id}")
    public @ResponseBody String admitMember(@PathVariable int id) {
        User admitUser = userRepository.findById(id).get();
        admitUser.setMember(1);
        userRepository.save(admitUser);

        return "ok";
    }

}
