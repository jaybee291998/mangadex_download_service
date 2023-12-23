package com.jaybee291998.mangadex_download_service.mangadex_download_service.downloader.service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterMediaModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterMediaResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.ChapterMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ChapterDownloaderService {
    @Autowired
    private ChapterMediaService chapterMediaService;

    public void downloadChapter(String chapterId, String chapterName, String outputPath) throws IOException {
        ChapterMediaResultModel chapterMediaResultModel = chapterMediaService.getChapterMedia(chapterId);
        String baseUrl = chapterMediaResultModel.getBaseUrl() + "/data-saver";
        ChapterMediaModel chapterMediaModel = chapterMediaResultModel.getChapter();
        String hash = chapterMediaModel.getHash();
        String[] dataSaverPanel = chapterMediaModel.getDataSaver();
        String basePath = outputPath + "/" + chapterName;
        Files.createDirectories(Paths.get(basePath));
        for(int i = 0; i < dataSaverPanel.length; i++) {
            String panelName = dataSaverPanel[i];
            String[] split = panelName.split("\\.");
            if(split.length < 1) {
                throw new IllegalArgumentException("malformed chapter name");
            }
            String imageType = split[1];
            String finalUrl = baseUrl + "/" + hash + "/" + panelName;
            String outputFile = basePath + "/" + i + "." + imageType;
            try {
                downloadPanel(finalUrl, outputFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void downloadPanel(String urlStr, String outputFile) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}
