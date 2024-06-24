package com.github.notification.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

@Configuration
public class AmazonSnsConfiguration {

	@Value("${aws.accessKey}")
	private String accessKey;

	@Value("${aws.secretKey}")
	private String secretKey;
	
	private final Logger log = LoggerFactory.getLogger(AmazonSnsConfiguration.class);

	@Bean
	public AWSCredentials awsCredentials() {
		return new BasicAWSCredentials(accessKey, secretKey);
	}

    @Bean
    @Profile("!mock")
    public AmazonSNS amazonSNS() {
        try {
            return AmazonSNSClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(awsCredentials()))
                    .withRegion(Regions.US_EAST_1)
                    .build();
        } catch (Exception e) {
            log.error("Falha ao conectar na AWS", e);
            return null;
        }
    }

    @Bean
    @Profile("mock")
    public AmazonSNS amazonSnsMock() {
        return new AmazonSnsMock();
    }

}
