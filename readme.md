# 后端服务

 - [微服务端口列表](#端口列表)
 - [功能模块错误码定义](#错误码定义)
 - [分支开发任务步骤](#开发新任务步骤)
 - [功能开发基本流程](#功能开发基本流程)
 
## 端口列表
- web: 6100X
- service: 6200X
- dubbo: 6300X

## 错误码定义
- 某模块 F0001,S0001

## 开发新任务步骤
1. 从git上checkout新的需求分支到本地
2. 在本地完成研发及自测，在test-script对应版本目录下 __【上传postman脚本]__。
3. __【在z-ddl对应版本目录下上传当次需求相关的数据库变更脚本】__
4. 测试反馈的问题在需求分支上修改等待下次回归。
5. 完成测试和上线后，删除本地分支。Re
6. 每日下班前提交当日代码，代码中有错误或未实现部分，预留//TODO并用伪代码去除错误提示

## 功能开发基本流程
 1. 在门面层新建入口Controller
    - controller包下，根据访问权限放入相应的包下
    - 根据功能确定是否新建新包，分门别类
    - 所有的Controller路径需要和包的分级目录保持一致
        - /security/admin/cache，在security包下admin包下CacheAdminController
 2. 定义swagger
    - 这一项特别重要
 3. 所有Controller参数封装成Form
    - 继承ValidationForm
    - 定义数据校验
    - Form对象将贯穿整个流程
 3. 定义Remote
    - remote是门面层中服务于Controller的中间层，主要用于请求访问控制
    - 定义histrix，以及引用其他微服务的feign
    - 数据更新相关的不需要定义配套Down方法，查询相关的需要定义Down，提升体验。
 4. 定义Feign接口
    - 在remote层中引入的feign接口
    - feign定义在微服务的apilist中
    - __自测阶段需修改微服务名，避免与测试环境冲突__
        - FeignConstant
        - bootstrap.yml
 5. 定义微服务api接口
    - 微服务是业务的具体实现构件
    - 微服务的所有接口都是Post请求，接受Form
    - 业务方法名最好上下贯穿定义一致，这样方便查找代码
 6. 定义微服务Service接口
    - Service是微服务实现的具体逻辑块所在
 7. 定义微服务Dao接口
    - Dao接口是持久化映射层
    - 仅需定义接口，放到指定目录下，AutoMapper组件会自动寻找
 8. sql实现Mybatis之XML
    - mapper定义与Dao所在关联
 9. Postman完成自测
 
 Spring Cloud Gateway整合Swagger聚合微服务系统API文档(非Zuul)
 https://blog.csdn.net/ttzommed/article/details/81103609
 https://www.zhihu.com/question/58954233
 https://www.liangzl.com/get-article-detail-125580.html
 
 https://segmentfault.com/a/1190000010911014
 https://segmentfault.com/a/1190000013026909
 https://github.com/Swagger2Markup/swagger2markup
 https://www.jianshu.com/p/adc1e9fc6be2?utm_campaign=maleskine&utm_content=note&utm_medium=seo_notes&utm_source=recommendation