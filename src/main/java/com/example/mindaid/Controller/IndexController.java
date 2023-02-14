package com.example.mindaid.Controller;
import com.example.mindaid.Dto.ScheduleDto;
import com.example.mindaid.Dto.UserDto;
import com.example.mindaid.Model.*;
import com.example.mindaid.Repository.ConcernRepository;
import com.example.mindaid.Repository.DoctorConcernRepository;
import com.example.mindaid.Repository.DoctorsRepository;
import com.example.mindaid.Repository.UserRepository;
import com.example.mindaid.Request.Signup_request;
import com.example.mindaid.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
@Controller
public class IndexController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ConcernRepository concernRepository;
    @Autowired
    Signup_request signup_request;
    @Autowired
    EmailVerificationService emailVerificationService;
    @Autowired
    UserService userService;
    @Autowired
    DoctorListService doctorListService;
    @Autowired
    DoctorConcernRepository doctorConcernRepository;
    @Autowired
    DoctorsRepository doctorsRepository;
    @Autowired
    TemporaryConcernService temporaryConcernService;
    @Autowired
    TemporaryObjectHoldService temporaryObjectHoldService;
    @Autowired
    SchedulingService schedulingService;
    @Autowired
    ConcernService concernService;
    @Autowired
    MailSendingService mailSendingService;

    @GetMapping("/home")
    public String getHome(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "home";
    }
    @GetMapping("/faq")
    public String getFaq() {
        return "faq";
    }
    @GetMapping("/contact")
    public String getContact(Model model) {
        Contact contact=new Contact();
        model.addAttribute(contact);
        return "contact";
    }
    @PostMapping("/postContact")
    public String postContact(Model model,Contact contact1) throws MessagingException, UnsupportedEncodingException {
        mailSendingService.contactMail(contact1);
        Contact contact=new Contact();
        model.addAttribute(contact);
        return "contact";
    }
}
