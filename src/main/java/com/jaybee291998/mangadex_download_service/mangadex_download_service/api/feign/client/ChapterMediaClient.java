package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.client;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.configuration.ChapterMediaConfiguration;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterMediaResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId = "chapterClient", value = "mediaClient", url = "https://api.mangadex.org/at-home/server", configuration = ChapterMediaConfiguration.class)
public interface ChapterMediaClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{chapterId}")
    ChapterMediaResultModel getChapterMedia(@PathVariable("chapterId") String chapterId);
}
