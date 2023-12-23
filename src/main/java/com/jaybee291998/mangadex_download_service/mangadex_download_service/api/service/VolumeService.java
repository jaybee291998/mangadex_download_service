package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.service;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.client.VolumeClient;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VolumeService {
    private final VolumeClient volumeClient;

    @Autowired
    public VolumeService(VolumeClient volumeClient) {
        this.volumeClient = volumeClient;
    }

    public VolumeResultModel getVolume(String mangaID) {
        return volumeClient.getVolume(mangaID);
    }
}
