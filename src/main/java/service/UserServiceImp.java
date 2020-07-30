package service;

import model.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    public boolean login(int empNo, String userPassword){
        if (2017214363 == empNo && "199811".equals(userPassword)) {
            return true;
        } else {
            return false;
        }
    }


}
