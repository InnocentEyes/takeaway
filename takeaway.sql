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

/**
  增加shipaddress的外键参照shiparea的主键id
 */
alter table shipaddress add foreign key(areaid) references shiparea(id);

/*根据文档添加区域 分为本地和外地*/
insert into shiparea(area,cost) values('本地',5),('外地',100);

/*补充数据库缺少的东西*/
alter table goods add foreign key goods(`typeno`) references goodstype(`no`);
alter table goodstype add unique key goodstype(`no`);

/**
  会员的等级 因此不用写MemberLayerService类来添加或修改 这是固定的
 */
insert into memberlayer(layer,mincredit,creditscale) values('普通会员',0,1.0),('白银会员',3000,1.2),('黄金会员',8000,1.3),('白金会员',15000,1.4);

/*插入数据*/
insert into goodstype(`no`,`name`,`parenttype`,`desc`) values('0101','回合制策略游戏','0100','是策略游戏的一种子类型，所有的玩家轮流自己的回合，只有自己的回合，才能够进行操纵。'),
                                                             ('0102','即时战略游戏','0100','游戏的过程是即时进行而不是采用回合制。通常，标准的即时战略游戏会有资源采集、基地建造、科技发展等元素。在玩家指挥方面，即时战略游戏通常可以独立控制各个单位，而不限于群组式的控制。'),
                                                             ('0103','在线即时战略游戏','0100','游戏的过程是即时进行而不是采用回合制。通常，标准的即时战略游戏会有资源采集、基地建造、科技发展等元素。在玩家指挥方面，即时战略游戏通常可以独立控制各个单位，而不限于群组式的控制。'),
                                                             ('0201','动作角色扮演游戏','0200','具体上来说，基本型是具备使角色成长继续冒险的RPG要素、对于战斗场景的动作性处理（非选项式战术，考虑到操作时差等的处理）、解决隐藏谜题或机关的冒险游戏要素等。尤其是多半会称能够平顺地连接这些场景的游戏为“动作角色扮演游戏”。'),
                                                             ('0202','战略／模拟角色扮演游戏','0200','简称SRPG或RSLG，最大特性在于战斗系统中拥有类似战略游戏的游戏方式，以及具有类似角色扮演游戏的剧情推演及人物成长。'),
                                                             ('0203','互联网角色扮演游戏','0200','是一个以网络作为平台，而利用文字作为沟通介质所进行的角色扮演游戏。游戏的主要内容是，玩家以文字扮演某一个角色，在特定的游戏背景下进行不同的活动，例如冒险、寻宝、解谜等。'),
                                                             ('0301','飞机射击游戏','0300','射击游戏，用飞机的。'),
                                                             ('0302','光线枪游戏','0300','是一种射击游戏，主要设计元素是使用枪形控制器瞄准并射击。光枪射击游戏以主人公为中心，射击敌人或无生命对象等目标。'),
                                                             ('0303','第一人称射击游戏','0300','是以玩家的第一人称视角为主视角进行的射击类电子游戏的总称，通常需要使用枪械或其他武器进行战斗。玩家会直接从游戏的主人公的眼中观察周围环境，并进行射击、运动、对话等等活动。大部分第一人称射击游戏会采用三维或伪三维技术来使玩家获得身临其境的体验，并达成多人游戏的需求。');

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values ('02010001','巫师三','0201','/myWeb/static/css/img/game_img/02010001.png',127.0,100,0.8),
       ('02010002','刺客信条奥德赛','0201','/myWeb/static/css/img/game_img/02010002.png',298.0,100,0.8),
       ('02010003','赛博朋克2077','0201','/myWeb/static/css/img/game_img/02010003.png',298.0,100,0.8),
       ('02010004','古墓丽影','0201','/myWeb/static/css/img/game_img/02010004.png',242.0,100,0.8),
       ('02010005','刺客信条-英灵殿','0201','/myWeb/static/css/img/game_img/02010005.png',198.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('02020001','大秦帝国','0202','/myWeb/static/css/img/game_img/02020001.png',99.0,100,0.8),
      ('02020002','战略思维-太平洋','0202','/myWeb/static/css/img/game_img/02020002.png',90.0,100,0.8),
      ('02020003','战略思维-闪电战','0202','/myWeb/static/css/img/game_img/02020003.png',109.0,100,0.8),
      ('02020004','鬼谷八荒','0202','/myWeb/static/css/img/game_img/02020004.png',68.0,100,0.8),
      ('02020005','三国群英传7','0202','/myWeb/static/css/img/game_img/02020005.png',57.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('02030001','Big fram story','0203','/myWeb/static/css/img/game_img/02030001.png',121.0,100,0.8),
      ('02030002','猎人竞技场-传奇','0203','/myWeb/static/css/img/game_img/02030002.png',98.0,100,0.8),
      ('02030003','饥荒联机版','0203','/myWeb/static/css/img/game_img/02030003.png',24.0,100,0.8),
      ('02030004','永劫无双','0203','/myWeb/static/css/img/game_img/02030004.png',98.0,100,0.8),
      ('02030005','人间地狱','0203','/myWeb/static/css/img/game_img/02030005.png',149.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('01010001','人类','0101','/myWeb/static/css/img/game_img/01010001.png',225.0,100,0.8),
      ('01010002','三国志14','0101','/myWeb/static/css/img/game_img/01010002.png',349.0,100,0.8),
      ('01010003','炉石传说','0101','/myWeb/static/css/img/game_img/01010003.png',98.0,100,0.8),
      ('01010004','幻想乡自走棋','0101','/myWeb/static/css/img/game_img/01010004.png',54.0,100,0.8),
      ('01010005','最后的诅咒','0101','/myWeb/static/css/img/game_img/01010005.png',65.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('01020001','Dota2','0102','/myWeb/static/css/img/game_img/01020001.png',2.0,100,0.8),
      ('01020002','战意','0102','/myWeb/static/css/img/game_img/01020002.png',10.0,100,0.8),
      ('01020003','Total war：WARHAMMKER2','0102','/myWeb/static/css/img/game_img/01020003.png',268.0,100,0.8),
      ('01020004','Total war：THREE KINGDOMS','0102','/myWeb/static/css/img/game_img/01020004.png',99.0,100,0.8),
      ('01020005','Age of emplirses 2：definitive edition','0102','/myWeb/static/css/img/game_img/01020005.png',99.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('01030001','云顶之弈','0103','/myWeb/static/css/img/game_img/01030001.png',1.0,100,0.8),
      ('01030002','双人成行','0103','/myWeb/static/css/img/game_img/01030002.png',198.0,100,0.8),
      ('01030003','Ai War','0103','/myWeb/static/css/img/game_img/01030003.png',70.0,100,0.8),
      ('01030004','红色警戒2共和国之辉','0103','/myWeb/static/css/img/game_img/01030004.png',20.0,100,0.8),
      ('01030005','星际争霸２','0103','/myWeb/static/css/img/game_img/01030005.png',88.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('03010001','War thunder','0301','/myWeb/static/css/img/game_img/03010001.png',49.0,100,0.8),
      ('03010002','Comanche','0301','/myWeb/static/css/img/game_img/03010002.png',110.0,100,0.8),
      ('03010003','Raiden 4','0301','/myWeb/static/css/img/game_img/03010003.png',48.0,100,0.8),
      ('03010004','末日远征','0301','/myWeb/static/css/img/game_img/03010004.png',199.0,100,0.8),
      ('03010005','星战前夜','0301','/myWeb/static/css/img/game_img/03010005.png',299.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('03020001','Rambo兰博','0302','/myWeb/static/css/img/game_img/03020001.png',26.0,100,0.8),
      ('03020002','OPEARTION G.H.O.S.T. 幽灵行动','0302','/myWeb/static/css/img/game_img/03020002.png',148.0,100,0.8),
      ('03020003','死亡之屋4','0302','/myWeb/static/css/img/game_img/03020003.png',299.0,100,0.8),
      ('03020004','CFHD','0302','/myWeb/static/css/img/game_img/03020004.png',0.10,100,0.8),
      ('03020005','守望先锋','0302','/myWeb/static/css/img/game_img/03020005.png',98.0,100,0.8);

insert into goods(`no`,`name`,`typeno`,`img`,`price`,`qty`,`discount`)
values('03030001','战地风云2042','0303','/myWeb/static/css/img/game_img/03030001.png',248.0,100,0.8),
      ('03030002','逃生之路','0303','/myWeb/static/css/img/game_img/03030002.png',37.0,100,0.8),
      ('03030003','无主之地２','0303','/myWeb/static/css/img/game_img/03030003.png',188.0,100,0.8),
      ('03030004','战地风云5','0303','/myWeb/static/css/img/game_img/03030004.png',228.0,100,0.8),
      ('03030005','绝地求生','0303','/myWeb/static/css/img/game_img/03030005.png',99.0,100,0.8);











