package kr.com.myshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search extends Page {

    private String searchType;
    private String keyword;
    private String blindYn;
    private String startDate;
    private String endDate;

}
