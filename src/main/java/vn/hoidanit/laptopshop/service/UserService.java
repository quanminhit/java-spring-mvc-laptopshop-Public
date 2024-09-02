package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Role;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.RoleRepository;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public String handleHello() {
        return "Hello Spring Service";
    }

    public User create(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmailAndAddress(String email, String address) {
        return this.userRepository.findByEmailAndAddress(email, address);
    }

    public User findById(long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
