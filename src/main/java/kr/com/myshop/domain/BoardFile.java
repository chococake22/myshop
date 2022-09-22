package kr.com.myshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardFile {

    private Long boardFileIdx;
    private String filename;
    private String uuid;
    private String path;
    private String regUser;
    private String regDt;
    private String url;
    private Long noticeIdx;
}
