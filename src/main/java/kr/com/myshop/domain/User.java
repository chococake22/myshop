package kr.com.myshop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long userIdx;
    private String userId;
    private String password;
    private String username;
    private String email;
    private String phone;

    // 권한
    private String auth;

    // 주소
    private String siDo;
    private String siGunGu;
    private String eupMyeonDong;
    private String addrDetail;



}
