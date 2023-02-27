package com.example.students.services;

import com.example.students.models.Address;
import com.example.students.models.Principal;
import com.example.students.models.School;
import com.example.students.models.User;
import com.example.students.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrincipalService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final SchoolRepository schoolRepository;
    private final PrincipalRepository principalRepository;
    @Autowired
    public PrincipalService(UserRepository userRepository,
                            AddressRepository addressRepository,
                            SchoolRepository schoolRepository,
                            PrincipalRepository principalRepository,
                            UserJdbcTemplateRepository userJdbcTemplateRepository){
        this.userRepository=userRepository;
        this.addressRepository=addressRepository;
        this.schoolRepository=schoolRepository;
        this.principalRepository=principalRepository;

    }

    public void updatePrincipal(Principal principal){
        principalRepository.save(principal);
    }

    public boolean insertPrincipal(Address address, School school, User user){
        try {
            Principal principal = new Principal();
            school.setAddress(address);
            user.setSchool(school);
            principal.setUser(user);
            principal.setVerified(false);

            addressRepository.save(address);
            schoolRepository.save(school);
            userRepository.save(user);
            principalRepository.save(principal);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
