package com.finance.controller.user.personal;


import com.finance.common.Result;
import com.finance.common.annotation.UserAvatarAnno;
import com.finance.pojo.user.User;
import com.finance.pojo.user.UserAvatar;
import com.finance.service.user.personal.avatar.UserAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Controller
public class UserAvatarController {

    @Autowired
    UserAvatarService userAvatarService;

    @GetMapping("/user/personal/toAvatar.html")
    public String toAvatar(){
        return "user/personal/avatar";
    }

    @PostMapping("/user/userAvatar")
    @ResponseBody
    @UserAvatarAnno
    public Result uploadAvatar(@RequestParam("avatar") MultipartFile avatar,
                               @SessionAttribute("loginUser") User user){
        UserAvatar userAvatar = new UserAvatar();
        userAvatar.setUserId(user.getId());
        String uuid = UUID.randomUUID().toString();
        String sysFilename = userAvatarService.generatorFilename(avatar.getOriginalFilename(), uuid);
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

    @GetMapping("/user/userAvatar/{uuid}")
    @ResponseBody
    public ResponseEntity<Resource> getUserAvatar(@PathVariable("uuid") String uuid) throws IOException {
        Resource avatar = userAvatarService.getAvatar(uuid);
        if(avatar!=null){
            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .contentLength(avatar.contentLength())
                    .body(avatar);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
