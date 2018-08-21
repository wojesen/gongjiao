CREATE TABLE IF NOT EXISTS user_info (
  `id` BIGINT(20) PRIMARY KEY COMMENT '自增主键' AUTO_INCREMENT,
  `username` VARCHAR(128) NOT NULL UNIQUE COMMENT '用户名',
  `password` VARCHAR(128) NOT NULL COMMENT '密码',
  `mobile` VARCHAR(11) UNIQUE COMMENT '手机号',
  `wx_code` VARCHAR(128) UNIQUE COMMENT '微信code',
  `open_id` VARCHAR(128) UNIQUE COMMENT '微信openId',
  `session_key` VARCHAR(128) UNIQUE COMMENT '微信sessionKey',
  `token` varchar(128) UNIQUE COMMENT '基于session_key生成的第三方key',
  `status` TINYINT DEFAULT 1 NOT NULL COMMENT '',
  `create_time` DATETIME DEFAULT now() COMMENT '创建时间',
  `update_time` DATETIME DEFAULT now() COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';