package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.exeptions.UsernameOrEmailTakenException;
import com.example.students.models.Admin;
import com.example.students.models.Role;
import com.example.students.models.Session;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/adminsMenu")
@AllArgsConstructor
public class AdminMenuController {

    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final UserService userService;
    private final AdminService adminService;


    @GetMapping
    public ModelAndView getAdminMenuIndexPage(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            if (session.getRole()== Role.PRINCIPAL) {

                return new ModelAndView("/admins-menu-index")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("admin", new Admin())
                        .addObject("admins",adminService.findAllBySchoolId(session.getUser().getSchool().getId()));

            }
        }
        throw new UserDoesNotHavePermissionException();
    }



    @PostMapping
    public ModelAndView postAdmin(@ModelAttribute Admin admin, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            Role role = roleService.getRole(session.getUser());
            if (role==Role.PRINCIPAL) {
                admin.getUser().setSchool(session.getUser().getSchool());
                admin.getUser().hashPassword();

                if(userService.save(admin.getUser())==null){
                    throw  new UsernameOrEmailTakenException();
                }
                adminService.save(admin);
                return new ModelAndView("redirect:/adminsMenu");
            }
        }
            throw new UserDoesNotHavePermissionException();
    }

    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteGroup( HttpServletRequest request, @PathVariable String id){
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            Role role = roleService.getRole(session.getUser());
            if (role==Role.PRINCIPAL) {
                String schoolId= session.getUser().getSchool().getId();
                if( adminService.checkAdminByIdAndSchoolId(id,schoolId)){
                    adminService.deleteById(id);
                    return new ModelAndView("redirect:/adminsMenu");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }
}
