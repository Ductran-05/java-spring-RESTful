package vn.hoidanit.jobhunter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User getUserByID(long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        try {
            return this.userRepository.findAll();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public void updateUser(User user) {

        this.userRepository.findById(user.getId());
        if (this.userRepository.findById(user.getId()).isPresent()) {
            this.userRepository.save(user);
        } else {
            throw new RuntimeException("User not found for ID :: " + user.getId());
        }
    }
}
