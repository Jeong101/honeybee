package com.portfolio.honeybee.web;

import java.util.List;

import javax.persistence.metamodel.SetAttribute;
import javax.websocket.Session;

import com.portfolio.honeybee.domain.club.Club;
import com.portfolio.honeybee.domain.club.ClubRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ClubController {

    private final ClubRepository clubRepository;

    @GetMapping("/manageclub")
    public String manageClub(Model model) {
        model.addAttribute("clubsEntity", clubRepository.findAll());
        return "manager/manageClub";
    }
}
