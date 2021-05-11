
package com.ifm.modules.client.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.*;
import com.ifm.comment.utils.TimeUtils;
import com.ifm.modules.client.entity.UserInfo;
import com.ifm.modules.client.entity.vo.*;
import com.ifm.modules.client.mapper.ScenicSpotPriceMapper;
import com.ifm.modules.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName:景区-价格 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-05-06
 */
@Service
public class ScenicSpotPriceServiceImpl extends BaseServiceImpl<ScenicSpotPriceMapper, ScenicSpotPrice> implements IScenicSpotPriceService {


    @Autowired
    ISysScenicSpotService sysScenicSpotService;

    @Autowired
    IPictureRelevanceService pictureRelevanceService;

    @Autowired
    IProjectEvaluationService projectEvaluationService;

    @Autowired
    IProjectLabelService projectLabelService;

    @Autowired
    ITouristInfoService touristInfoService;

    @Autowired
    IUserInfoService userInfoService;

    @Override
    public List<ScenicSpotPrice> listAll() {
        QueryWrapper<ScenicSpotPrice> queryWrapper = new QueryWrapper<>();
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public ScenicSpotProjectVo scenicSpotReserve(Long id) {


        ScenicSpotProjectVo scenicSpotProjectVo = new ScenicSpotProjectVo();
        SysScenicSpot sysScenicSpot = sysScenicSpotService.scenicSpotInfo(id);
        if (sysScenicSpot == null) {
            return scenicSpotProjectVo;
        }

        //景点ID
        scenicSpotProjectVo.setScenicSpotId(sysScenicSpot.getId());
        //景点名称
        scenicSpotProjectVo.setScenicSpotName(sysScenicSpot.getName());
        //景点地址
        scenicSpotProjectVo.setAddress(sysScenicSpot.getAddress());
        //营业时间
        scenicSpotProjectVo.setBusinessHours(sysScenicSpot.getBusinessHours());

        EvaluationVo evaluationVo = projectEvaluationService.listAlls(id);

        //评论条数
        scenicSpotProjectVo.setEvaluationNum(evaluationVo.getEvaluationNum());
        //平均分
        scenicSpotProjectVo.setScore(evaluationVo.getScore());

        //获取景区图片
        List<PictureRelevance> pictureRelevances = pictureRelevanceService.listAllById(sysScenicSpot.getId());
        if (pictureRelevances.size() == 0) {
            scenicSpotProjectVo.setPictureAdds(null);
        } else {
            ArrayList<String> strings = new ArrayList<>();
            for (PictureRelevance pictureRelevance : pictureRelevances) {
                strings.add(pictureRelevance.getEcho());
            }
            //景点图片
            scenicSpotProjectVo.setPictureAdds(strings);
        }

        //获取今天的时间
        Date dayBegin = TimeUtils.getDayBegin();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String format = dateFormat.format(dayBegin);

        QueryWrapper<ScenicSpotPrice> queryWrapper = new QueryWrapper<>();

        queryWrapper.eq("scenic_spot_id", id).eq("status", 0).eq("deleted", 0).eq("date", format);

        List<ScenicSpotPrice> scenicSpotPrices = baseMapper.selectList(queryWrapper);

        //价格
        if (scenicSpotPrices.size() == 0) {
            scenicSpotProjectVo.setScenicSpotPriceVo(null);
        } else {
            //价格
            ArrayList<ScenicSpotPriceVo> objects = new ArrayList<>();
            for (ScenicSpotPrice scenicSpotPrice : scenicSpotPrices) {
                ScenicSpotPriceVo scenicSpotPriceVo = new ScenicSpotPriceVo();
                scenicSpotPriceVo.setPrice(scenicSpotPrice.getPrice());
                scenicSpotPriceVo.setId(scenicSpotPrice.getId());
                scenicSpotPriceVo.setTicketName(scenicSpotPrice.getTicketName());
                scenicSpotPriceVo.setScenicSpotId(scenicSpotPrice.getScenicSpotId());
                objects.add(scenicSpotPriceVo);
            }
            scenicSpotProjectVo.setScenicSpotPriceVo(objects);
        }


        //获取最新评论的前2条
        List<ProjectEvaluation> projectEvaluations = projectEvaluationService.listAll(id);

        if (projectEvaluations.size() == 0) {

            scenicSpotProjectVo.setProjectEvaluations(null);
        } else {
            ArrayList<ProjectEvaluationVo> projectEvaluationVos = new ArrayList<>();

            for (ProjectEvaluation projectEvaluation : projectEvaluations) {

                ProjectEvaluationVo projectEvaluationVo = new ProjectEvaluationVo();

                //昵称
                UserInfo userInfo = userInfoService.QueryUser(projectEvaluation.getAccountId());

                projectEvaluationVo.setNickName(userInfo.getNickName());

                //评价时间
                projectEvaluationVo.setEvaluationTime(projectEvaluation.getCreateDate());

                projectEvaluationVo.setAccountId(projectEvaluation.getAccountId());
                //头像
                projectEvaluationVo.setHeadPortrait(userInfo.getAvatarName());
                //评论内容
                projectEvaluationVo.setEvaluationContent(projectEvaluation.getEvaluationContent());
                //id
                projectEvaluationVo.setId(projectEvaluation.getId());
                //分数
                projectEvaluationVo.setScore(projectEvaluation.getScore());
                List<PictureRelevance> pictureRelevances1 = pictureRelevanceService.listAllById(projectEvaluation.getId());
                if (pictureRelevances1.size() == 0) {
                    projectEvaluationVo.setEvaluationAdds(null);
                } else {
                    projectEvaluationVo.setEvaluationAdds(pictureRelevances1.get(0).getEcho());
                }
                projectEvaluationVos.add(projectEvaluationVo);
            }
            //景点评论
            scenicSpotProjectVo.setProjectEvaluations(projectEvaluationVos);
        }

        List<ProjectLabel> projectLabels = projectLabelService.listLabel(id);
        if (projectLabels.size() == 0) {
            scenicSpotProjectVo.setLabel(null);

        } else {
            ArrayList<String> strings = new ArrayList<>();
            for (ProjectLabel projectLabel : projectLabels) {
                strings.add(projectLabel.getLabelName());
            }
            scenicSpotProjectVo.setLabel(strings);
        }

        return scenicSpotProjectVo;
    }

    @Override
    public ScenicSpotAppointmentVo scenicSpotAppointment(Long id, Long accountId) {

        ScenicSpotAppointmentVo scenicSpotAppointmentVo = new ScenicSpotAppointmentVo();
        QueryWrapper<ScenicSpotPrice> queryWrapper = new QueryWrapper<>();
        //获取今天的时间
        Date dayBegin = TimeUtils.getDayBegin();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        String format = dateFormat.format(dayBegin);

        queryWrapper.eq("scenic_spot_id", id).eq("status", 0).eq("deleted", 0);
        //查询大于等于今天的数据
        queryWrapper.ge("date", format);

        List<ScenicSpotPrice> scenicSpotPrices = baseMapper.selectList(queryWrapper);
        if (scenicSpotPrices.size() == 0) {
            return scenicSpotAppointmentVo;
        }

        scenicSpotAppointmentVo.setScenicSpotId(id);
        ArrayList<DatePrice> datePrices = new ArrayList<>();
        for (ScenicSpotPrice scenicSpotPrice : scenicSpotPrices) {
            DatePrice datePrice = new DatePrice();
            datePrice.setId(scenicSpotPrice.getId());
            datePrice.setDate(scenicSpotPrice.getDate());
            datePrice.setPrice(scenicSpotPrice.getPrice());
            datePrices.add(datePrice);
            scenicSpotAppointmentVo.setTicketName(scenicSpotPrice.getTicketName());
        }
        scenicSpotAppointmentVo.setDatePrice(datePrices);
        //游客信息
        ArrayList<Tourist> objects = new ArrayList<>();

        //账号id
        List<TouristInfo> touristInfos = touristInfoService.listTourist(accountId);
        if (touristInfos.size() == 0 || touristInfos == null) {
            scenicSpotAppointmentVo.setTourist(objects);
        } else {
            for (TouristInfo touristInfo : touristInfos) {
                Tourist tourist = new Tourist();
                tourist.setId(touristInfo.getId());
                tourist.setCertificateNum(touristInfo.getCertificateNum());
                tourist.setPhoneNumber(touristInfo.getPhoneNumber());
                tourist.setTouristName(touristInfo.getTouristName());
                objects.add(tourist);
            }
            scenicSpotAppointmentVo.setTourist(objects);
        }

        return scenicSpotAppointmentVo;
    }

    @Override
    public ScenicSpotPrice scenicSpotDate(Long id) {
        QueryWrapper<ScenicSpotPrice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id).eq("status", 0).eq("deleted", 0);
        return baseMapper.selectOne(queryWrapper);
    }


}
