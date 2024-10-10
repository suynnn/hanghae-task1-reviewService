package org.hanghae.hanghaetask1reviewservice.common.s3;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {
    String uploadFile(MultipartFile multipartFile);
}
