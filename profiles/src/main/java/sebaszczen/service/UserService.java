package sebaszczen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sebaszczen.User;
import sebaszczen.repository.UserRepository;

@Service
public class UserService {

//    @Autowired
//    private UserRepository userRepository;

    public void saveUser(User user) {
//        userRepository.save(user);
    }

    public void hello() {
        System.out.println("hello");
    }
}
