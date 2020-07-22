package com.finance.service.user.personal.avatar;

import com.finance.pojo.user.UserAvatar;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface UserAvatarService {

    String generatorFilename(String _filename,String uuid);

    boolean uploadAvatar(MultipartFile file, String sysPath);

    Resource getAvatar(String uuid);

    UserAvatar selectUserAvatarByUuid(String uuid);

    int insertAvatar(UserAvatar avatar);
}
