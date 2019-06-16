package org.mushare.login.component;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.mushare.login.dao.OSSFileDao;
import org.mushare.login.domain.OSSFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Component
@Slf4j
public class AliyunOSSComponent {

    @Autowired
    private ConfigComponent config;

    @Autowired
    private OSSFileDao ossFileDao;

    private OSSClient createClient() {
        return new OSSClient(config.aliyunOSS.endpoint, config.aliyunOSS.accessKeyId, config.aliyunOSS.accessKeySecret);
    }

    public boolean upload(OSSFile ossFile) {
        return upload(ossFile, null, CannedAccessControlList.Default);
    }

    public boolean upload(OSSFile ossFile, String contentType) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(contentType);
        return upload(ossFile, metadata, CannedAccessControlList.Default);
    }

    public boolean upload(OSSFile ossFile, CannedAccessControlList acl) {
        return upload(ossFile, null, acl);
    }

    public boolean upload(OSSFile ossFile, ObjectMetadata metadata, CannedAccessControlList acl) {
        File file = new File(config.cachePath + ossFile.getPathname());
        if (!file.exists()) {
            // Delete the database reference if the file is not existing.
            ossFileDao.delete(ossFile);
            return false;
        }
        log.info("Upload " + ossFile.getPathname() + " to Aliyun OSS");
        OSSClient ossClient = createClient();
        try {
            ossClient.putObject(config.aliyunOSS.bucket, ossFile.getPathname(), new FileInputStream(file), metadata);
            ossClient.setObjectAcl(config.aliyunOSS.bucket, ossFile.getPathname(), acl);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            ossClient.shutdown();
            return false;
        }
        ossClient.shutdown();
        ossFile.setUploaded(true);
        ossFile.setUploadAt(System.currentTimeMillis());
        ossFileDao.save(ossFile);
        file.delete();
        return true;
    }

    public void delete(OSSFile OSSFile) {
        OSSClient ossClient = createClient();
        ossClient.deleteObject(config.aliyunOSS.bucket, OSSFile.getPathname());
        ossClient.shutdown();
    }

}
