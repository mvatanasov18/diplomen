package com.example.students.services;

import com.example.students.models.PendingUpdate;
import com.example.students.models.User;
import com.example.students.repositories.PendingUpdateRepository;
import com.example.students.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@AllArgsConstructor
public class PendingUpdateService implements com.example.students.services.Service<PendingUpdate> {
    private final PendingUpdateRepository pendingUpdateRepository;
    private final UserRepository userRepository;

    @Override
    public PendingUpdate save(PendingUpdate pendingUpdate) {
        return pendingUpdateRepository.save(pendingUpdate);
    }

    @Override
    public void delete(PendingUpdate pendingUpdate) {
        pendingUpdateRepository.delete(pendingUpdate);
    }

    @Override
    public PendingUpdate findById(String id) {
        return pendingUpdateRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<PendingUpdate> findAll() {
        return pendingUpdateRepository.findAll();
    }

    public boolean checkUser(User user) {
        return isUsernameUnique(user.getUsername())
                && isEmailUnique(user.getEmail());
    }

    private boolean isEmailUnique(String email) {
        return !pendingUpdateRepository.existsByEmail(email);
    }

    private boolean isUsernameUnique(String username) {
        return !pendingUpdateRepository.existsByUsername(username);
    }

    //true if the userToChange passes all requirements
    //false if at least one is off
    public boolean checkUpdate(User userToChange, User userDB) {
        boolean isUsernameSame = userToChange.getUsername().equals(userDB.getUsername());
        boolean isEmailSame = userToChange.getEmail().equals(userDB.getEmail());

        if (isUsernameSame && isEmailSame) {
            return true;
        } else {
            boolean isUsernameInDB = userRepository.existsByUsername(userToChange.getUsername());
            boolean isEmailInDB = userRepository.existsByEmail(userToChange.getEmail());

            if (isEmailInDB) {
                User temp;
                if (isUsernameInDB) {
                    temp = userRepository.findByUsername(userToChange.getUsername());
                } else {
                    temp = userRepository.findByEmail(userToChange.getEmail());
                }
                System.out.println(temp);
                System.out.println(userToChange);
                return temp.getId().equals(userDB.getId());
            }
        }
        return true;
    }

    public List<PendingUpdate> findAllBySchoolId(String schoolId) {
        return pendingUpdateRepository.findAllBySchoolId(schoolId);
    }

    public List<PendingUpdate> findAllByAdminIdAndSchoolId(String adminId, String schoolId) {
        List<PendingUpdate> pendingUpdates = new ArrayList<>();
        for (PendingUpdate temp : findAllBySchoolId(schoolId)) {
            if (!temp.getAdmin().getId().equals(adminId)) {
                pendingUpdates.add(temp);
            }
        }
        return pendingUpdates;
    }

    public boolean checkPendingUpdateByIdAndSchoolId(String id, String schoolId) {
        List<PendingUpdate> updates = findAllBySchoolId(schoolId);
        Map<String, PendingUpdate> hashUpdates = new HashMap<>();

        for (PendingUpdate update : updates) {
            hashUpdates.put(update.getId(), update);
        }

        return hashUpdates.containsKey(id);
    }

    public void deleteById(String id) {
        pendingUpdateRepository.deleteById(id);
    }
}