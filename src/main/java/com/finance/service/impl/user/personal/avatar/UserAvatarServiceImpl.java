package com.finance.service.impl.user.personal.avatar;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.finance.mapper.plus.user.UserAvatarMapperPlus;
import com.finance.mapper.user.UserAvatarMapper;
import com.finance.pojo.user.UserAvatar;
import com.finance.pojo.user.UserAvatarExample;
import com.finance.service.user.personal.avatar.UserAvatarService;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@PropertySource("classpath:/config/user.properties")
public class UserAvatarServiceImpl implements UserAvatarService, InitializingBean {
    @Value("${user.user-avatar}")
    String userAvatar;
    @javax.annotation.Resource
    UserAvatarMapper userAvatarMapper;
    @javax.annotation.Resource
    UserAvatarMapperPlus userAvatarMapperPlus;
    private Logger log = LoggerFactory.getLogger(UserAvatarServiceImpl.class);

    @Override
    public void afterPropertiesSet() throws Exception {
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

        if (index == -1) {
            __filename = _filename;
            suffix = "";
        } else {
            __filename = _filename.substring(0, index);
            suffix = _filename.substring(index);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(__filename)
                .append("_")
                .append(uuid)
                .append(suffix);
        return sb.toString();
    }

    @Override
    public boolean deleteFile(String sysFilename) {
        File file = new File(userAvatar, sysFilename);
        if (file.isFile()) {
            return file.delete();
        }
        return false;
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
//        return userAvatarMapper.selectByPrimaryKey(uuid);
        return userAvatarMapperPlus.selectById(uuid);
    }

    @Override
    public int insertAvatar(UserAvatar avatar) {
        avatar.setCreateTime(LocalDateTime.now());
        avatar.setLastUseTime(LocalDateTime.now());
        avatar.setStatus("1");
        /*UserAvatarExample userAvatarExample = new UserAvatarExample();
        UserAvatarExample.Criteria criteria = userAvatarExample.createCriteria();
        criteria.andStatusEqualTo("1");
        criteria.andUserIdEqualTo(avatar.getUserId());*/
        UserAvatar _updateAvatar = new UserAvatar();
        _updateAvatar.setStatus("0");
        userAvatarMapperPlus.update(_updateAvatar, new UpdateWrapper<UserAvatar>().lambda()
                .eq(UserAvatar::getStatus, "1")
                .eq(UserAvatar::getUserId, avatar.getUserId()));
//        userAvatarMapper.updateByExampleSelective(_updateAvatar, userAvatarExample);
//        return userAvatarMapper.insertSelective(avatar);
        return userAvatarMapperPlus.insert(avatar);
    }

    @Override
    public UserAvatar getUsingAvatar(int userId) {
        /*UserAvatarExample userAvatarExample = new UserAvatarExample();
        UserAvatarExample.Criteria criteria = userAvatarExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo("1");*/
        List<UserAvatar> userAvatars;
        /*= userAvatarMapperPlus.selectList(new QueryWrapper<UserAvatar>()
                .eq("userId", userId)
                .eq("status", "1"));*/
        userAvatars = userAvatarMapperPlus.selectList(new QueryWrapper<UserAvatar>().lambda()
        .eq(UserAvatar::getUserId,userId)
        .eq(UserAvatar::getStatus,"1"));
        if (userAvatars == null) {
            return null;
        } else if (userAvatars.size() > 1) {
            throw new RuntimeException("用户头像中，数据库数据存在问题，status应该只有一个为1");
        } else if (userAvatars.size() == 1) {
            return userAvatars.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<UserAvatar> selectUserHistoryAvatars(int userId) {
        /*UserAvatarExample userAvatarExample = new UserAvatarExample();
        UserAvatarExample.Criteria criteria = userAvatarExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andStatusEqualTo("0");
        userAvatarExample.setOrderByClause("createTime asc");
        return userAvatarMapper.selectByExample(userAvatarExample);*/
        return userAvatarMapperPlus.selectList(new QueryWrapper<UserAvatar>()
                .eq("userId", userId)
                .eq("status", "0")
                .orderByAsc("createTime"));
    }

    @Override
    @Transactional
    public boolean updateUserAvatar(int userId, String newAvatarUuid) {
        /*UserAvatarExample userAvatarExample = new UserAvatarExample();
        UserAvatarExample.Criteria criteria = userAvatarExample.createCriteria();
        criteria.andStatusEqualTo("1");
        criteria.andUserIdEqualTo(userId);*/
        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setStatus("0");
        int i = userAvatarMapperPlus.update(userAvatar, new UpdateWrapper<UserAvatar>()
        .eq("status","1")
        .eq("userId",userId));

        if (i != 1) {
            throw new RuntimeException("用户头像数据库异常，用户ID为 " + userId);
        }
        userAvatar.setStatus("1");
        userAvatar.setUuid(newAvatarUuid);
        userAvatar.setLastUseTime(LocalDateTime.now());
        return userAvatarMapperPlus.updateById(userAvatar) == 1;
    }

/*    @Override
    public int deleteUserAvatar(int userId, String deletedAvatarUuid) {
        UserAvatar userAvatar = userAvatarMapper.selectByPrimaryKey(deletedAvatarUuid);
        if(userAvatar==null){
            throw new RuntimeException("不存在这个主键，对于 "+deletedAvatarUuid);
        }
        int i = userAvatarMapper.deleteByPrimaryKey(deletedAvatarUuid);
        if(i==1){
            return deleteFile(userAvatar.getAvatar())?1:0;
        }
        return 0;
    }*/

    @Override
    @CacheEvict(cacheNames = "userAvatar", key = "#p0")
    public int deleteUserAvatar(String deletedAvatarUuid) {
        UserAvatar userAvatar = userAvatarMapperPlus.selectById(deletedAvatarUuid);
        if (userAvatar == null) {
            throw new RuntimeException("不存在这个主键，对于 " + deletedAvatarUuid);
        }
        int i = userAvatarMapper.deleteByPrimaryKey(deletedAvatarUuid);
        if (i == 1) {
            return deleteFile(userAvatar.getAvatar()) ? 1 : 0;
        }
        return 0;
    }

    @Override
    public Resource getAvatar(String uuid) {
        UserAvatar userAvatar = selectUserAvatarByUuid(uuid);
        String avatar;
        try {
            avatar = userAvatar.getAvatar();
        } catch (Exception e) {
            return null;
        }
        return getResource(avatar);
    }

    private Resource getResource(String sysPath) {
        return new FileSystemResource(new File(userAvatar, sysPath));
    }


}
