# AndroidScreenAdaptation
## 快速开始
1. **添加依赖**
 
    ``` implementation 'me.yatoooon:screenadaptation:1.0.1'```

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
            android:value="480" />   //设计图对应的dpi,根据下面的那张图找到对应的dpi,比如1080就对应480dpi
        <meta-data
            android:name="fontsize"
            android:value="1.0" />   //全局字体的大小,有时候老板会觉得你的所有的字小了或者大了,你总不能一个一个去改吧
        <meta-data
            android:name="unit"
            android:value="px" />   //你的布局里面用的是px这就写px,你的布局里面用的是dp这就写dp,要统一,不要一会儿px一会儿dp,字体也用px或者dp,原因后面会写.
</application>    
```
3. **开始使用**
    
      (1.)在Acivity中,找到setcontentview(R.layout.xxxxxx)
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
      (2.)在Fragment或recycleview或自定义view中,找到布局填充器
    
```public class TestFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_px, container, false);
        //拿到布局填充器返回的view后
        ScreenAdapterTools.getInstance().loadView((ViewGroup) view);
        return view;
    }
}
```
      (3.)现在打开你的布局文件,并且打开预览,点击预览上部的小手机图标选择和你设计图匹配的模拟器,然后就可以按照设计图测量并编写布局文件,测量和编写的单位用px还是dp取决于你清单文件中的meta_data中unit填写的值,暂时只支持宽 高 padding layout_margin 字体大小,布局文件完成后,你看到的预览是什么样,各种真机运行出来就是什么样

## 关于我
* **Email**: <qazasdeszplm@126.com> 
* **Home**: <http://yatoooon.com>

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
