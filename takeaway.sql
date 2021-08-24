/**
 *@author Orange橙橙
 *@createtime 20201年8月11日22点06分
 **/


create database takeaway;
use takeaway;

/**
 *会员信息
 **/
create table if not exists `member`(
	`id` int auto_increment,
    `email` varchar(20) comment 'E_mail地址',
    `nick` varchar(20) comment '昵称',
    `password` varchar(20) comment '密码',
	`credit` int default 0 comment '积分',
    `layerid` int comment '级别',
    `rDatetime` datetime default current_timestamp comment '注册时间，不可更改',
    check(length(`password`) >= 6 and length(`credit`) >= 0),
    primary key (`id`),
    foreign key (`layerid`) references memberlayer(`id`)
)engine=InnoDB charset=utf8;

/**
 *地址
 **/
create table if not exists `shipaddress`(
	`id` int auto_increment,
	`memberid` int comment '会员id',
    `name` varchar(20) comment '姓名',
    `areaid` int comment '送货区域',
    `adress` varchar(100) comment '送货地址',
    `zipcode` varchar(20) comment '邮政编码',
    `telno` varchar(11) comment '联系人电话',
    `isDefault` int comment '默认地址',
    primary key(`id`),
    foreign key(`memberid`) references `member`(`id`)
)engine=InnoDB charset=utf8;

/**
 *送货地区
 **/
create table if not exists `shiparea`(
	`id` int auto_increment,
	`area` varchar(100) comment '区域',
    `cost` float comment '运费',
    primary key(`id`)
)engine=InnoDB charset=utf8;


/**
 *会员等级
 **/
create table if not exists `memberlayer`(
	`id` int auto_increment,
	`layer` varchar(100) comment '级别名称',
    `mincredit` int comment '积分',
    `creditscale` float comment '积分比例',
    primary key(`id`)
)engine=InnoDB charset=utf8;

/**
 *商品类别
 **/
create table if not exists `goodstype`(
	`id` int auto_increment,
	`no` varchar(80) comment '类别编号',
    `name` varchar(80) comment '类别名',
    `parenttype` varchar(80) comment '父类别',
    `desc` varchar(100) comment '描述',
    `img` varchar(150) comment '类别图片',
    primary key(`id`)
)engine=InnoDB charset=utf8;


/**
 *商品
 **/
create table if not exists `goods`(
	`id` int auto_increment,
	`no` varchar(80) not null comment '商品代码',
    `name` varchar(80) comment '商品名称',
    `typeno` varchar(80) comment '商品类别',
    `desc` varchar(100) comment '商品描述',
    `img` varchar(150) comment '商品图片',
    `price` float comment '市场价',
    `qty` int comment '库存量',
    `discount` float comment '折扣',
    unique(`no`),
    primary key(`id`)
)engine=InnoDB charset=utf8;

/**
 *商品评论
 **/
create table if not exists `goodscomment`(
	`id` int auto_increment,
	`memberid` int comment '会员id',
    `goodsid` varchar(80) comment '商品代码',
    `pubtime` datetime default current_timestamp comment '发表时间',
    `score` int comment '分数',
    `desc` varchar(100) comment '评论',
    primary key(`id`),
    foreign key(`memberid`) references `member`(`id`),
    foreign key(`goodsid`) references `goods`(`no`)
)engine=InnoDB charset=utf8; 

/**
 *收藏夹
 **/
create table if not exists `collect`(
	`id` int auto_increment,
	`memberid` int comment '会员id',
    `goodsid` varchar(80) comment '商品代码',
    `coltime` datetime default current_timestamp comment '收藏时间',
    primary key(`id`),
    foreign key(`memberid`) references `member`(`id`),
    foreign key(`goodsid`) references `goods`(`no`)
)engine=InnoDB charset=utf8; 


/**
 *订单
 **/
create table if not exists `orders`(
	`id` int auto_increment,
	`orderno` varchar(100) comment '订单编号',
    `memberid` int comment '会员id',
    `credit` int comment '本单所产生的积分',
    `shipaddressid` int comment '送货地址id',
    `shiptype` varchar(80) comment '配送方式编码',
    `paytype` varchar(80) comment '支付方式',
	`ordertime` datetime default current_timestamp comment '下单时间',
    `amount` float comment '订单金额',
    `creditused` int comment '使用积分',
    `status` int comment '订单状态',
    `handle` int comment '处理状态',
    check(`status` = 1 or `status` = 0),
    check(`handle` = 1 or `handle` = 0),
    unique(`orderno`),
    primary key(`id`),
    foreign key(`memberid`) references `member`(`id`),
    foreign key(`shipaddressId`) references `shipaddress`(`id`)
)engine=InnoDB charset=utf8; 


/**
 *商品清单
 **/
create table if not exists `orderdetail`(
	`id` int auto_increment,
	`goodno` varchar(100) comment '商品编号',
	`goodsname` varchar(80) comment '商品名称',
	`orderno` varchar(100) comment '订单编号',
    `price` float comment '市场价',
    `discount` float comment '折扣',
    `memberprice` float comment '会员价',
    `qty` int comment '数量',
    `allprice` float comment '总价',
    primary key(`id`),
    foreign key(`goodno`) references `goods`(`no`),
    foreign key(`orderno`) references `orders`(`orderno`)
)engine=InnoDB charset=utf8; 


/**
 *数据字典
 **/
create table if not exists `dict`(
	`id` int,
    `no` varchar(80) comment '编号',
    `name` varchar(80) comment '名字',
    `type` int  comment '类型'
)engine=InnoDB charset=utf8; 













