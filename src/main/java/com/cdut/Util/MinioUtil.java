package com.cdut.Util;

import com.cdut.Config.MinioConfig;
import io.minio.MinioClient;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class MinioUtil {

    @Autowired
    private MinioConfig config;


    public MinioUtil() throws InvalidPortException, InvalidEndpointException {
    }

    public MinioConfig getConfig() {
        return config;
    }

    public void setConfig(MinioConfig config) {
        this.config = config;
    }


    public void createBucket(MinioClient client,String bucketName) throws IOException, InvalidKeyException, NoSuchAlgorithmException, InsufficientDataException, InternalException, NoResponseException, InvalidBucketNameException, XmlPullParserException, ErrorResponseException, RegionConflictException {
        if (!client.bucketExists(bucketName)) {
            client.makeBucket(bucketName);
        }
    }

    /**
     * 上传文件
     * @param file       文件
     * @param bucketName 存储桶
     * @return
     */
    public HashMap<String,String> uploadAvatar(String userId, MultipartFile file, String bucketName) throws Exception {
        MinioClient client=config.minioClient();
        HashMap<String,String> res = new HashMap<>();
        // 判断上传文件是否为空
        if (null == file || 0 == file.getSize()) {
            res.put("msg", "上传文件不能为空");
            return res;
        }
        try {
            // 判断存储桶是否存在
            createBucket(client,bucketName);
            // 文件名
            String originalFilename = file.getOriginalFilename();
            // 新的文件名 = 用户名_头像_时间戳.后缀名
            String fileName = userId + "_"+"Avator_" + System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 开始上传
            client.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
            res.put("user_Avator", config.getEndpoint() + "/" + bucketName + "/" + fileName);
            return res;
        }  catch (Exception e) {
            System.out.println("上传文件失败：{}"+e.getMessage());
        }
        res.put("msg", "上传失败");
        return res;
    }

    /**
     * 上传文件
     * @param file       文件
     * @param bucketName 存储桶
     * @return
     */
    public HashMap<String,String> uploadgoodsPicture(String goodId, MultipartFile file, String bucketName) throws Exception {
        MinioClient client=config.minioClient();
        HashMap<String,String> res = new HashMap<>();
        // 判断上传文件是否为空
        if (null == file || 0 == file.getSize()) {
            res.put("msg", "上传文件不能为空");
            return res;
        }
        try {
            // 判断存储桶是否存在
            createBucket(client,bucketName);
            // 文件名
            String originalFilename = file.getOriginalFilename();
            // 新的文件名 = 商品id_图片_时间.后缀名
            String fileName = goodId + "_"+"picture_" + System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));
            // 开始上传
            client.putObject(bucketName, fileName, file.getInputStream(), file.getContentType());
            //上传成功后才能执行放入map操作
            res.put("goods_picture", config.getEndpoint() + "/" + bucketName + "/" + fileName);
            return res;
        }  catch (Exception e) {
            System.out.println("上传文件失败：{}"+e.getMessage());
        }
        res.put("msg", "上传失败");
        return res;
    }
}




