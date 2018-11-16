/* 1、创建网站配置信息表*/

DROP TABLE IF EXISTS `sys_web_config`;
CREATE TABLE `sys_web_config`(
  `id` INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  `web_title` VARCHAR(150) NOT NULL COMMENT '标题',
  `web_link` VARCHAR(250) DEFAULT NULL COMMENT '链接地址',
  `web_email` VARCHAR(100) DEFAULT NULL COMMENT '电子邮件',
  `web_logo_image` VARCHAR(250) DEFAULT NULL COMMENT 'logo图片链接地址',
  `web_add` VARCHAR(100) DEFAULT NULL COMMENT '地址',
  `web_tel` VARCHAR(50) DEFAULT NULL COMMENT '电话',
  `web_phone` VARCHAR(50) DEFAULT NULL COMMENT '手机',
  `web_fax` VARCHAR(50) DEFAULT NULL COMMENT '传真',
  `web_icp` VARCHAR(500) DEFAULT NULL COMMENT 'ICP备案信息',
  `web_copy_right` VARCHAR(250) DEFAULT NULL COMMENT '版权',
  `web_name` VARCHAR(150) DEFAULT NULL COMMENT '站点名称',
  `web_keyword` VARCHAR(500) DEFAULT NULL COMMENT '关键词设置',
  `web_link_icon` VARCHAR(500) DEFAULT NULL COMMENT '浏览器上显示的图标',
  `web_close_tip` VARCHAR(500) DEFAULT NULL COMMENT '关闭提示',
  `web_upload_path` VARCHAR(100) DEFAULT NULL COMMENT '上传文件目录',
  `web_skin` VARCHAR(150) DEFAULT NULL COMMENT '网站皮肤',
  `web_census_code` TEXT DEFAULT NULL COMMENT '统计代码',
  `web_status` INT(4) DEFAULT '1' COMMENT '配置状态是否可用 1 可用, 0 不可用',
  `web_desc` VARCHAR(500) DEFAULT NULL COMMENT '站点描述',
  `web_explain` VARCHAR(500) DEFAULT NULL COMMENT '说明',
  `web_header` TEXT DEFAULT NULL COMMENT '网站头部',
  `web_footer` TEXT DEFAULT NULL COMMENT '网站底部',
  `web_created` DATETIME  DEFAULT now() COMMENT '创建时间',
  `web_updated` DATETIME  DEFAULT now() COMMENT '最后登录时间'
)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;
/* 2、创建货运类型表*/
DROP TABLE IF EXISTS `tb_freight_type`;
CREATE TABLE `tb_freight_type` (
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  `frt_name` VARCHAR(50) NOT NULL COMMENT '名称',
  `frt_tel` VARCHAR(50) DEFAULT NULL COMMENT '电话',
  `frt_phone` VARCHAR(50) DEFAULT NULL COMMENT '手机',
  `frt_fax` VARCHAR(50) DEFAULT NULL COMMENT '传真',
  `frt_qq` VARCHAR(50) DEFAULT NULL COMMENT 'qq',
  `frt_email` VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  `frt_add` VARCHAR(100) DEFAULT NULL COMMENT '地址',
  `frt_explain` VARCHAR(250) DEFAULT NULL COMMENT '说明',
  `frt_created` DATETIME  DEFAULT now() COMMENT '创建时间',
  `frt_updated` DATETIME  DEFAULT now() COMMENT '最后登录时间'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 3、创建运输信息表*/
DROP TABLE IF EXISTS `tb_shipping_info`;
CREATE TABLE `tb_shipping_info` (
  `id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  `cust_id` BIGINT(20) NOT NULL COMMENT '顾客编号',
  `ship_name` VARCHAR(50) NOT NULL COMMENT '名称',
  `ship_tel` VARCHAR(50) DEFAULT NULL COMMENT '电话',
  `ship_phone` VARCHAR(50) DEFAULT NULL COMMENT '手机',
  `ship_province` VARCHAR(50) DEFAULT NULL COMMENT '省份',
  `ship_city` VARCHAR(50) DEFAULT NULL COMMENT '城市',
  `ship_district` VARCHAR(50) DEFAULT NULL COMMENT '区/县',
  `ship_address` VARCHAR(250) DEFAULT NULL COMMENT '地址',
  `ship_zip` VARCHAR(100) DEFAULT NULL COMMENT '邮编',
  `ship_created` DATETIME  DEFAULT NULL COMMENT '创建时间',
  `ship_updated` DATETIME  DEFAULT NULL COMMENT '最后登录时间'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


/* 5、创建仓库信息表*/
DROP TABLE IF EXISTS `tb_warehouse_info`;
CREATE TABLE `tb_warehouse_info` (
  `id` INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  `war_name` VARCHAR(50) NOT NULL COMMENT '名称',
  `war_tel` VARCHAR(50) DEFAULT NULL COMMENT '电话',
  `war_phone` VARCHAR(50) DEFAULT NULL COMMENT '手机',
  `war_add` VARCHAR(100) DEFAULT NULL COMMENT '地址',
  `war_qq` VARCHAR(50) DEFAULT NULL COMMENT 'QQ',
  `war_location` VARCHAR(50) DEFAULT NULL COMMENT '位置',
  `war_explain` VARCHAR(250) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


/* 6、创建品牌信息表 */
DROP TABLE IF EXISTS `tb_brand_info`;
CREATE TABLE `tb_brand_info` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  sup_id BIGINT NOT NULL COMMENT '供应商编号',
  brand_logo VARCHAR(150) DEFAULT NULL  COMMENT '品牌LOGO 图片大小120px*60px',
	brand_name VARCHAR(50) NOT NULL COMMENT '品牌名称',
  brand_area VARCHAR(50) NOT NULL COMMENT '所属地区',
  brand_seq INT(11) NOT NULL COMMENT '排序 从小到大',
  brand_status INT(4) DEFAULT '1' COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
	brand_explain VARCHAR(250) DEFAULT NULL COMMENT '品牌描述'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*5、创建供应商信息表*/
DROP TABLE IF EXISTS `tb_supplier_info`;
CREATE TABLE `tb_supplier_info` (
  id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
  sup_name VARCHAR(50) NOT NULL COMMENT '供应商名称',
  sup_login_name VARCHAR(50) NOT NULL COMMENT '供应商登录名',
  sup_avatar VARCHAR(150) DEFAULT NULL COMMENT '供应商头像地址',
  sup_pwd VARCHAR(100) NOT NULL COMMENT '密码',
  sup_tel VARCHAR(50) DEFAULT NULL COMMENT '电话',
  sup_phone VARCHAR(50) DEFAULT NULL COMMENT '手机',
  sup_add VARCHAR(100) DEFAULT NULL COMMENT '地址',
  sup_qq VARCHAR(50) DEFAULT NULL COMMENT 'qq',
  sup_fax VARCHAR(50) DEFAULT NULL COMMENT '传真',
  sup_email VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  sup_loc INT(11)  DEFAULT '0' COMMENT '登录次数',
  sup_status INT(4) DEFAULT '1' COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
  sup_created DATETIME  DEFAULT NULL COMMENT '创建时间',
  sup_updated DATETIME  DEFAULT NULL COMMENT '最后登录时间',
  sup_encrypt VARCHAR(50) DEFAULT NULL COMMENT '加密串',
  sup_last_ip VARCHAR(50) DEFAULT NULL COMMENT '最后登录IP',
  sup_explain VARCHAR(250) DEFAULT NULL COMMENT '说明',
  sup_web_site VARCHAR(250) DEFAULT NULL COMMENT '外接网址',
  sup_web_code VARCHAR(250) DEFAULT NULL COMMENT '连接外网标识码',
  sup_hot INT DEFAULT '0' COMMENT '经常使用，每点击一次加1'
)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

# /*6、创建供应商品牌表*/
# DROP TABLE IF EXISTS `tb_sup_brand`;
# CREATE TABLE `tb_sup_brand` (
# 	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
# 	brand_id INT(11) NOT NULL COMMENT '品牌编号',
# 	sup_id BIGINT(20) NOT NULL COMMENT '供应商编号'
# )ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*7、创建部门信息表*/
# DROP TABLE IF EXISTS `tb_department_info`;
# CREATE TABLE `tb_department_info` (
# 	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
# 	dep_name VARCHAR(50)  NOT NULL COMMENT '部门名称',
# 	dep_explain VARCHAR(250) DEFAULT NULL COMMENT '部门描述'
# 	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


/* 11、创建地区信息表*/
DROP TABLE IF EXISTS `tb_area_info`;
CREATE TABLE `tb_area_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	area_name VARCHAR(50) NOT NULL COMMENT '名称',
	parent_id BIGINT(20) DEFAULT 0 NOT NULL COMMENT '父级编号，默认顶层为0'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*12、创建客户等级信息表 */
DROP TABLE IF EXISTS `tb_cus_grade`;
CREATE TABLE `tb_cus_grade` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cugr_name VARCHAR(50) NOT NULL COMMENT '等级名称',
	cugr_dr INT(4) DEFAULT 100 COMMENT '折扣率，默认100为百分之百'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*13、创建付款方式表 */
DROP TABLE IF EXISTS `tb_payment_mode`;
CREATE TABLE `tb_payment_mode` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cugr_name VARCHAR(50) NOT NULL COMMENT '名称'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*14、创建供应商信息表*/
DROP TABLE IF EXISTS `tb_customer_info`;
CREATE TABLE `tb_customer_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cus_name VARCHAR(50) NOT NULL COMMENT '名称',
	cus_login_name VARCHAR(50) NOT NULL COMMENT '登录名',
  cus_avatar VARCHAR(150) NOT NULL COMMENT '顾客头像地址',
	cus_pwd VARCHAR(100) NOT NULL COMMENT '密码',
	cus_tel VARCHAR(50) DEFAULT NULL COMMENT '电话',
	cus_phone VARCHAR(50) DEFAULT NULL COMMENT '手机',
	cus_add VARCHAR(100) DEFAULT NULL COMMENT '地址',
	cus_qq VARCHAR(50) DEFAULT NULL COMMENT 'qq',
	cus_fax VARCHAR(50) DEFAULT NULL COMMENT '传真',
	cus_email VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
	cus_birth DATETIME  DEFAULT NULL COMMENT '出生日期',
	cus_identity VARCHAR(20) DEFAULT NULL COMMENT '身份证',
	cus_loc INT(11)  DEFAULT '0' COMMENT '登录次数',
	cus_status INT(4) DEFAULT '1' COMMENT '状态，1为可用，0不可用，2为删除, 默认为1',
	cus_hot INT(11)	 DEFAULT '0' COMMENT '经常使用，每点击一次加1',
	area_id BIGINT(20) DEFAULT NULL COMMENT '职务编号',
	cugr_id INT(11) DEFAULT NULL COMMENT '顾客等级编号',
	cus_created DATETIME  DEFAULT now() COMMENT '创建时间',
	cus_updated DATETIME  DEFAULT now() COMMENT '最后登录时间',
	cus_type INT(4) DEFAULT 1 COMMENT '取值范围 0为批发客户,1为零售客户 [默认为1]',
	cus_encrypt VARCHAR(50) DEFAULT NULL COMMENT '加密串',
	cus_last_ip VARCHAR(50) DEFAULT NULL COMMENT '最后登录IP',
	cus_explain VARCHAR(250) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/*15、创建欠款信息表*/
DROP TABLE IF EXISTS `tb_arrear_info`;
CREATE TABLE `tb_arrear_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	arr_money DECIMAL(10,2) DEFAULT NULL COMMENT '金额',
	arr_date DATETIME  DEFAULT now() COMMENT '欠款日期，默认当前日期',
	arr_repayment_money DECIMAL(10,2) DEFAULT NULL COMMENT '还款金额',
	arr_repayment_detail VARCHAR(500) DEFAULT NULL COMMENT '还款明细格式 如：日期_金额,...',
	arr_is_also INT(4) DEFAULT 0 COMMENT '是否还清，1为还清，0未还清，默认为0',
	sell_ser_number VARCHAR(50) DEFAULT NULL COMMENT '销售流水号',
	arr_loca INT(11) DEFAULT 0 COMMENT '欠款写在记帐本上的页数',
	arr_explain VARCHAR(250) DEFAULT NULL COMMENT '说明',
	pamo_id INT(11) DEFAULT NULL COMMENT '付款方式编号',
	emp_id BIGINT(20) NOT NULL COMMENT '员工编号',
	cus_id BIGINT(20) NOT NULL COMMENT '客户编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 16、创建颜色信息表*/
DROP TABLE IF EXISTS `tb_color_info`;
CREATE TABLE `tb_color_info` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	col_name VARCHAR(50) NOT NULL COMMENT '颜色名称',
	col_code VARCHAR(20) DEFAULT NULL COMMENT '颜色代码'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 17、创建产地信息表*/
DROP TABLE IF EXISTS `tb_origin_info`;
CREATE TABLE `tb_origin_info` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	ori_name VARCHAR(50) NOT NULL COMMENT '名称',
	ori_explain VARCHAR(250) DEFAULT NULL COMMENT '描述'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 18、创建商品分类表 */
DROP TABLE IF EXISTS `tb_commodity_sort`;
CREATE TABLE `tb_commodity_sort` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cos_name VARCHAR(50) NOT NULL COMMENT '名称',
	cos_explain	VARCHAR(250) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 19、创建商品分类表 */
DROP TABLE IF EXISTS `tb_commodity_category`;
CREATE TABLE `tb_commodity_category` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	parent_id BIGINT(20) DEFAULT 0 COMMENT '父编号',
	coca_name VARCHAR(50) NOT NULL COMMENT '名称',
  coca_level varchar(200) NOT NULL DEFAULT '' COMMENT '商品分类层级',
	coca_seq INT(4) DEFAULT 0 COMMENT '排序,按升序',
  coca_explain varchar(100) DEFAULT NULL COMMENT '说明',
	coca_created DATETIME  DEFAULT NULL COMMENT '创建时间',
	coca_updated DATETIME  DEFAULT NULL COMMENT '更新时间'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


/* 20、创建商品图片表*/
DROP TABLE IF EXISTS `tb_commodity_image`;
CREATE TABLE `tb_commodity_image` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	coim_name VARCHAR(150) DEFAULT NULL COMMENT '图片名称',
  coim_simple VARCHAR(100) DEFAULT NULL COMMENT '图片名称简写',
	coim_status INT(4) DEFAULT 1 COMMENT '是否可用，1为可用，0不可用，默认为1',
	coim_no INT(11) DEFAULT 0 COMMENT '序号,按升序排列'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


/* 21、创建关注度信息表*/
DROP TABLE IF EXISTS `tb_attention_info`;
CREATE TABLE `tb_attention_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号',
	att_status INT(4) DEFAULT 1 COMMENT '关注状态 1为关注,0不关注,默认1'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 22、创建收藏信息表*/
DROP TABLE IF EXISTS `tb_collect_info`;
CREATE TABLE `tb_collect_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号',
	coll_status INT(4) DEFAULT 1 COMMENT '收藏状态 1为收藏,0不收藏,默认1'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 23、创建商品信息表*/
DROP TABLE IF EXISTS `tb_commodity_info`;
CREATE TABLE `tb_commodity_info` (
	id VARCHAR(50) primary key COMMENT '编号',
	com_name VARCHAR(100) NOT NULL COMMENT '名称',
	com_model VARCHAR(100) NOT NULL COMMENT '型号',
  com_keyword VARCHAR(100) NOT NULL COMMENT '关键词',
	com_format VARCHAR(50) DEFAULT NULL COMMENT '规格',
	com_pack VARCHAR(50) DEFAULT NULL COMMENT '包装',
	com_unit VARCHAR(10) DEFAULT NULL COMMENT '单位',
	com_price DECIMAL(10,2) DEFAULT NULL COMMENT '成本价',
	com_retail DECIMAL(10,2) DEFAULT NULL COMMENT '零售价',
	com_wholesale DECIMAL(10,2) DEFAULT NULL COMMENT '批发价',
	com_main_img VARCHAR(150) DEFAULT NULL COMMENT '主图地址',
	com_images VARCHAR(500) DEFAULT NULL COMMENT '图片Id集合{uuid生成jpg名,+ 从0开始数值; uuid,0,1,2,..,[图片格式后缀.jpg]},多个图片名用","隔开',
	com_status INT(4) DEFAULT '1' COMMENT '是否显示，1为显示，0不显示，默认为1',
  com_comment INT(4) DEFAULT '1' COMMENT '是否可以评论，1可以评论,0不能评论',
	com_barCode VARCHAR(50) DEFAULT NULL COMMENT '条形码',
	com_hot INT(11) DEFAULT 0 COMMENT '商品热度点击1次加1',
	com_detail text DEFAULT NULL COMMENT '详细',
	com_created DATETIME  DEFAULT NULL COMMENT '创建时间',
	com_updated DATETIME  DEFAULT NULL COMMENT '更新时间',
	ori_id INT(11) DEFAULT NULL COMMENT '产地编号',
  coso_id VARCHAR(200) DEFAULT NULL COMMENT '商品分类编号的集合,[0,1,2...]',
	coca_id BIGINT(20) DEFAULT NULL COMMENT '商品类目编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 24、创建入库信息表 */
DROP TABLE IF EXISTS `tb_storage_info`;
CREATE TABLE `tb_storage_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',	/* 编号,主键，自动增长*/
	stor_created DATETIME  DEFAULT now() COMMENT '入库时间，默认当前时间',
	stor_updated DATETIME  DEFAULT now() COMMENT '更新时间',
	stor_style INT(4) DEFAULT 0 COMMENT '出入库[0 入库, 1 出库],默认 0',
	stor_status INT(4) DEFAULT 1 COMMENT '状态[0 废单,1 正常],默认 1',
	war_id INT(11) DEFAULT NULL COMMENT '仓库编号',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号',
	emp_id BIGINT(20)  DEFAULT NULL COMMENT '员工编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 25、创建入库明细表 */
DROP TABLE IF EXISTS `tb_storage_detail`;
CREATE TABLE `tb_storage_detail` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	stde_quantity INT(11)  DEFAULT 0 COMMENT '数量',
	stde_explain VARCHAR(250) DEFAULT NULL COMMENT '说明',
	stor_id INT(11) DEFAULT NULL COMMENT '入库编号',
	col_id INT(11) DEFAULT NULL COMMENT '颜色编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 26、创建 库存主表 */
DROP TABLE IF EXISTS `tb_inventory_info`;
CREATE TABLE `tb_inventory_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	inve_quantity INT(11) DEFAULT 0 COMMENT '数量',
	inve_created DATETIME  DEFAULT NULL COMMENT '创建时间',
	inve_tip INT(4) DEFAULT 0 COMMENT '库存提示，1为提示，0不提示，默认为0',
  inve_com_name VARCHAR(150) DEFAULT NULL COMMENT '商品名称,用来模糊查找',
	inve_total INT(11) DEFAULT 0 COMMENT '总数量',	/* */
	war_id INT(11) DEFAULT NULL COMMENT '仓库编号',	/* ——仓库表*/
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号',	/* ——商品表*/
	inve_explain VARCHAR(500) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 27、创建 库存明细表 */
# DROP TABLE IF EXISTS `tb_inventory_detail`;
# CREATE TABLE `tb_inventory_detail` (
# 	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
# 	inde_quantity INT(11)  DEFAULT 0 COMMENT '数量',
# 	inde_explain VARCHAR(250) DEFAULT NULL COMMENT '说明',
# 	inve_id INT(11) DEFAULT NULL COMMENT '主库存编号',
# 	col_id INT(11) DEFAULT NULL COMMENT '颜色编号'
# 	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 28、创建进货订单表 */
DROP TABLE IF EXISTS `tb_purchase_order`;
CREATE TABLE `tb_purchase_order` (
	ser_number VARCHAR(50) primary key COMMENT '订单流水号',
	puor_payment_status INT(4) DEFAULT 0 COMMENT '付款状态，1为付款，0未付款，默认为0',
	puor_quantity INT(11) DEFAULT 0 COMMENT '数量',
	puor_money DECIMAL(10,2) DEFAULT 0.0 COMMENT '金额',
	puor_created DATETIME  DEFAULT now() COMMENT '创建时间',
	puor_delivery DATETIME  DEFAULT NULL COMMENT '发货时间',
	puor_status INT(4) DEFAULT 0 COMMENT '状态0、订单->1已读->2发货->3到货->4完成',
	puor_is_complete INT(4) DEFAULT 0 COMMENT '是否完成，1为完成，0未完成，默认为0',
	puor_confirm INT(4) DEFAULT 0 COMMENT '确认进货订单与完成订单相一致时为0,有变更就为1',
	puor_type INT(4) DEFAULT 0 COMMENT '订单类型，区分发货，0表示厂商发货，1表示订货后厂商发货',
	puor_explain VARCHAR(500) DEFAULT NULL COMMENT '说明',
	pamo_id INT(11) DEFAULT NULL COMMENT '付款方式编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号',
	sup_id BIGINT(20) DEFAULT NULL COMMENT '供应商编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 29、创建进货订单明细表*/
DROP TABLE IF EXISTS `tb_pur_order_detail`;
CREATE TABLE `tb_pur_order_detail` (
	puor_ser_number VARCHAR(50) NOT NULL COMMENT '订单流水号',
	puod_quantity INT(11) DEFAULT 0 COMMENT '数量',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号',
	col_id INT(11)  DEFAULT NULL COMMENT '颜色编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 30、创建进货订单提示表*/
DROP TABLE IF EXISTS `tb_pur_order_tip`;
CREATE TABLE `tb_pur_order_tip` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	puor_ser_number VARCHAR(50) NOT NULL COMMENT '订单流水号',
	puot_sup_tip INT(4) DEFAULT 1 COMMENT '供应商提示，1为提示，0不提示，默认为1',
	puot_emp_tip INT(4) DEFAULT 0 COMMENT '员工提示，1为提示，0不提示，默认为0',
	puot_status INT(4) DEFAULT 0 COMMENT '订单状态写入流程',
	sup_id BIGINT(20) DEFAULT NULL COMMENT '供应商编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 31、创建旧进货订单表 */
DROP TABLE IF EXISTS `tb_old_purchase_order`;
CREATE TABLE `tb_old_purchase_order` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	puor_serNumber VARCHAR(50) NOT NULL COMMENT '订单流水号',
	opo_detail text DEFAULT NULL COMMENT '订单明细,每条详细明细用"_"分开,每条明细用","分开',
	opo_explain VARCHAR(500) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 32、创建客户订单信息表*/
DROP TABLE IF EXISTS `tb_customer_order`;
CREATE TABLE `tb_customer_order` (
	ser_number VARCHAR(50) primary key COMMENT '销售订单流水号',
	cuor_payment_status INT(4) DEFAULT 0 COMMENT '付款状态，1为付款，0未付款，默认为0',
	cuor_quantity INT(11) DEFAULT 0 COMMENT '数量',
	cuor_money DECIMAL(10,2) DEFAULT 0.0 COMMENT '金额',
	cuor_created DATETIME  DEFAULT now() COMMENT '创建时间',
	cuor_delivery DATETIME  DEFAULT NULL COMMENT '发货时间',
	cuor_status INT(4) DEFAULT 0 COMMENT '状态0、订单->1已读->2发货->3到货->4完成',
	cuor_is_complete INT(4) DEFAULT 0 COMMENT '是否完成，1为完成，0未完成，默认为0',
	cuor_colors VARCHAR(100) DEFAULT NULL COMMENT '颜色编号集合',
	cuor_confirm INT(4) DEFAULT 0 COMMENT '确认进货订单与完成订单相一致时为0,有变更就为1',
	cuor_type INT(4) DEFAULT 0 COMMENT '订单类型，区分发货，0表示自己发货，1表示顾客订货后发货',
	cuor_explain VARCHAR(500) DEFAULT NULL COMMENT '说明',
	pamo_id INT(11) DEFAULT NULL COMMENT '付款方式编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 33、创建客户订单明细表 */
DROP TABLE IF EXISTS `tb_cus_order_detail`;
CREATE TABLE `tb_cus_order_detail` (
	cuor_ser_number VARCHAR(50) NOT NULL COMMENT '流水号',
	cuod_quantity INT(11) DEFAULT NULL COMMENT '数量',
	com_id VARCHAR(50)  DEFAULT NULL COMMENT '商品编号——商品表',
	col_id INT(11) DEFAULT NULL COMMENT '颜色编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 34、创建客户订单提示表*/
DROP TABLE IF EXISTS `tb_cus_order_tip`;
CREATE TABLE `tb_cus_order_tip` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cuor_ser_number VARCHAR(50) NOT NULL COMMENT '订单流水号',
	cuot_cus_tip INT(4) DEFAULT 0 COMMENT '供应商提示，1为提示，0不提示，默认为0',
	cuot_emp_tip INT(4) DEFAULT 1 COMMENT '员工提示，1为提示，0不提示，默认为1',
	cuot_status INT(4) DEFAULT 0 COMMENT '订单状态写入流程',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 35、创建公告类型表*/
DROP TABLE IF EXISTS `tb_anno_type`;
CREATE TABLE `tb_anno_type` (
	id INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	anty_name VARCHAR(50) NOT NULL COMMENT '名称'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 36、创建公告信息表*/
DROP TABLE IF EXISTS `tb_announcement_info`;
CREATE TABLE `tb_announcement_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	ann_title VARCHAR(100) NOT NULL COMMENT '标题',
	ann_content text DEFAULT NULL COMMENT '内容',
	ann_created DATETIME  DEFAULT now() COMMENT '创建时间，默认当前时间',
	ann_start DATETIME  DEFAULT NULL COMMENT '开始时间',
	ann_end DATETIME  DEFAULT NULL COMMENT '结束时间',
	ann_is_display INT(4) DEFAULT 1 COMMENT '是否显示，1为显示，0不显示，默认为1',
	anty_id INT(11) DEFAULT NULL COMMENT '公告类型编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 37、创建消息信息表*/
DROP TABLE IF EXISTS `tb_message_info`;
CREATE TABLE `tb_message_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	from_id BIGINT(20) NOT NULL COMMENT '发送者编号',
	to_id BIGINT(20) NOT NULL COMMENT '接收者编号',
	mes_title VARCHAR(100)  NOT NULL COMMENT '标题',
	mes_content VARCHAR(1500)  NOT NULL COMMENT '内容',
	mes_created DATETIME  DEFAULT now() COMMENT '时间，默认当前时间',
	mes_explain VARCHAR(500)  DEFAULT NULL COMMENT '说明',
	from_type INT(4)  NOT NULL COMMENT '发送者类型为[1 员工, 2 供应商, 3 顾客]',
	to_type INT(4)  NOT NULL COMMENT '接收者类型为[1 员工, 2 供应商, 3 顾客]'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 38、创建消息提示表*/
DROP TABLE IF EXISTS `tb_message_tip`;
CREATE TABLE `tb_message_tip` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	meti_is_tip INT(4)  DEFAULT 1 COMMENT '提示，1为提示，0不提示，默认为1',
	mes_id BIGINT(20) NOT NULL COMMENT '消息编号',
	to_id BIGINT(20) NOT NULL COMMENT '接收者编号',
	to_type INT(4) NOT NULL COMMENT '接收者类型为[1 员工, 2 供应商, 3 顾客]'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 39、创建留言信息表*/
DROP TABLE IF EXISTS `tb_comm_message`;
CREATE TABLE `tb_comm_message` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	come_topic VARCHAR(100) NOT NULL COMMENT '主题',
	come_content VARCHAR(1500) NOT NULL COMMENT '内容',
	come_created DATETIME  DEFAULT now() COMMENT '创建时间，默认当前时间',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 40、创建回复信息表*/
DROP TABLE IF EXISTS `tb_comm_reply`;
CREATE TABLE `tb_comm_reply` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	core_content VARCHAR(1500) NOT NULL COMMENT '回复内容',
	core_created DATETIME  DEFAULT now() COMMENT '回复时间，默认当前时间',
	come_id BIGINT(20) DEFAULT NULL COMMENT '留言编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 41、创建销售信息表*/
DROP TABLE IF EXISTS `tb_sell_info`;
CREATE TABLE `tb_sell_info` (
	ser_number VARCHAR(50) primary key COMMENT '销售订单流水号',
	sell_quantity INT(11) DEFAULT 0 COMMENT '数量',
	sell_money DECIMAL(10,2) DEFAULT 0.0 COMMENT '金额',
	sell_pay_money DECIMAL(10,2) DEFAULT 0.0 COMMENT '付款金额',
	sell_status INT(4) DEFAULT 1 COMMENT '状态',
	sell_is_arrear INT(4) DEFAULT 1 COMMENT '是否欠款,1为付款,0为欠款*',
	sell_postage INT(11) DEFAULT 0 COMMENT '运费',
	pamo_id INT(11) DEFAULT NULL COMMENT '付款方式编号',
	emp_id BIGINT(20) DEFAULT NULL COMMENT '员工编号',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '客户编号',
	sell_ship_no VARCHAR(50) DEFAULT NULL COMMENT '运输单号',
	sell_pay_time DATETIME  DEFAULT NULL COMMENT '支付时间',
	sell_send_time DATETIME  DEFAULT NULL COMMENT '发货时间',
	sell_end_time DATETIME  DEFAULT NULL COMMENT '交易完成时间',
	sell_close_time DATETIME  DEFAULT NULL COMMENT '交易关闭时间',
	sell_created DATETIME  DEFAULT now() COMMENT '创建时间',
	sell_updated DATETIME  DEFAULT NULL COMMENT '更新时间',
	sell_refund_ser_number VARCHAR(50) DEFAULT NULL COMMENT '退货对应的 流水号',
	sell_explain VARCHAR(500) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 42、创建销售明细表*/
DROP TABLE IF EXISTS `tb_sell_detail`;
CREATE TABLE `tb_sell_detail` (
	sell_ser_number VARCHAR(50) NOT NULL COMMENT '销售流水号',
	sede_quantity INT(11) DEFAULT 0 COMMENT '数量',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '商品编号',
	col_id INT(11) DEFAULT NULL COMMENT '颜色编号',
	sede_explain VARCHAR(250) DEFAULT NULL COMMENT '说明'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 43、创建支付信息表*/
DROP TABLE IF EXISTS `tb_pay_info`;
CREATE TABLE `tb_pay_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号',
	sell_ser_number VARCHAR(50) NOT NULL COMMENT '销售流水号',
	pay_platform INT(4) DEFAULT 0 COMMENT '支付平台： 0 微信 1 支付宝',
	pay_platform_number VARCHAR(250) DEFAULT NULL COMMENT '支付流水号',
	pay_status VARCHAR(32) DEFAULT NULL COMMENT '支付状态',
	pay_created DATETIME  DEFAULT now() COMMENT '创建时间',
	pay_updated DATETIME  DEFAULT now() COMMENT '更新时间'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 44、创建购物车信息表*/
DROP TABLE IF EXISTS `tb_cat_info`;
CREATE TABLE `tb_cat_info` (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '编号',
	cus_id BIGINT(20) DEFAULT NULL COMMENT '顾客编号',
	com_id VARCHAR(50) DEFAULT NULL COMMENT '顾客编号',
	cat_quantity INT(11) DEFAULT 0 COMMENT '数量',
	checked INT(4) DEFAULT 0 COMMENT '是否选中: 0 未选中 1 选中',
	cat_explain VARCHAR(250) DEFAULT NULL COMMENT '说明',
	cat_created DATETIME  DEFAULT now() COMMENT '创建时间',
	cat_updated DATETIME  DEFAULT now() COMMENT '更新时间'
	)ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 45、创建登录日志表*/
DROP TABLE IF EXISTS `pub_login_log`;
CREATE TABLE `pub_login_log` (
  `id` BIGINT(20) NOT NULL auto_increment COMMENT '编号',
  `type` INT(4) DEFAULT NULL COMMENT '登录者的类型，1 员工 2 供应商 3 顾客',
  `operator` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `created` DATETIME  DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 46、创建员工日志表*/
DROP TABLE IF EXISTS `pub_emp_log`;
CREATE TABLE `pub_emp_log` (
  `id` BIGINT(20) NOT NULL auto_increment COMMENT '编号',
  `emp_id` BIGINT(20) NOT NULL COMMENT '员工编号',
  `old_value` text COMMENT '旧值',
  `new_value` text COMMENT '新值',
  `operate_ip` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `created` DATETIME  DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 47、创建顾客日志表*/
DROP TABLE IF EXISTS `pub_cus_log`;
CREATE TABLE `pub_cus_log` (
  `id` BIGINT(20) NOT NULL auto_increment COMMENT '编号',
  `cus_id` BIGINT(20) NOT NULL COMMENT '顾客编号',
  `old_value` text COMMENT '旧值',
  `new_value` text COMMENT '新值',
  `operate_ip` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `created` DATETIME  DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 48、创建供应商日志表*/
DROP TABLE IF EXISTS `pub_sup_log`;
CREATE TABLE `pub_sup_log` (
  `id` BIGINT(20) NOT NULL auto_increment COMMENT '编号',
  `sup_id` BIGINT(20) NOT NULL COMMENT '供应商编号',
  `old_value` text COMMENT '旧值',
  `new_value` text COMMENT '新值',
  `operate_ip` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `created` DATETIME  DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

/* 49、创建异常日志表*/
DROP TABLE IF EXISTS `pub_exception_log`;
CREATE TABLE `pub_exception_log` (
  `id` BIGINT(20) NOT NULL auto_increment COMMENT '编号',
  `message` text DEFAULT NULL COMMENT '异常信息',
  `type` VARCHAR(50) DEFAULT NULL COMMENT '异常的类型，1 员工 2 供应商 3 顾客 + 操作哪个表',
  `operator` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '操作者',
  `operate_ip` VARCHAR(20) NOT NULL DEFAULT '' COMMENT '最后一次更新者的ip地址',
  `created` DATETIME  DEFAULT now() COMMENT '创建时间',
  PRIMARY KEY (`id`)
  ) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


  