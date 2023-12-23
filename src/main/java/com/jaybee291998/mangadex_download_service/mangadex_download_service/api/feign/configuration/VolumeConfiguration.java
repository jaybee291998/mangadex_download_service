package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.configuration;

//import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.client.VolumeDecoder;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.interceptor.VolumeRequestInterceptor;
//import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;

public class VolumeConfiguration {
    @Bean
    public VolumeRequestInterceptor volumeRequestInterceptor() {
        return new VolumeRequestInterceptor();
    }
}
