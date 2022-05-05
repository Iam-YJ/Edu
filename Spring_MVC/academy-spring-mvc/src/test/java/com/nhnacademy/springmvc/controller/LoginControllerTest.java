package com.nhnacademy.springmvc.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.cookie;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.nhnacademy.springmvc.repository.UserRepository;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class LoginControllerTest {
    private MockMvc mockMvc;

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        LoginController loginController = new LoginController(userRepository);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();

    }

    @Test
    void getLoginWithoutCookie() throws Exception {
        mockMvc.perform(get("/login"))
            .andExpect(status().isOk())
            .andExpect(view().name("loginForm"));
        /* .cookie(new Cookie("SESSION", "12345")); */
    }

    @Test
    void getLoginWithCookie() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/login"))
            /*.cookie(new Cookie("SESSION", "12345"))*/
            .andExpect(status().isOk())
            .andExpect(view().name("loginSuccess"))
            .andReturn();

        String sessionId = (String) mvcResult.getModelAndView().getModel().get("id");
        assertThat(sessionId).isEqualTo("12345");
    }

    @Test
    void testDoLoginWhenLoginIsSuccessful() throws Exception {
        when(userRepository.matches(anyString(), anyString())).thenReturn(true);
        MvcResult mvcResult = mockMvc.perform(post("/login")
            .param("id", "admin")
            .param("pwd", "12345"))
            .andExpect(status().isOk())
            .andExpect(view().name("loginSuccess"))
            .andExpect(cookie().exists("SESSION"))
            .andReturn(); //

        HttpSession session = mvcResult.getRequest().getSession(false);
        assertThat(session).isNotNull();

        Cookie cookie = mvcResult.getResponse().getCookie("SESSION");
        assertThat(cookie).isNotNull();
        assertThat(cookie.getValue()).isEqualTo(session.getId());

        String attributeId = (String) mvcResult.getModelAndView().getModelMap().get("id");

        assertThat(attributeId).isEqualTo(session.getId());
    }

    @Test
    void testDoLoginWhenLoginIsNotSuccessful() throws Exception {
        when(userRepository.matches(anyString(), anyString())).thenReturn(false);

        // 302 /login 기대중
        mockMvc.perform(post("/login")
            .param("id", "bdmin")
            .param("pwd", "12345"))
            .andExpect(status().is3xxRedirection())
            .andExpect(header().string("Location", "/login"));


    }

}
