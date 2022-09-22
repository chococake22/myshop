package kr.com.myshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board extends Page {

    private Long boardIdx;
    private String title;
    private String content;
    private String blindYn;
    private String type;
    private String regUser;
    private String modUser;
    private String regDt;
    private String modDt;

}
