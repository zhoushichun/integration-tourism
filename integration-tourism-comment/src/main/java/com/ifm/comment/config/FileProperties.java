package com.ifm.comment.config;

import lombok.Data;

@Data
public class FileProperties {

    /** 文件大小限制 */
    private Long maxSize;

    /** 头像大小限制 */
    private Long avatarMaxSize;

    /** 路径 */
    private String path;
    /** 回显 */
    private String echo;
}
