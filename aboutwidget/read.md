应用微件  可以嵌入其他应用并接收定期更新的微型应用视图

AppWidgetProviderInfo  定义应用组件的元数据，布局、更新频率、和AppWidgetProvider类，在xml文件夹下定义
AppWidgetProvider   与组件进行连接，可以收到不同类型的广播。
布局文件  layout中定义
AndroidManifest.xml中声明AppWidgetProvider类。
meta-data  :
   name :android.appwidget.provider
   resource:  指定AppWidgetProviderInfo位置
<intent-filter>  包含有一个具有android:name属性的action元素。指定AppWidgetProvider接收ACTION_APPWIDGET_UPDATE广播


AppWidgetProviderInfo元数据
   xml文件中
   <appwidget-provider>
   minWidth minHeight 指定组件默认情况下占用的最小空间。默认的主屏幕定义了高度和宽度的单元额的网格在其
   窗口中方位应用组件。如果应用微件的最小宽度或高度的值与单元格的尺寸不匹配，则应用微件的尺寸会向上舍入
   到最接近的单元格大小。
   minResizeWidth  minResizeHeight 指定应用微件的绝对最小大小 这些值应指定应用微件的大小低于多大就会难以辨认或无法使用
   updatePeriodMillis 属性定义应用微件框架通过调用 onUpdate() 回调方法来从 AppWidgetProvider 请求更新的频
   率应该是多大。不能保证实际更新按此值正好准时发生，我们建议尽可能降低更新频率 - 或许不超过每小时一次，以节省
   电池电量。
   initialLayout 属性指向用于定义应用微件布局的布局资源。
   configure 属性定义要在用户添加应用微件时启动以便用户配置应用微件属性的 Activity。
   previewImage 属性指定预览来描绘应用微件经过配置后是什么样子的，用户在选择应用微件时会看到该预览。如果未
   提供，则用户会看到应用的启动器图标。此字段对应于 AndroidManifest.xml 文件的 <receiver> 元素中的 android:previewImage 属性
   autoAdvanceViewId 属性指定应由应用微件的托管应用自动跳转的应用微件子视图的视图 ID。此属性是在 Android 
   3.0 中引入的。
   resizeMode 属性指定可以按什么规则来调整微件的大小。您可以使用此属性来让主屏幕微件在横轴上可调整大小、在纵
   轴上可调整大小，或者在这两个轴上均可调整大小。用户可轻触并按住微件以显示其大小调整手柄，然后拖动水平和/或垂
   直手柄以更改布局网格上的大小。resizeMode 属性的值包括“horizontal”、“vertical”和“none”。要将微件声明为在
   水平和垂直方向上均可调整大小，请提供值“horizontal|vertical”。
   minResizeHeight 属性指定可将微件大小调整到的最小高度（以 dp 为单位）。如果此字段的值大于 minHeight 或未
   启用垂直大小调整（请参阅 resizeMode），则此字段不起作用。
   minResizeWidth 属性指定可将微件大小调整到的最小宽度（以 dp 为单位）。如果此字段的值大于 minWidth 或未启
   用水平大小调整（请参阅 resizeMode），则此字段不起作用。
   widgetCategory 属性声明应用微件是否可以显示在主屏幕 (home_screen) 和/或锁定屏幕 (keyguard) 上。只有低
   于 5.0 的 Android 版本才支持锁定屏幕微件。对于 Android 5.0 及更高版本，只有 home_screen 有效。
创建组件布局文件  layout
   FrameLayout LinearLayout RelativeLayout GridLayout
   AnalogClock Button Chronometer ImageButton ImageView ProgressBar TextView ViewFlipper ListView GridView StackView AdapterViewFlipper
