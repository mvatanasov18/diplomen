package com.example.students.controllers;

import com.example.students.exeptions.UserDoesNotHavePermissionException;
import com.example.students.exeptions.UsernameOrEmailTakenException;
import com.example.students.models.*;
import com.example.students.services.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping(value = "/studentsMenu")
@AllArgsConstructor
public class StudentMenuController {

    private final SessionService sessionService;
    private final NavbarService navbarService;
    private final CookieService cookieService;
    private final RoleService roleService;
    private final StudentService studentService;
    private final UserService userService;
    private final GroupService groupService;
    private final PendingUpdateService pendingUpdateService;
    private final AdminService adminService;

    @GetMapping
    public ModelAndView getStudentsMenuIndexPage(HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {
            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            Role role = roleService.getRole(session.getUser());
            if (role==Role.PRINCIPAL || role==Role.ADMIN) {
                return new ModelAndView("/students-menu-index").addObject("navElements", navbarService.getNavbar(cookieService.getValue(request.getCookies()), sessionService)).addObject("student", new Student()).addObject("groups", groupService.findAllBySchoolId(session.getUser().getSchool().getId())).addObject("students", studentService.findAllBySchoolId(session.getUser().getSchool().getId()));
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping
    public ModelAndView postStudent(@ModelAttribute Student student, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            Role role = roleService.getRole(session.getUser());
            if (role==Role.PRINCIPAL) {

                Group group = groupService.findAllByGradeAndLetterAndSchoolId(student.getGroup().getGrade(), student.getGroup().getLetter(), session.getUser().getSchool().getId());
                student.setGroup(group);
                student.getUser().setSchool(session.getUser().getSchool());
                student.getUser().hashPassword();
                if (userService.save(student.getUser()) == null) {
                    throw new UsernameOrEmailTakenException();
                }
                studentService.save(student);
                return new ModelAndView("redirect:/studentsMenu");
            }
        }
        throw new UserDoesNotHavePermissionException();
    }

    @GetMapping(value = "/update/{id}")
    public ModelAndView getUpdatePage(@PathVariable String id, HttpServletRequest request) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            Role role = roleService.getRole(session.getUser());
            if (role==Role.PRINCIPAL || role==Role.ADMIN) {

                Student student = studentService.findById(id);
                student.getUser().setSchool(session.getUser().getSchool());


                return new ModelAndView("students-menu-update").addObject("student", student).addObject("groups", groupService.findAllBySchoolId(session.getUser().getSchool().getId())).addObject("navElements", navbarService.getNavbar(cookieService.getValue(request.getCookies()), sessionService));
            }

        }
        throw new UserDoesNotHavePermissionException();
    }

    @PostMapping(value = "/update/{id}")
    public ModelAndView putStudent(@ModelAttribute Student student, @PathVariable String id, HttpServletRequest request) {
        if (pendingUpdateService.checkUser(student.getUser())) {
            if (cookieService.isSessionPresent(request.getCookies())) {
                Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
                Role role = roleService.getRole(session.getUser());
                if (role==Role.PRINCIPAL) {
                    student.getUser().setSchool(session.getUser().getSchool());

                    Student studentToUpdate = studentService.findById(id);
                    userService.update(student.getUser(), studentToUpdate.getUser().getId());
                    return new ModelAndView("redirect:/studentsMenu");
                }
                if (role==Role.ADMIN) {

                    User user = student.getUser();
                    user.setSchool(session.getUser().getSchool());
                    student.setUser(user);

                    User userDB = studentService.findById(id).getUser();

                    if(pendingUpdateService.checkUpdate(user,userDB)) {
                        pendingUpdateService.save(
                                new PendingUpdate(
                                        user.getUsername(),
                                        userDB.getPassword(),
                                        user.getEmail(),
                                        user.getFirstName(),
                                        user.getLastName(),
                                        LocalDateTime.now(),
                                        userDB.getSalt(),
                                        adminService.findAdminByUserId(session.getUser().getId()),
                                        userDB));
                        return new ModelAndView("redirect:/studentsMenu");
                    }else{
                        throw new UsernameOrEmailTakenException();
                    }
                }
            }
            throw new UserDoesNotHavePermissionException();
        }
        throw new UsernameOrEmailTakenException();
    }

    @PostMapping(value = "/delete/{id}")
    public ModelAndView deleteStudent(HttpServletRequest request, @PathVariable String id) {
        if (cookieService.isSessionPresent(request.getCookies())) {

            Session session = sessionService.findById(cookieService.getValue(request.getCookies()));
            Role role = roleService.getRole(session.getUser());
            if (role==Role.PRINCIPAL) {
                String schoolId = session.getUser().getSchool().getId();
                if (studentService.checkStudentByIdAndSchoolId(id, schoolId)) {
                    studentService.deleteById(id);
                    return new ModelAndView("redirect:/studentsMenu");
                }
            }
        }
        throw new UserDoesNotHavePermissionException();
    }
}
