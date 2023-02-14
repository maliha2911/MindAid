package com.example.mindaid.Controller;
import com.example.mindaid.Dto.ChooseDto;
import com.example.mindaid.Dto.ConcernDto;
import com.example.mindaid.Dto.DoctorsDto;
import com.example.mindaid.Dto.PaymentDto;
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

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class DoctorsController {
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
        SessionValidatorService sessionValidatorService;

        @GetMapping("/doctors-list")
        public String getdoctorList(Model model){
                return "doctorsListNew";

        }
        @GetMapping("/doctors-details")
        public String getdoctorDetails(Model model){
                return "doctorsDetails";

        }
        @PostMapping("/postdoctorlist")
        public  String postdoclist(Model model, DoctorsDto docDto, HttpSession httpSession){
                if ((sessionValidatorService.userSessionValidator(httpSession))) {
                        return sessionValidatorService.loginPageReturn(model);
                }
                ChooseDto chooseDto=new ChooseDto();
                chooseDto.setContactMedia((String) httpSession.getAttribute("contactMedia"));
                List<DoctorsDto> doctorsList = doctorListService.getDoctorList((List<Integer>) httpSession.getAttribute("concerns"), chooseDto);
                List<TemporaryObjectHoldService>scheduleTimeAndTimeStr=schedulingService.getScheduleTimeAndTimeStr(docDto,doctorsList,model);
                model.addAttribute("scheduleTimeAndTimeStr",scheduleTimeAndTimeStr);
                return "doctorsDetails";
        }
        @PostMapping("/payment")
        public  String postdocDetails(Model model, DoctorsDto doctorsDto,HttpSession httpSession){
                if ((sessionValidatorService.userSessionValidator(httpSession))) {
                        return sessionValidatorService.loginPageReturn(model);
                }
                Payment paymentDto=new PaymentDto();
                model.addAttribute(paymentDto);
                model.addAttribute("doctorsDto", doctorsDto);
                System.out.println(doctorsDto.selectedScheduleDay);
                return "payment";
        }

        }
