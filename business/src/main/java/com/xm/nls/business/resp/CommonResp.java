package com.xm.nls.business.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResp<T> {    // 统一响应实体
    private boolean success = true;
    private String message;
    private T content;

    public CommonResp(T content) {
        this.content = content;
    }
}
