# AndroidScreenAdaptation
## 快速开始
1. **添加依赖**
 
    ``` implementation 'me.yatoooon:screenadaptation:1.0.1'```

2. **初始化工具类**

   * 创建自己的application继承Application
``` 
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ScreenAdapterTools.init(this);
    }
}
```
    * 在AndroidManifest.xml文件中声明使用你自己创建的application并且添加meta-data数据,后面会介绍这些数据的代表的意义
```
<application
        android:name=".App"
        .....
	    <meta-data
            android:name="designwidth"
            android:value="1080" />  
        <meta-data
            android:name="designdpi"
            android:value="480" />
        <meta-data
            android:name="fontsize"
            android:value="1.0" />
        <meta-data
            android:name="unit"
            android:value="dp" />
</application>	
```
3. **开始使用**

   
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
