package com.jaybee291998.mangadex_download_service.mangadex_download_service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.ChapterMediaResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.ChapterMediaService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service.VolumeService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.downloader.service.ChapterDownloaderService;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.downloader.service.VolumeDownloadService;
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
	@Autowired
	private VolumeDownloadService volumeDownloadService;

	public static void main(String[] args) {
		SpringApplication.run(MangadexDownloadServiceApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length < 4) {
			return;
		}
		String mangaId = args[0];
		String volumeNumber = args[1];
		String outputPath = args[2];
		boolean separateChapterFolder = args[3].equalsIgnoreCase("Y");
		volumeDownloadService.downloadVolume(mangaId, volumeNumber, outputPath, separateChapterFolder, "en");
	}
}
