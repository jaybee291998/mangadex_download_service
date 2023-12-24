package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ChapterModel {
    private String chapter;
    private String id;
    private String[] others;
    private int count;

    @Override
    public String toString() {
        return "ChapterModel{id: " + this.id + ", chapter: " + this.chapter + ", count: " + this.count + "}";
    }

    public double getChapterAsDouble() {
        return Double.parseDouble(chapter);
    }
}
