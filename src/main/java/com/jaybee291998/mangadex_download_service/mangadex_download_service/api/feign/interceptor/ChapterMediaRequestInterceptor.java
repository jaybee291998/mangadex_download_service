package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ChapterMediaRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        System.out.println("ChapterMedia client called");
    }
}
