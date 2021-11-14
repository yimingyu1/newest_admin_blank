### 数据表
## category
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `parent_id` int NOT NULL DEFAULT '0' COMMENT '父类别id',
  `category_name` varchar(64) NOT NULL COMMENT '类别名称',
  `category_type` tinyint(1) NOT NULL COMMENT '类型',
  `weight` int NOT NULL COMMENT '权重',
  `deleted` tinyint(1) NOT NULL COMMENT '是否删除 0:未删除，1:已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

## user
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) NOT NULL COMMENT '用户名',
  `user_pwd` varchar(128) NOT NULL COMMENT '密码',
  `deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否已删除  0:未删除 1:已删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

## product
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(128) NOT NULL DEFAULT 'xxx商品' COMMENT '商品名',
  `product_desc` text NOT NULL COMMENT '商品描述',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '商品价格',
  `status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否上架 0：下架 1：已上架',
  `product_imp_price` text NOT NULL COMMENT '商品图片连接',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

