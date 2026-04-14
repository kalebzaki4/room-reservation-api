package com.kalebzaki.syncspace.service;

import com.kalebzaki.syncspace.infra.exception.ResourceNotFoundException;
import com.kalebzaki.syncspace.model.User;
import com.kalebzaki.syncspace.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Transactional
    public User createUser(User user) {
        String password = user.getPassword();
        String encryptedPassword = passwordEncoder.encode(password);
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    @Transactional
    public User updateUser(User user) {
        return userRepository.findById(user.getId())
                .map(existingUser -> {
                    existingUser.setUsername(user.getUsername());
                    existingUser.setEmail(user.getEmail());

                    if (user.getPassword() != null && !user.getPassword().isBlank()) {
                        String encryptedPassword = passwordEncoder.encode(user.getPassword());
                        existingUser.setPassword(encryptedPassword);
                    }

                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + user.getId()));
    }

    @Transactional
    public User deleteUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    return user;
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
}
