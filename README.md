# AndroidScreenAdaptation  
## 本库特点
    完全不用改变自己的布局编写习惯,你原先是怎么写布局,就怎么写布局.不用去继承适配类,不用在最外层包裹适配布局,不用新建茫茫多的分辨率适配文件夹,不要求强制使用px为单位,支持代码动态添加view适配,可以实时预览布局,满足旋转和分屏适配,全面屏或带虚拟按键手机适配也没问题.
## 效果展示
![](http://yatoooon.github.io/images/shipeixiaoguotu.png)
![](http://yatoooon.github.io/images/dpshipeixiaoguotu.png)
## 快速开始
1. **添加依赖**
 
    ``` implementation 'me.yatoooon:screenadaptation:1.1.1'```

2. **初始化工具类**

      (1.)创建自己的application继承Application
``` 
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
    }

//旋转适配,如果应用屏幕固定了某个方向不旋转的话(比如qq和微信),下面可不写.
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        ScreenAdapterTools.getInstance().reset(this);
    }
}
```
      (2.)在AndroidManifest.xml文件中声明使用你自己创建的application并且添加meta-data数据,例子上标明了这些数据的代表的意义
```
<application
        android:name=".App"
        .....
        <meta-data
            android:name="designwidth"
            android:value="1080" />  //设计图的宽,单位是像素,推荐用markman测量,量出来如果是750px那么请尽量去找ui设计师要一份android的设计图.
        <meta-data
            android:name="designdpi"
            android:value="480" />   //设计图对应的标准dpi,根据下面的那张图找到对应的dpi,比如1080就对应480dpi,如果拿到的是其他宽度的设计图,那么选择一个相近的dpi就好了
        <meta-data
            android:name="fontsize"
            android:value="1.0" />   //全局字体的大小倍数,有时候老板会觉得你的所有的字小了或者大了,你总不能一个一个去改吧
        <meta-data
            android:name="unit"
            android:value="px" />   //你的布局里面用的是px这就写px,你的布局里面用的是dp这就写dp,要统一,不要一会儿px一会儿dp,字体也用px或者dp,不要用sp,微信qq用的肯定不是sp.
</application>    
```
```
宽         	240 	320 	480 	720     1080 	1440  
DPI等级	        LDPI	MDPI	HDPI	XHDPI	XXHDPI	XXXHDPI
DPI数值	        120	160	240	320	480	640
```
3. **开始使用**
    
      (1.)在Activity中,找到setcontentview(R.layout.xxxxxx)
```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dp);
        //ScreenAdapterTools.getInstance().reset(this);//如果希望android7.0分屏也适配的话,加上这句
        //在setContentView();后面加上适配语句
        ScreenAdapterTools.getInstance().loadView(getWindow().getDecorView());

    }
}
```
      (2.)在Fragment或recyclerview,listview或gridview,viewpager,自定义view等等等,只要能找到布局填充器(自定义view完全是代码绘制的没有用布局填充器怎么办?往下看)
    
```
public class TestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_px, container, false);
        //拿到布局填充器返回的view后
        ScreenAdapterTools.getInstance().loadView(view);
        return view;
    }
}  
注: 1.自定义view的话,在  ScreenAdapterTools.getInstance().loadView(view);   外面包裹一层判断如下,不然在使用自定义view编写布局文件时预览xml会有问题!但不影响真机运行效果.
        if (!isInEditMode()) {
            ScreenAdapterTools.getInstance().loadView(view);
        }    
    2.完全代码绘制的自定义view怎么办?   比如说我绘制了个半径为100dp的圆,在代码里找到获取半径属性值circleRadius的地方  
       circleRadius = ScreenAdapterTools.getInstance().loadCustomAttrValue(circleRadius);
```
      (3.)现在打开你的布局文件,并且打开预览,点击预览上部的小手机图标选择和你设计图匹配的模拟器,然后就可以按照设计图测量并编写布局文件,测量和编写的单位用px还是dp取决于你清单文件中的meta_data中unit填写的值,暂时只支持宽 高 padding layout_margin 字体大小 这几个属性(如果有minmaxWidthHeight这种属性值,适配时...loadView(...view,new CustomConversion()),如果有其他需要的属性值,请自行继承IConversion和AbsLoadViewHelper编写),布局文件完成后,你看到的预览是什么样,各种真机运行出来就是什么样.
## 原理
```
  那些长篇大论的文章我也不想提,想必读者已经在别处看疯了,知道几个最简单的概念用起来就可以了  
     1. px是分辨率的单位 比如现在主流手机分辨率1080*1920.  
     2. dp是安卓开发专有的单位 在 不同的手机下 1dp = 不同的 px.  
     3. sp是字体大小(前面清单文件中要求字体也用dp或者px),sp随系统字体大小变化而变化,但据我观察,像微信qq这些app的字体是不随系统显示字体大小变化的.
     ### 本库是按照设计图的宽度的值(单位px)和对应标准dpi来适配的(手机实际宽度相对于设计图增加或减少,高度同比例(这的比例是宽度增加或减少的比例)增加或减少),所有的布局控件都按这个比例(手机实际宽度/设计图宽度)来适配,在不同的分辨率,不同ppi(手机屏幕密度,又称为dpi),不同最小宽度(有的人喜欢去调开发者选项下面的最小宽度,主流手机默认为360dp)的手机下都做到了适配.
```
## 联系我
* **最好直接提issue**: qq和email有时候收不到 
* **Email**: <qazasdeszplm@126.com> 
* **qq**:    3529161483  
## 注
    6月6日看到了头条技术团队的适配方案,他们是真的机智,虽然文章中有一些表述不太正确,链接:https://mp.weixin.qq.com/s/d9QCoBP6kV9VSWvVldVVwA ,原理差不多,只不过头条在源头修改了强制修改了density进行适配,这种写法是真他娘的省事,我当时怎么就没有想到呢???  不过如果你有直接写px的习惯(UI大妹子就只给标注px!),那就用我的框架吧.  
    6月25日有人和我说头条这个方案在8.0以上机型无效,我也没有测,大家自己斟酌.  
    6月28日有人和我说8.0也是可行的，修改activity的density而不是application的density就可以。
    9月05日推荐使用jessyan的androidautosize,并且推荐开发框架也用他的.
## 版权
 ``` 
   Copyright 2018 yatoooon

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 ``` 
