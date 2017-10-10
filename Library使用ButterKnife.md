# Library（Module）中添加（使用）ButterKnife黄油刀 #
#### 生活是自己的，奋斗也不是为了别人，拼搏是每天必做的事情，只有每天进步才是最稳定的生活。——《你所谓的稳定,不过是在浪费生命》 ####

查看了几篇大神们的博客，以及自己亲测了，是没有问题的!
——**然后自己删除一下“语句”，调整出了更简单的配置，得出“apt是不需要的”！！**

## 首先说一下配置： ##

### 第一步： ###
当然是建立Module啦，我建立了一个名为：base的Module

![](https://i.imgur.com/Q2MaSYu.png)

### 第二步：配置Module的Gradle ###
#### 第一部分： ####
    buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath 'com.jakewharton:butterknife-gradle-plugin:8.8.1'
    }
	}

在上面的代码配置在Module的Gradle中（我放置的位置在最顶部）

![](https://i.imgur.com/WLjNFmp.png)

#### 第二部分： ####

library的module中有这样一句话：`apply plugin: 'com.android.library'`
在这句话下面添加：`apply plugin: 'com.jakewharton.butterknife'`

![](https://i.imgur.com/gMnsM7T.png)

#### 第三部分 ####

在Gradle中的***dependencies***里面添加“黄油刀”ButterKnife

    compile 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

![](https://i.imgur.com/NNefKMY.png)

### 第三步：配置App的Gradle ###

#### 第一部分：将“base”Module关联App（知道如何关联的跳过此部分） ####

![](https://i.imgur.com/ke4692U.png)
![](https://i.imgur.com/fL0XX4U.png)
后选择base（或者其他自己创建的Module）

#### 第二部分：添加黄油刀butterknife ####

同样，在App的Gradle中的***dependencies***添加：

    compile 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'

![](https://i.imgur.com/QKrgZTc.png)

**注意：**记得配置完要 ***Sync Now***![](https://i.imgur.com/EV13nIZ.png)

### 最后：看看官方GitHub写的—— ###

![](https://i.imgur.com/oVzi3Rq.png)

#### 总结一句：以下代码在App和Library（Module）的Gradle都需要配置,其他配置按官方的说法即可  ####
    compile 'com.jakewharton:butterknife:8.8.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1' 


**感谢大神的文章：**
这是我看的步骤仔细的文章：
[http://www.cnblogs.com/pili/p/7237318.html](http://www.cnblogs.com/pili/p/7237318.html)

以下是我写的小项目地址（文章不清楚可以直接看代码）：
[https://github.com/Jys05/ButterKnife_Test](https://github.com/Jys05/ButterKnife_Test)

### 接受我大概讲一下我在Module使用ButterKnife的代码为了方便App的编写（没必要可以不看）： ###

1、在Module中建立了BaseActivity，并且配置了ButterKnife黄油刀，
2、接着加了一层MyActivity继承BaseActivity
3、最后ManiActivity继承MyActivity（为了避免如果App中的Activiy，如果ManiActivity继承BaseActivity的话使得代码过长。这样继承MyActivity的话，需要使用*initComponent*方法才写进Activity中）

———这样就可以方便不用，每个Activity都要写	`ButterKnife.bind(this);`的语句

![](https://i.imgur.com/aXVGG8b.png)

