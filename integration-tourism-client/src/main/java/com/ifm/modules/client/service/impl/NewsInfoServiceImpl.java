
package com.ifm.modules.client.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.entity.NewsInfo;
import com.ifm.comment.entity.ScenicAnnouncement;
import com.ifm.modules.client.entity.Announcement;
import com.ifm.modules.client.entity.News;
import com.ifm.modules.client.mapper.NewsInfoMapper;
import com.ifm.modules.client.service.INewsInfoService;
import com.ifm.modules.client.service.IScenicAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:新闻信息 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-04-29
 */
@Service
public class NewsInfoServiceImpl extends BaseServiceImpl<NewsInfoMapper, NewsInfo> implements INewsInfoService {
    @Autowired
    IScenicAnnouncementService scenicAnnouncementService;

    @Override
    public List<NewsInfo> lists() {
        QueryWrapper<NewsInfo> queryWrapper = new QueryWrapper<>();
        //查询前2条数据
        queryWrapper.orderByDesc("update_date").last("limit 2");
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List listNews() {

        ArrayList<Object> objects = new ArrayList<>();

        List<NewsInfo> lists = lists();

        for (NewsInfo list : lists) {
            News news = new News();
            news.setTitle(list.getTitle());
            news.setCategory(list.getCategory());
            news.setValue(list.getValue());
            objects.add(news);
        }

        ScenicAnnouncement scenicAnnouncement = scenicAnnouncementService.lists();
        Announcement announcement = new Announcement();
        if (scenicAnnouncement == null) {
            return objects;
        } else {
            announcement.setCategory(scenicAnnouncement.getCategory());
            announcement.setTitle(scenicAnnouncement.getTitle());
            announcement.setUpdateDate(scenicAnnouncement.getUpdateDate());
            announcement.setPictureAdds(scenicAnnouncement.getPictureAdds());
            announcement.setValue(scenicAnnouncement.getValue());
            objects.add(announcement);
            return objects;
        }

    }
}
