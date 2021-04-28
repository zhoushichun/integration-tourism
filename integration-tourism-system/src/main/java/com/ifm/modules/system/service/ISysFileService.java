
package com.ifm.modules.system.service;

import com.ifm.comment.base.service.BaseService;
import com.ifm.modules.system.entity.SysFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
*
*@ClassName:本地存储 服务类
*@Description:
*@author: zhou
*@date 2021-01-21
*
*/
public interface ISysFileService extends BaseService<SysFile> {

    List  uploadPictures(MultipartFile[] files);
}
