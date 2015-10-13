package by.bsu.project.mvc;

import by.bsu.project.model.SpringUser;
import by.bsu.project.service.UserInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * User: iason
 * Date: 13.10.15
 */
public class BaseController {
    protected static final Logger logger = Logger.getLogger(UserInfoController.class);

    @Autowired
    protected UserInfoService userInfoService;

    protected SpringUser getUser() {
        return (SpringUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
