package com.portfolio.honeybee.web;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.websocket.Session;

import com.portfolio.honeybee.domain.club.Club;
import com.portfolio.honeybee.domain.club.ClubRepository;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ClubController {

    private final ClubRepository clubRepository;
    // private final Session session;

    @GetMapping("/")
    public String home(Model model) {

        List<Club> clubsEntity = clubRepository.findAll();

        // model.addAttribute("clubsEntity", clubsEntity);
        return "index";
    }

    @GetMapping("/manageclub")
    public String manageClub() {
        return "manager/manageClub";
    }
}
