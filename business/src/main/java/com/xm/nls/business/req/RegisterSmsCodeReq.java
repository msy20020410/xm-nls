package com.xm.nls.business.req;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterSmsCodeReq {

    @NotBlank(message = "[手机号] 不能为空!")
    private String mobile;
}
