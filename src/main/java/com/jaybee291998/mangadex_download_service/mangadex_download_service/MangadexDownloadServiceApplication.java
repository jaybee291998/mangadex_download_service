package com.jaybee291998.mangadex_download_service.mangadex_download_service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterMediaResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.ChapterMediaService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.VolumeService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.downloader.service.ChapterDownloaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MangadexDownloadServiceApplication implements CommandLineRunner {

	@Autowired
	private VolumeService volumeService;
	@Autowired
	private ChapterMediaService chapterMediaService;
	@Autowired
	private ChapterDownloaderService chapterDownloaderService;

	public static void main(String[] args) {
		SpringApplication.run(MangadexDownloadServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		VolumeResultModel resultModel = volumeService.getVolume("0cb24b09-3885-4bbe-a2e6-d567e7db2d90");
		String outputPath = "C:/Users/63956/Documents/project/outputDir";
		String chapterName = "chapter_1";
		System.out.println(resultModel);
		resultModel.getResult();
		String chapterId = resultModel.getVolumes().get("1").getChapters().get("1").getId();
		chapterDownloaderService.downloadChapter(chapterId, chapterName, outputPath);
		ChapterMediaResultModel chapterMediaResultModel = chapterMediaService.getChapterMedia(chapterId);
	}
}
