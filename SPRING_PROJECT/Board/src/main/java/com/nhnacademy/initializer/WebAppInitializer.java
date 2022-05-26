package com.nhnacademy.initializer;

import com.nhnacademy.domain.AdminUser;
import com.nhnacademy.domain.GeneralUser;
import com.nhnacademy.domain.Post;
import com.nhnacademy.domain.Posts;
import com.nhnacademy.domain.User;
import com.nhnacademy.domain.Users;
import com.nhnacademy.repo.PostRepo;
import com.nhnacademy.repo.PostRepository;
import com.nhnacademy.repo.UserRepo;
import com.nhnacademy.repo.UserRepository;
import java.time.LocalDateTime;
import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext)
        throws ServletException {
        servletContext.setInitParameter("counterFile", "counter.dat");
        servletContext.setAttribute("lang", "ko");
        servletContext.setAttribute("userRepository", constructUserRepository());
        servletContext.setAttribute("postRepository", constructPostRepository());

    }

    private UserRepository constructUserRepository(){
        UserRepository userRepository = new UserRepo();

        User adminUser = new AdminUser(new Users("admin", "12345", "관리자", null));
        User generUser = new GeneralUser(new Users("aaa", "aaa", "aaa", "aaa"));
        userRepository.add(adminUser);
        userRepository.add(generUser);

        return userRepository;
    }

    private PostRepository constructPostRepository(){
        PostRepository postRepository = new PostRepo();

        Post post1 = new Posts(0, "example","example", "admin", LocalDateTime.now(), 0 );
        Post post2 = new Posts(1, "aaa","aaa", "aaa", LocalDateTime.now(), 0 );
        postRepository.register(post1);
        postRepository.register(post2);

        return postRepository;
    }


}
