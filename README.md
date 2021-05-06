# mall

#### 介绍
An available, simple, secure and efficient E-commerce system

#### 软件架构
传统的基于Cookie鉴权的web项目。

#### 版本迭代

当前版本 v0.1.1

#### 使用说明

1.  taobao为主项目文件夹，后端小组的同学先拉取仓库中的项目主文件，将自己开发的部分添加修改进去，然后再与仓库进行合并上传。
2.  database有数据库相关的资料和信息，账号密码私聊。
3.  针对前端：你们所开发的模板网页放在taobao/src/main/resources/templates文件夹下。
4.  针对前端：将你们的模板文件说明放入“template introduction”文件夹下，按照：网页所属的功能模块+网页的功能描述+网页名+所涉及的对象引用名（如有不足可适当增加详细说明）的格式进行说明。

# 第一阶段总结

### 前后端交互中的一些问题

1. 前端在进行网页跳转时，如果跳往的是**根地址**下的某个请求，比如现在要从/user/home 跳往 /shop, 那么跳转的url应该是/shop而不应该直接是shop。
2. 前端需求文档明确，可以接着这种方式写。因为我在仓库根目录下以及建立了一个template_introduction文件夹了，所以最好把文档都放那里面，便于获取。
3. 前端页面(包括seller以及index)，建议商品（或商店）条目由**前端**页面的**动态请求**控制生成。*补充技术细节：后端并没有将所有的商品全部拉取，而是做了分页查询，一次拉取最多30个商品（或商店），这是为了防止数据传输量过大。*因此，我建议前端可以改进页面，<u>通过ajax与后端进行json交互，用户每往下刷新，就会发出新的**拉取请求**以获得包含至多30个商品信息(但是这里**最合理**的应当是商店而非商品，即按**商店数目**进行定量拉取)的json数据，然后根据json内容**生成**新的商品。</u>
4. 建议前端页面改进为**可展开，可收回**的形式。展开，即是对特定条目的展开，比如对特定类别，特定商店下的商品进行展开。
5. 前端对网页的显示和布局存在一定的问题，需要及时修改。
6. 不用的代码和注释都删除了吧。
7. 后端需要对商品的拉取逻辑进行优化。

### 后端下一阶段分工

具体情况根据**前端实现**和**需求占比**来确定，越重要的功能应该越先实现。

俞少超 		负责卖家模块，实现商品**上架**，**下架**，**库存管理**，**信息管理**等等的功能（上述功能仅为举例，具体由需求而定）。

潘宣霖		负责买家模块，包括**添加购物车**（暂时考虑用mysql实现），**下单**，**关注店铺**等等（上述功能仅为举例，具体由需求而定）

刘金麟、陈玮健	继续进行**管理员模块**的开发，**项目优化**和**问题发现**，在**语言**和**项目结构**等方面及时提出改进性意见和建议。

牛浩			学习调研一下redis相关的内容，主要是关于如何**部署和运用**，**怎样存值**，**存哪些值**，**存多久**，产出**报告文档**。

钟文夫		学习调研Elasticsearch，产出**文档**。优化项目部署，尝试用docker进行**容器化**快速部署。

戴子佳		数据库**扩展**和**管理**，**存储值**的优化，**一致性**的筛查，研究数据库docker部署。

————————————2021.4.30 22:10

**陈凌灏、台海春：上传对应的报告（DDL：May 7th）**