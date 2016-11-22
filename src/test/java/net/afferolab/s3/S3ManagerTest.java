package net.afferolab.s3;

import net.afferolab.FileManager;
import org.junit.Test;

public class S3ManagerTest {


    private S3Configuration getConfiguration() {
        S3Configuration configuration = new S3Configuration();

        configuration.setAccessKeyId("");
        configuration.setSecretKey("");
        configuration.setBaseFolder("");
        configuration.setBucket("");
        configuration.setBucketUrl("");
        configuration.setRegion("");
        configuration.setEndpoint("");

        return configuration;
    }

    @Test(expected = NullPointerException.class)
    public void configurationCanNotBeNull() {
        //Init
        S3Configuration configuration = null;

        //Act
        FileManager manager = new S3Manager(configuration);
    }

}
