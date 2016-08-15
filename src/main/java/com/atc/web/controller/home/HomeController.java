package com.atc.web.controller.home;import com.atc.common.constant.ResultCodes;import com.atc.common.constant.SystemConstants;import com.atc.common.constant.home.UserResultCode;import com.atc.common.model.CommonResultModel;import com.atc.common.model.home.LoginInfo;import com.atc.common.util.SerializeUtil;import com.atc.domains.home.entity.Actor;import com.atc.service.home.IUserService;import com.atc.web.AbstractController;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestBody;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RequestMethod;import org.springframework.web.bind.annotation.ResponseBody;import org.springframework.web.servlet.ModelAndView;import org.springframework.web.servlet.i18n.CookieLocaleResolver;import javax.servlet.http.HttpServletRequest;/** * Created with IntelliJ IDEA. * User: Vic.Feng * Date: 09/11/15 * Time: 16:04 * To change this template use File | Settings | File Templates. */@Controllerpublic class HomeController extends AbstractController {    private final Logger logger = LoggerFactory.getLogger(HomeController.class);    @Autowired    CookieLocaleResolver resolver;    @Autowired    IUserService userService;    /**     * Display Login Page     *     * @return Login Page     */    @RequestMapping(value = "/home")    public ModelAndView index() {        return new ModelAndView("home/login");    }    /**     * Validate User's Account     *     * @param request   Http Servlet Request     * @param loginInfo login info     * @return Validation Result(Code=0:Correct, Code=11:Password or Username Incorrect, Code=2:Error)     */    @RequestMapping(value = "/home/login", method = RequestMethod.POST)    @ResponseBody    public CommonResultModel login(HttpServletRequest request, @RequestBody LoginInfo loginInfo) {        CommonResultModel result = new CommonResultModel(ResultCodes.SUCCESS, "");        Actor userInfo = userService.validateUser(loginInfo);        if (userInfo != null) {            request.getSession().setAttribute(SystemConstants.LOGGED_USER, SerializeUtil.serialize(userInfo));        } else {            result.setCode(UserResultCode.ERROR);        }        return result;    }}