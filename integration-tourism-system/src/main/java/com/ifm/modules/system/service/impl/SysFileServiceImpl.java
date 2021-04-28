
package com.ifm.modules.system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ifm.comment.base.service.impl.BaseServiceImpl;
import com.ifm.comment.config.FileProperties;
import com.ifm.comment.exception.BadRequestException;
import com.ifm.comment.utils.FileUtil;
import com.ifm.modules.system.entity.SysFile;
import com.ifm.modules.system.mapper.SysFileMapper;
import com.ifm.modules.system.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName:本地存储 服务实现类
 * @Description:
 * @author: zhou
 * @date 2021-01-21
 */
@Service
public class SysFileServiceImpl extends BaseServiceImpl<SysFileMapper, SysFile> implements ISysFileService {

    @Autowired
    FileProperties fileProperties;

    @Value("${file.url}")
    String URL;

    @Override
    public List uploadPictures(MultipartFile[] files) {

        ArrayList<SysFile> arr = new ArrayList<>();
        for (MultipartFile multipartFile : files) {
            //文件大小
            FileUtil.checkSize(fileProperties.getMaxSize(), multipartFile.getSize());
            // 获取文件名multipartFile.getOriginalFilename()
            String fileName = multipartFile.getOriginalFilename();
            //获取文件后缀
            String suffix = FileUtil.getExtensionName(fileName);
            //根据文件后缀获取文件类型
            String type = FileUtil.getFileType(suffix);
            //文件上传
            //File.separator 相当于在路径后面加了一个\
            File file = FileUtil.upload(multipartFile, fileProperties.getPath() + type + File.separator);
            if (ObjectUtil.isNull(file)) {
                throw new BadRequestException("上传失败");
            }
            try {
                String name = FileUtil.getFileNameNoEx(multipartFile.getOriginalFilename());
                SysFile sysFile = new SysFile();
                sysFile.setRealName(file.getName());
                sysFile.setName(name);
                sysFile.setSuffix(suffix);
                String echo = URL + type + "/" + file.getName();
                sysFile.setEcho(echo);
                sysFile.setPath(file.getPath());
                sysFile.setType(type);
                sysFile.setSize(FileUtil.getSize(multipartFile.getSize()));
                arr.add(sysFile);
            } catch (Exception e) {
                FileUtil.del(file);
                throw e;
            }

        }
        ArrayList<String> strings = new ArrayList<>();

        for (SysFile sysFile : arr) {
            baseMapper.insert(sysFile);
            strings.add(sysFile.getEcho());
        }
        return strings;

    }
}
