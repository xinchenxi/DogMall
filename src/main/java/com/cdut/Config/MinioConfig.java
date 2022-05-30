package com.cdut.Config;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;
import org.springframework.beans.factory.annotation.Value;


public class MinioConfig {

    /**
     * 连接url
     */
    @Value("${minio.endpoint}")
    private String endpoint;
    /**
     * 用户名
     */
    @Value("${minio.accessKey}")
    private String accesskey;
    /**
     * 密码
     */
    @Value("${minio.secretKey}")
    private String secretKey;

    public MinioClient minioClient()throws InvalidPortException, InvalidEndpointException {
        return new MinioClient(this.getEndpoint(),this.getAccesskey(),this.getSecretKey());
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccesskey() {
        return accesskey;
    }

    public void setAccesskey(String accesskey) {
        this.accesskey = accesskey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

}
