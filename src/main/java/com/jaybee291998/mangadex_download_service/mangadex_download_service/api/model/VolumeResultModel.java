package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class VolumeResultModel {
    private String result;
    private Map<String, VolumeModel> volumes;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VolumeResultModel{");
        sb.append("result: " + result + ",\n");
        sb.append("volumes: [");
        for(String volumeNumber : volumes.keySet()) {
            VolumeModel volumeModel = volumes.get(volumeNumber);
            sb.append(volumeModel + ",\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
