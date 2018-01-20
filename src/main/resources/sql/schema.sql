CREATE TABLE `pub_tenant_user_relation` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) DEFAULT NULL,
  `tenant_id` varchar(64) NOT NULL,
  `tenant_name` varchar(200) DEFAULT NULL,
  `dept_name` varchar(50) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `ts` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176901 DEFAULT CHARSET=utf8;