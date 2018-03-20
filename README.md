# AndroidScreenAdaptation
## 效果展示
![](http://www.yatoooon.com/images/shipeixiaoguotu.png)
![](http://www.yatoooon.com/images/dpshipeixiaoguotu.png)
## 快速开始
1. **添加依赖**
 
    ``` implementation 'me.yatoooon:screenadaptation:1.0.5'```

2. **初始化工具类**

      (1.)创建自己的application继承Application
``` 
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
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
            android:value="1080" />  //设计图的宽,单位是像素,推荐用markman测量
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
        //在setContentView();后面加上下面这句话
        ScreenAdapterTools.getInstance().loadView((ViewGroup) getWindow().getDecorView());

    }
}
```
      (2.)在Fragment或recyclerview,listview或gridview,viewpager,自定义view等等等,只要能找到布局填充器
    
```
public class TestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_px, container, false);
        //拿到布局填充器返回的view后
        ScreenAdapterTools.getInstance().loadView((ViewGroup) view);
        return view;
    }
}  
注: 自定义view的话,在  ScreenAdapterTools.getInstance().loadView((ViewGroup) view);   外面包裹一层判断如下,不然在使用自定义view编写布局文件时预览xml会有问题!但不影响真机运行效果.
        if (!isInEditMode()) {
            ScreenAdapterTools.getInstance().loadView((ViewGroup) view);
        }    
```
      (3.)现在打开你的布局文件,并且打开预览,点击预览上部的小手机图标选择和你设计图匹配的模拟器,然后就可以按照设计图测量并编写布局文件,测量和编写的单位用px还是dp取决于你清单文件中的meta_data中unit填写的值,暂时只支持宽 高 padding layout_margin 字体大小,布局文件完成后,你看到的预览是什么样,各种真机运行出来就是什么样.
## 原理
```
  那些长篇大论的文章我也不想提,想必读者已经在别处看疯了,知道几个最简单的概念用起来就可以了  
     1. px是分辨率的单位 比如现在主流手机分辨率1080*1920.  
     2. dp是安卓开发专有的单位 在 不同的手机下 1dp = 不同的 px.  
     3. sp是字体大小(前面清单文件中要求字体也用dp或者px),sp随系统字体大小变化而变化,但据我观察,像微信qq这些app的字体是不随系统显示字体大小变化的.  
     ### 本库是按照设计图的宽度和对应标准dpi来适配的(宽度增加或减少,高度同比例增加或减少),在不同的分辨率,不同ppi(手机屏幕密度,又称为dpi),不同最小宽度(有的人喜欢去调开发者选项下面的最小宽度,主流手机默认为360dp)的手机下都做到了适配.(如果适配完发现高度不理想,那你就得考虑是不是高度方面写了太多的确定值,应该改用marchparent,或者使用权重比例,或者在外层包裹一个scrollview,等等等,想一些适配高度的一些办法)
```
## 联系我
* **Email**: <qazasdeszplm@126.com> 
* **qq**:    3529161483 

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
