package com.nhnacademy.command;

import com.nhnacademy.domain.GeneralUser;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import com.nhnacademy.repo.UserRepo;
import com.nhnacademy.repo.UserRepository;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegisterFormController implements Command {
    private UserRepository userRepository = new UserRepo();

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");
        String name = req.getParameter("name");
        String imageName = req.getParameter("image");

        HttpSession session = req.getSession(false);
        if (Objects.isNull(session) || Objects.isNull(session.getAttribute("id"))) {
            User user = new GeneralUser(new Users(id, pwd, name, imageName));
            userRepository.add(user);
            session.setAttribute("userRepository", userRepository);
            return "/assignedBoard.jsp";
        } else {
            return"/wrongAccess.jsp";
        }
    }
}