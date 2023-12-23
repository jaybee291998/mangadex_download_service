package com.jaybee291998.mangadex_download_service.mangadex_download_service.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ChapterMediaModel {
    private String hash;
    private String[] data;
    private String[] dataSaver;
}
