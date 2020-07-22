package com.finance.service.impl.user.personal.avatar;

import com.finance.mapper.user.UserAvatarMapper;
import com.finance.pojo.user.UserAvatar;
import com.finance.pojo.user.UserAvatarExample;
import com.finance.service.user.personal.avatar.UserAvatarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.Date;
import java.util.UUID;


@Service
@PropertySource("classpath:/user.properties")
public class UserAvatarServiceImpl implements UserAvatarService {
    @Value("${user.avatar}")
    String userAvatar;

    private Logger log = LoggerFactory.getLogger(UserAvatarServiceImpl.class);

    @javax.annotation.Resource
    UserAvatarMapper userAvatarMapper;

    private UserAvatarServiceImpl() {
        if (userAvatar != null) {
            File file = new File(userAvatar);
            if (!file.exists()) {
                if (file.mkdirs()) {
                    log.info(userAvatar + "文件夹创建成功");
                } else {
                    throw new RuntimeException("文件夹创建失败");
                }
            }
        } else {
            throw new RuntimeException("没有找到系统存储路径");
        }
    }


    @Override
    public String generatorFilename(String _filename, String uuid) {
        int index = _filename.lastIndexOf(".");
        String __filename;
        String suffix;
        String prefix = uuid;
        if (index == -1) {
            __filename = _filename;
            suffix = "";
        } else {
            __filename = _filename.substring(0, index);
            suffix = _filename.substring(index);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(prefix)
                .append("_")
                .append(__filename)
                .append("_")
                .append(suffix);
        return sb.toString();
    }

    @Override
    public boolean uploadAvatar(MultipartFile file, String sysPath) {
        File sysFile = new File(userAvatar, sysPath);
        try (BufferedOutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(
                        sysFile))) {
            outputStream.write(file.getBytes());
            outputStream.flush();
            return true;
        } catch (FileNotFoundException e) {
            log.error("异常{}", e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Cacheable(cacheNames = "userAvatar", key = "#p0")
    public UserAvatar selectUserAvatarByUuid(String uuid) {
        return userAvatarMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public int insertAvatar(UserAvatar avatar) {
        avatar.setCreateTime(new Date());
        avatar.setLastUseTime(new Date());
        avatar.setStatus("1");
        UserAvatarExample userAvatarExample = new UserAvatarExample();
        UserAvatarExample.Criteria criteria = userAvatarExample.createCriteria();
        criteria.andStatusEqualTo("1");
        criteria.andUserIdEqualTo(avatar.getUserId());
        UserAvatar _updateAvatar = new UserAvatar();
        _updateAvatar.setStatus("0");
        int i = userAvatarMapper.updateByExampleSelective(_updateAvatar, userAvatarExample);
        if (i == 1) {
            return userAvatarMapper.insertSelective(avatar);
        } else {
            return 0;
        }
    }

    @Override
    public Resource getAvatar(String uuid) {
        UserAvatar userAvatar = selectUserAvatarByUuid(uuid);
        String avatar = userAvatar.getAvatar();
        return getResource(avatar);
    }

    private Resource getResource(String sysPath) {
        return new FileSystemResource(new File(userAvatar, sysPath));
    }
}
