package com.atc.web.controller.asset;import com.atc.common.model.CommonResultModel;import com.atc.common.model.asset.PagedListCondition;import com.atc.common.model.asset.PagedListResult;import com.atc.common.model.asset.SearchCondition;import com.atc.common.util.SessionUtil;import com.atc.domains.asset.entity.Asset;import com.atc.domains.home.entity.Actor;import com.atc.service.asset.IAssetService;import com.atc.web.AbstractController;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.*;import org.springframework.web.servlet.ModelAndView;import javax.servlet.http.HttpServletRequest;/** * Created with IntelliJ IDEA. * User: Vic.Feng * Date: 09/11/15 * Time: 16:04 * To change this template use File | Settings | File Templates. */@Controllerpublic class AssetController extends AbstractController {    private final Logger logger = LoggerFactory.getLogger(AssetController.class);    @Autowired    IAssetService assetService;    /**     * Display asset add page     *     * @return ModelAndView     */    @RequestMapping(value = "/asset/addPage")    public ModelAndView index() {        return new ModelAndView("asset/assetAdd");    }    /**     * Add new asset     *     * @param asset     * @return CommonResultModel     */    @RequestMapping(value = "/asset", method = RequestMethod.POST)    @ResponseBody    public CommonResultModel addAsset(@RequestBody Asset asset, HttpServletRequest request) {        Actor user = SessionUtil.getSessionUser(request);        asset.setOrg(user.getOrg());        CommonResultModel result = new CommonResultModel();        if (assetService.addAsset(asset) > 0) {            //result.setCode(0);            result.setMessage("Add Successfully");        } else {            //  result.setCode(1);            result.setMessage("Add Error");        }        return result;    }    /**     * Show asset update page     *     * @param id     * @return ModelAndView     */    @RequestMapping(value = "/asset/{id}")    public ModelAndView showAssetUpdatePage(@PathVariable("id") Integer id, HttpServletRequest request) {        Actor user = SessionUtil.getSessionUser(request);        Asset assets = assetService.get(id, user.getOrg());        ModelAndView mav = new ModelAndView();        mav.addObject("assets", assets);        mav.setViewName("asset/assetEdit");        return mav;    }    /**     * Update asset     *     * @param asset     * @return CommonResultModel     */    @RequestMapping(value = "/updateAsset", method = RequestMethod.POST)    @ResponseBody    public CommonResultModel update(@RequestBody Asset asset, HttpServletRequest request) {        Actor user = SessionUtil.getSessionUser(request);        asset.setOrg(user.getOrg());        CommonResultModel result = new CommonResultModel();        assetService.update(asset);        result.setCode(0);        result.setMessage("Asset Updated");        return result;    }    /**     * Display asset search page     *     * @return     */    @RequestMapping(value = "/asset/searchPage")    public ModelAndView showAssetSearchPage() {        return new ModelAndView("asset/assetSearch");    }    /**     * Display asset list page     *     * @param condition     * @return     */    @RequestMapping(value = "/assets", method = RequestMethod.POST)    public ModelAndView findAssets(SearchCondition condition) {        ModelAndView mav = new ModelAndView();        mav.addObject("searchCondition", condition);        mav.setViewName("asset/assets");        return mav;    }    /**     * Get asset list     *     * @param condition     * @param request     * @return     */    @RequestMapping(value = "/assets")    @ResponseBody    public PagedListResult getAssets(PagedListCondition condition, HttpServletRequest request) {        Actor user = SessionUtil.getSessionUser(request);        condition.setOrg(user.getOrg());        PagedListResult result = assetService.findAssets(condition);        result.setsEcho(condition.getsEcho());        return result;    }}