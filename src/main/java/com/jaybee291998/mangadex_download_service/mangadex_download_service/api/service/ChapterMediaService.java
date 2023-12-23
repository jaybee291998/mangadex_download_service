package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.client.ChapterMediaClient;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterMediaResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChapterMediaService {
    private final ChapterMediaClient client;

    @Autowired
    public ChapterMediaService(ChapterMediaClient client) {
        this.client = client;
    }
    public ChapterMediaResultModel getChapterMedia(String chapterId) {
        return client.getChapterMedia(chapterId);
    }
}
