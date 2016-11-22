package net.afferolab.s3;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import net.afferolab.FileManager;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;

public class S3Manager implements FileManager {


    private AmazonS3 s3Client;
    private S3Configuration configuration;

    public S3Manager(S3Configuration configuration) {

        Objects.requireNonNull(configuration);

        this.s3Client = new AmazonS3Client(new BasicAWSCredentials(
                configuration.getAccessKeyId(), configuration.getSecretKey()));

        this.s3Client.setRegion(Region.getRegion(Regions.fromName(configuration.getRegion())));

        this.configuration = configuration;
    }

    public URL uploadFile(File file, Optional<Integer> expiration) {

        Objects.requireNonNull(file);

        String fileName = String.format("%s%s", configuration.getBaseFolder(), file.getName());

        s3Client.putObject(new PutObjectRequest(configuration.getBucket(),
                fileName, file).withCannedAcl(CannedAccessControlList.PublicRead));

        return s3Client.generatePresignedUrl(String.format("/%s",
                configuration.getBucket()), fileName, configuration.getExpirationDate(expiration));
    }


}
