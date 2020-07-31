package control.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    public boolean login(int empNo, String userPassword){
        return 2017214363 == empNo && "199811".equals(userPassword);
    }


}
