package com.jaybee291998.mangadex_download_service.mangadex_download_service.downloader.service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.VolumeService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
public class VolumeDownloadService {
    @Autowired
    private ChapterDownloaderService chapterDownloaderService;
    @Autowired
    private VolumeService volumeService;

    public void downloadVolume(String mangaId, String volumeNumber, String outputPath, boolean seperateChapterFolder, String language) throws IllegalAccessException {
        VolumeResultModel volumeResultModel = volumeService.getVolume(mangaId, language);
        VolumeModel volumeModel = volumeResultModel.getVolumes().containsKey(volumeNumber) ?
                volumeResultModel.getVolumes().get(volumeNumber) : null;
        if(volumeModel == null) {
            throw new IllegalAccessException("No such volume: " + volumeNumber);
        }
        Map<String, ChapterModel> chaptersMap = volumeModel.getChapters();
        List<ChapterModel> chapters = new ArrayList<>();
        chaptersMap.keySet().forEach(chapterNumer -> {
            chapters.add(chaptersMap.get(chapterNumer));
        });
        chapters.sort(Comparator.comparingDouble(ChapterModel::getChapterAsDouble));
        // volume folder name
        String basePath = outputPath + "/volume_" + StringUtil.padLeft(volumeNumber, 2, '0');
        for(int i = 0; i < chapters.size(); i++) {
            ChapterModel chapterModel = chapters.get(i);
            String chapterId = chapterModel.getId();
            try {
                // chapter folder name
                chapterDownloaderService.downloadChapter(chapterId, "chapter_" + StringUtil.padLeft(i+"", 4, '0'), basePath, seperateChapterFolder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
