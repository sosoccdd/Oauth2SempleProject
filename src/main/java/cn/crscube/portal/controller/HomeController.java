package cn.crscube.portal.controller;

import java.security.Principal;

import cn.crscube.portal.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    /**
     * 메인페이지 호출
     * @param model
     * @return 메인 페이지
     */
    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "testhtml/welcomePage";
    }

    /**
     * admin 페이지 호출
     * @param model
     * @param principal
     * @return admin 페이지
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "testhtml/adminPage";
    }

    /**
     * 로그인 페이지 호출
     * @param model
     * @return 로그인 페이지
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "testhtml/loginPage";
    }

    /**
     * 로그아웃 성공 페이지 호출
     * @param model
     * @return 로그아웃 성공 페이지
     */
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "testhtml/logoutSuccessfulPage";
    }

    /**
     * 사용자 페이지 호출
     * @param model
     * @param principal
     * @return 사용자 페이지
     */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "testhtml/userInfoPage";
    }

    /**
     * 403 에러 페이지 호출
     * @param model
     * @param principal
     * @return 403 에러 페이지
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "testhtml/403Page";
    }

}
