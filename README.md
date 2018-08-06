# 演示
	本demo用《下厨房》app做为原型；
	以主页作为app壳，主页5个fragment作为模块进行组件化架构。
	工程不复杂，适合正在学习组件化的童鞋。

	
![table](https://github.com/fanjianli/AssemblyProject/blob/master/notice/table.png)![主页](https://github.com/fanjianli/AssemblyProject/blob/master/notice/app.png)![app](https://github.com/fanjianli/AssemblyProject/blob/master/notice/app1.png)![fav](https://github.com/fanjianli/AssemblyProject/blob/master/notice/fav.png)![market](https://github.com/fanjianli/AssemblyProject/blob/master/notice/market.png)

##What 组件化
* 组件化是将一个app分成多个模块，可以对每个模块进行独立调试，每个模块可以独立运行，打包时最终发布将所有的组件统一合并成一个apk，也可以将某些组件合并成一个apk，主app就相当于一个apk的壳。

## 组件化的好处
* 架构清晰业务组件间完成解耦合。
* 每个业务组件都可以根据BU需求完成独立app发布。
* 开发中使开发者更加轻松，开发中加快功能开发调试的速度。
* 业务组件整体删除添加替换变得非常轻松，减少工程中的代码资源等冗余文件。
* 业务降级，业务组件在促销高峰期间可以业务为单元关闭，保证核心业务组件的顺利执行。

## 方案

![方案](https://github.com/fanjianli/AssemblyProject/blob/master/notice/fangan.png)

从图片可以看出，主要有三个角色：

* 1.主工程（壳工程module）：主要负责事情不塞入任何具体业务逻辑，主要用于使用组合业务组件，初始化配置和发布应用配置等操作。
* 2.组件（module/library）：主要实现具体业务逻辑，尽可能保证业务独立性，例如现在手淘这样一个大型的app几乎每个bu功能块都能拿出来作为一个独立业务app。但是没有大型也可以按照小一些的业务逻辑来区分组件，例如：购物车组件，收银台组件，用户中心组件等，具体根据自己的项目需要来划分。
* 3.公共库（library）：公共使用的工具类，sdk等库，例如eventbus，xutils，rxandroid，自定义工具类等等，这些库可以做成一个公共common sdk，也可以实现抽离很细按照需求依赖使用。

## 实现
		通过使用阿里路由框架和gradle插件完成组件化的架构。
	阿里路由：[ARouter](https://github.com/alibaba/ARouter)
	gradle插件：[build-gradle](https://dl.bintray.com/fjl/maven/com/fjl/assembly/build-gradle/1.0.1)

    阿里路由很方便的帮我们完成了页面之间的路由。
		
    关于阿里路由，阿里文档有详细介绍，请移驾。
	
gradle插件方便的让我们可以让每个模块独立调试和运行。在工程的build.gradle中加入插件：
		
	buildscript {
    	ext.kotlin_version = '1.2.30'
    	repositories {
        	google()
        	jcenter()
        	//手动添加maven库
        	maven {url "https://dl.bintray.com/fjl/maven"}
    	}
    	dependencies {
    	//gradle插件 内含gradle3.1.2
        classpath 'com.fjl.assembly:build-gradle:1.0.1'
    	}
	}
使用该插件时除公公模块其他组件和app不用在apply plugin: 'com.android.application'或者apply plugin: 'com.android.library',

	请使用
		apply plugin: 'com.fjl.comgradle'

在每个组件模块中加入gradle.properties文件并指定	
	
	isRunAlone=true（指模块是否可以独立运行）
	debugComponent=marketmodel（指debug时依赖）
	compileComponent=    （compile时依赖）
	
通过上面3个配置完成模块直接的引用关系，可将模块打入壳内。

需要在模块和app的build.gradle文件中添加
	
	combuild {
		//必须指定
    	applicationName =
		'com.fjl.community.runalone.MyApplication'
    	isRegisterCompoAuto = true
	}
详情请见代码。


## 模块的独立运行
* 前提：配合github代码完成上述配置。（isRunAlone=true）
* 在模块工程下main下建立runalone文件夹将runalone文件夹作为工程文件夹即可。（详情见代码）
* 如遇到AndroidManifest文件合并错误等异常，请仔细查看demo代码。

## DEMO
	(此处缺少图片)
* basiclib：公共模块，抽取base和一些框架的依赖。
* app：壳工程，此demo中将app作为一个主页的容器使用。
* communitymodel:信箱模块，可独立运行。
* favmodel:收藏模块。
* selfmodel:我模块。
* xiachufangmodel:下厨房模块。

		demo只提供思想和抽取的粗糙方案，细化和应用请各位自行发挥。
		
		
##联系作者
![联系方法](https://github.com/fanjianli/AssemblyProject/blob/master/notice/lianxi.png)
