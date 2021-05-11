/**
 * Project: com.jcfx.gradeAll.teaching.common.utils
 * Title: UUIDUtil
 * @(#)UUIDUtil.java
 * Package com.jcfx.gradeAll.teaching.common.utils
 * CreatedDate: 2020/4/27 19:26
 * Description:
 * version V1.0
 * Copyright (c)  JCFX Co., Ltd.
 *
 * This software is the confidential and proprietary information of
 * JCFX Co., Ltd. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with
 * JCFX Co., Ltd.
*/

package com.ifm.comment.utils;

import java.util.UUID;


/**
 * @ClassName: UUIDUtil
 * @Description: <p> (UUIDUtil快速生成)</p>
 * @author：furao
 * @date: 2020/4/27 19:26
 * ${tags}$
 */
public class UUIDUtil {

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    
}
