package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.configuration;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.interceptor.ChapterMediaRequestInterceptor;
import org.springframework.context.annotation.Bean;

public class ChapterMediaConfiguration {
    @Bean
    public ChapterMediaRequestInterceptor chapterMediaRequestInterceptor() {
        return new ChapterMediaRequestInterceptor();
    }
}
