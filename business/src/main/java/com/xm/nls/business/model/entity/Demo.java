package com.xm.nls.business.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Demo {
    private Integer id;

    private String name;

    private Integer age;

    private Date createdAt;
}