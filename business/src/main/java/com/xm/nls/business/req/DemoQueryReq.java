package com.xm.nls.business.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoQueryReq {     // 封装请求实体
    private String name;
    private Integer age;
}
