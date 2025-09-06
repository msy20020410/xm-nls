package com.xm.nls.business.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoQueryReq {     // 封装请求实体
    @NotBlank(message = "[姓名] 不能为空!")
    private String name;
}
