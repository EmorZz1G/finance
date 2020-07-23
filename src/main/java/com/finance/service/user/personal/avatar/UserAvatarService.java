package com.finance.service.user.personal.avatar;

import com.finance.pojo.user.UserAvatar;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserAvatarService {

    String generatorFilename(String _filename,String uuid);

    boolean deleteFile(String sysFilename);

    boolean uploadAvatar(MultipartFile file, String sysPath);

    Resource getAvatar(String uuid);

    UserAvatar selectUserAvatarByUuid(String uuid);

    int insertAvatar(UserAvatar avatar);

    UserAvatar getUsingAvatar(int userId);

    List<UserAvatar> selectUserHistoryAvatars(int userId);

    boolean updateUserAvatar(int userId, String newAvatarUuid);

//    int deleteUserAvatar(int userId,String deletedAvatarUuid);

    int deleteUserAvatar(String deletedAvatarUuid);
}
