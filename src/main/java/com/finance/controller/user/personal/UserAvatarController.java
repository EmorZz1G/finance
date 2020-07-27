package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.common.annotation.FileTypeAnno;
import com.finance.common.annotation.UserAvatarAnno;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserAvatar;
import com.finance.service.user.personal.avatar.UserAvatarService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserAvatarController {

    @Autowired
    UserAvatarService userAvatarService;

    @GetMapping("/user/personal/toAvatar.html")
    public String toAvatar(){
        return "user/personal/avatar";
    }

    /**
     * 上传头像
     * @param avatar：图片
     * @param user：当前登录用户实体
     * @return
     */
    @PostMapping("/user/userAvatar")
    @ResponseBody
    @UserAvatarAnno
    @FileTypeAnno(includes = {".jpg",".png",".jpeg"})
    public Result uploadAvatar(@RequestParam("avatar") MultipartFile avatar,
                               @SessionAttribute("loginUser") User user){
        String filename = avatar.getOriginalFilename();
        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setUserId(user.getId());
        String uuid = UUID.randomUUID().toString();
        String sysFilename = userAvatarService.generatorFilename(filename, uuid);
        userAvatarService.uploadAvatar(avatar,sysFilename);
        userAvatar.setUuid(uuid);
        userAvatar.setAvatar(sysFilename);
        int i = userAvatarService.insertAvatar(userAvatar);
        if (i==1){
            return Result.success("上传成功").add("avatar",uuid);
        }else {
            return Result.failure("上传失败");
        }
    }

    /**
     * 查询头像信息
     * @param uuid：用户历史上传头像id
     * @return
     * @throws IOException
     */
    @GetMapping("/user/userAvatar/{uuid}")
    @ResponseBody
    public ResponseEntity<Resource> getUserAvatar(@PathVariable("uuid") String uuid) throws IOException {
        Resource avatar = userAvatarService.getAvatar(uuid);
        if(avatar!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(avatar.contentLength())
                    .header("Cache-Control", "max-age=604800")
                    .body(avatar);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 修改头像
     * @param uuid：用户历史上传头像id
     * @param user：当前登录用户实体
     * @return
     */
    @PutMapping("/user/userAvatar/{uuid}")
    @ResponseBody
    @UserAvatarAnno
    public Result deleteUserAvatar(@PathVariable("uuid")String uuid,
                                   @SessionAttribute("loginUser")User user){
        boolean b = userAvatarService.updateUserAvatar(user.getId(), uuid);
        if (b){
            return Result.success("修改成功");
        }else {
            return Result.failure("修改失败");
        }
    }

    /**
     * 删除已上传头像
     * @param uuid：用户历史上传头像id
     * @return
     */
    @DeleteMapping("/user/userAvatar/{uuid}")
    @ResponseBody
    public Result deleteUserAvatar(@PathVariable("uuid")String uuid){
        int i = userAvatarService.deleteUserAvatar(uuid);
        if (i==1){
            return Result.success("删除成功");
        }else {
            return Result.failure("删除失败");
        }
    }

    /**
     * 查询历史头像
     * @param user：当前登录用户实体
     * @return
     */
    @GetMapping("user/userAvatar")
    @ResponseBody
    public Result getUserHistoryAvatar(@SessionAttribute("loginUser") User user){
        List<UserAvatar> userAvatars = userAvatarService.selectUserHistoryAvatars(user.getId());
        if(userAvatars!=null){
            return Result.success("查询成功").add("avatars",userAvatars);
        }else {
            return Result.failure("没有查询到您的历史头像");
        }
    }
}
