# 短信验证码
create table if not exists `sms_code`
(
    `id`         bigint      not null comment 'id',
    `mobile`     varchar(50) not null comment '手机号',
    `code`       varchar(6)  not null comment '验证码',
    `use`        varchar(20) not null comment '用途|枚举值',
    `status`     char(1)     not null comment '状态|枚举值',
    `updated_at` datetime    not null comment '修改时间',
    `created_at` datetime    not null comment '创建时间',
    primary key (`id`)
) engine = innodb
  default charset = utf8mb4 comment '短信验证码表';