AppWidgetProvider  本质是广播接收器
  onUpdate() 
            调用此方法可以按 AppWidgetProviderInfo 中的 updatePeriodMillis 属性定义的时间间隔来更新应用微件
            （请参阅上文的添加 AppWidgetProviderInfo 元数据）。当用户添加应用微件时也会调用此方法，所以它应执
            行基本设置，如定义视图的事件处理脚本以及根据需要启动临时的 Service。不过，如果您已声明配置 Activity
            ，则当用户添加应用微件时不会调用此方法，            但会调用它来执行后续更新。由配置 Activity 负责
            在配置完成后执行首次更新。（请参阅下文的创建应用微件配置 Activity。）
  onAppWidgetOptionsChanged()
        OPTION_APPWIDGET_MIN_WIDTH - 包含微件实例的当前宽度的下限（以 dp 为单位）。
        OPTION_APPWIDGET_MIN_HEIGHT - 包含微件实例的当前高度的下限（以 dp 为单位）。
        OPTION_APPWIDGET_MAX_WIDTH - 包含微件实例的当前宽度的上限（以 dp 为单位）。
        OPTION_APPWIDGET_MAX_HEIGHT - 包含微件实例的当前高度的上限（以 dp 为单位）。
  
  onDeleted()  每次从应用微件托管应用中删除应用微件时，都会调用此方法。
  onEnabled()  首次创建应用微件的实例时，会调用此方法。例如，如果用户添加应用微件的两个实例，只有首次添加时会
  调用此方法。如果您需要打开一个新的数据库或执行只需要对所有应用微件实例执行一次的其他设置，则此方法非常合适。
  onDisabled() 从应用微件托管应用中删除了应用微件的最后一个实例时，会调用此方法。您应使用此方法来清理在 
  onEnabled(Context) 中完成的所有工作，如删除临时数据库。
  onReceiver() 针对每个广播调用此方法，并且是在上述各个回调方法之前调用。您通常不需要实现此方法，因为默认的
        AppWidgetProvider 实现会过滤所有应用微件广播并视情况调用上述方法。
  
  
  固定应用微件  8.0以上玉仙云创建固定的快捷方式的启动器也允许将应用微件固定在启动器上。
      使用AppWidgetManager  requestPinAppWidget()
      
      
  创建应用微件配置Activity 
       Activity配置文件中   Activity 将由应用微件托管应用通过 ACTION_APPWIDGET_CONFIGURE 操作来启动，因此它需要接受此 Intent。
        <activity android:name=".ExampleAppWidgetConfigure">
                <intent-filter>
                    <action android:name="android.appwidget.action.APPWIDGET_CONFIGURE"/>
                </intent-filter>
            </activity>
            
       appWidgetproviderinfo 文件中 AppWidgetProviderInfo XML 文件中使用 android:configure 属性声明该 Activity
         <appwidget-provider xmlns:android="http://schemas.android.com/apk/res/android"
               ...
               android:configure="com.example.android.ExampleAppWidgetConfigure"
               ... >
           </appwidget-provider>
           
       应用微件托管应用调用配置 Activity，并且配置 Activity 应始终返回结果。结果应包含由启动该 Activity 的 Intent 传递的应用微件 ID（在 Intent extra 中保存为 EXTRA_APPWIDGET_ID）。
       创建应用微件时，系统不会调用 onUpdate() 方法（启动配置 Activity 时，系统不会发送 ACTION_APPWIDGET_UPDATE 广播）。首次创建应用微件时，由配置 Activity 负责从 AppWidgetManager 请求更新。不过，系统会调用 onUpdate() 来执行后续更新，只在首次更新时不会调用它。
   
          1 首先，从启动该 Activity 的 Intent 获取应用微件 ID：
          2执行应用微件配置。
          3配置完成后，通过调用 getInstance(Context) 来获取 AppWidgetManager 的实例：
          4通过调用 updateAppWidget(int, RemoteViews) 来使用 RemoteViews 布局更新应用微件
          5最后，创建返回 Intent，为其设置 Activity 结果，然后结束该 Activity：