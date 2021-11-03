package com.tct.data.controller;

import com.tct.data.model.StrategyConfig;
import com.tct.data.service.StrategyConfigService;
import com.tct.data.util.RequestBean;
import com.tct.data.util.Result;
import com.tct.data.util.ResultGenerator;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 策略配置 前端控制器
 * </p>
 *
 * @author hannibal
 * @since 2021-10-11
 */
@RestController
@RequestMapping("/strategy")
public class StrategyConfigController {

    @Resource
    StrategyConfigService strategyConfigService;

    @GetMapping("list")
    public Result list(String name, RequestBean requestBean) {

        return strategyConfigService.selectList(name, requestBean);
    }

    @PostMapping("save")
    public Result save(@RequestBody StrategyConfig strategyConfig) {
        if (ObjectUtils.isEmpty(strategyConfig.getStrategyName())) {
            return ResultGenerator.fail("策略名称不能为空");
        }
        if (CollectionUtils.isEmpty(strategyConfig.getStrategyInfos())) {
            return ResultGenerator.fail("策略信息不能为空");
        }
        return strategyConfigService.saveApplyStrategy(strategyConfig);
    }

    @PostMapping("update")
    public Result update(@RequestBody StrategyConfig strategyConfig) {
        if (CollectionUtils.isEmpty(strategyConfig.getStrategyInfos())) {
            return ResultGenerator.fail("策略信息不能为空");
        }
        return strategyConfigService.updateApplyStrategy(strategyConfig);
    }

    @GetMapping("delete")
    public Result delete(Integer id) {
        return strategyConfigService.deleteApplyStrategy(id);
    }
}

