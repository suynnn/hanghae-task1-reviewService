package org.hanghae.hanghaetask1reviewservice.common.s3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class DummyS3Service implements S3Service{

    @Override
    public String uploadFile(MultipartFile multipartFile) {

        String dummyUrl = "/" + multipartFile.getOriginalFilename();
        log.info("Dummy S3 upload: {}", dummyUrl);

        return dummyUrl;
    }
}
