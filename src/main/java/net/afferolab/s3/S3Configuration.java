package net.afferolab.s3;

import lombok.Getter;
import lombok.Setter;
import net.afferolab.Configuration;

@Getter
@Setter
public class S3Configuration extends Configuration {

    private String accessKeyId;

    private String secretKey;

    private String bucket;

    private String bucketUrl;

    private String endpoint;

    private String baseFolder;

    private String region;

}
