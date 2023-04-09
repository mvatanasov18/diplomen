package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.models.PendingUpdate;
import com.example.students.models.Session;
import com.example.students.models.User;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
@RequestMapping("pendingUpdates")
public class PendingUpdateController {
    private final PendingUpdateService pendingUpdateService;
    private final AdminService adminService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final UserService userService;

    @GetMapping
    public ModelAndView getPendingUpdates(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("admin")) {
                return new ModelAndView("pending-update")
                        .addObject("navElements", navbarService
                                .getNavbar(cookieService.getValue(request.getCookies()), sessionService))
                        .addObject("updates", pendingUpdateService
                                .findAllByAdminIdAndSchoolId(adminService
                                        .findAdminByUserId(session.getUser().getId()).getId(), session.getUser().getSchool().getId()));
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping(value = "/update/{id}")
    public ModelAndView postConfirmPendingUpdate(@PathVariable String id, HttpServletRequest request) {

        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("admin")) {
                String schoolId = session.getUser().getSchool().getId();
                if (pendingUpdateService.checkPendingUpdateByIdAndSchoolId(id, schoolId)) {
                    PendingUpdate pendingUpdate = pendingUpdateService.findById(id);
                    User updateData = new User(
                            pendingUpdate.getUser().getId(),
                            pendingUpdate.getUsername(),
                            pendingUpdate.getPassword(),
                            pendingUpdate.getEmail(),
                            pendingUpdate.getFirstName(),
                            pendingUpdate.getLastName(),
                            pendingUpdate.getSalt());
                    userService.update(updateData, pendingUpdate.getUser().getId());


                    pendingUpdateService.deleteById(id);
                    return new ModelAndView("redirect:/pendingUpdates");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping(value = "/delete/{id}")
    public ModelAndView postDeletePendingUpdate(@PathVariable String id, HttpServletRequest request) {

        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            String role = roleService.getRole(session.getUser());
            if (role.equals("admin")) {
                String schoolId = session.getUser().getSchool().getId();
                if (pendingUpdateService.checkPendingUpdateByIdAndSchoolId(id, schoolId)) {
                    pendingUpdateService.deleteById(id);
                    return new ModelAndView("redirect:/pendingUpdates");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }
}
