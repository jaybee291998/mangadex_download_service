package com.jaybee291998.mangadex_download_service.mangadex_download_service.downloader.service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.VolumeService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class VolumeDownloadService {
    @Autowired
    private ChapterDownloaderService chapterDownloaderService;
    @Autowired
    private VolumeService volumeService;

    public void downloadVolume(String mangaId, String volumeNumber, String outputPath, boolean seperateChapterFolder) throws IllegalAccessException {
        VolumeResultModel volumeResultModel = volumeService.getVolume(mangaId);
        VolumeModel volumeModel = volumeResultModel.getVolumes().containsKey(volumeNumber) ?
                volumeResultModel.getVolumes().get(volumeNumber) : null;
        if(volumeModel == null) {
            throw new IllegalAccessException("No such volume: " + volumeNumber);
        }
        Map<String, ChapterModel> chapters = volumeModel.getChapters();
        String basePath = outputPath + "/volume_" + StringUtil.padLeft(volumeNumber, 2, '0');
        chapters.keySet().forEach(key -> {
            ChapterModel chapter = chapters.get(key);
            String chapterId = chapter.getId();
            try {
                chapterDownloaderService.downloadChapter(chapterId, "chapter_" + StringUtil.padLeft(key, 2, '0'), basePath, seperateChapterFolder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
