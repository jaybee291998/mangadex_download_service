package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class VolumeModel {
    private String volume;
    private int count;
    private Map<String, ChapterModel> chapters;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("VolumeModel{");
        sb.append("volume: " + volume + ", ");
        sb.append("count: " + count + ", \n");
        sb.append("chapters: [");
        for(String chapterNumber : chapters.keySet()) {
            ChapterModel chapterModel = chapters.get(chapterNumber);
            sb.append(chapterModel + ",\n");
        }
        sb.append("]}");
        return sb.toString();
    }
}
