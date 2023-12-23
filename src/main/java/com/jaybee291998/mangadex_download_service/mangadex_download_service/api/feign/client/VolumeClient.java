package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.client;

import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.feign.configuration.VolumeConfiguration;
import com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model.VolumeResultModel;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(contextId = "volumeClient", value="volumeClient", url="https://api.mangadex.org/manga", configuration=VolumeConfiguration.class)
public interface VolumeClient {
    @RequestMapping(method = RequestMethod.GET, value = "/{mangaID}/aggregate")
    @Headers("Accept: application/json")
    VolumeResultModel getVolume(@PathVariable("mangaID") String mangaID);
}
