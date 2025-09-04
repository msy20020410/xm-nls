package com.xm.nls.business.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoQueryResp {     // 封装响应实体
    private Integer id;
    private String name;
    private Integer age;
}
