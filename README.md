# seajackwang
目录划分
ODS存放业务同步的原始数据
DWD存放基础明细表
DWS存放细粒度的统计明细表
ADS存放结果数据表
DIM 存放维表和码值数据
tmp 存放临时逻辑
init 存放用于跑历史数据的代码，一次性的
util 存放本项目的公共方法，通用的方法统一维护在mh_common中
history 历史代码

项目打包：
1代码完整无报错
2环境：java scala的jdk
maven中的setting和仓库设置：在设置中搜索maven,配置路径里找到配置正确
3 view->tool->maven->生命周期->package->打包成功->target目录下面会有jar包
注：修改重新打包，package前先clean之前的旧的包


