3.6之上
viewBinding{
    enabled=true
}

viewBindingIgnore=fasle

ActivitySampleBinding binding=ActivitySampleBinding.inflate(getLayoutInflater()); 
setContentView(binding.getRoot())

Fragment
  在CreateView中进行视图绑定
  
  
  调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Fragment 使用。
  通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
  从 onCreateView() 方法返回根视图，使其成为屏幕上的活动视图
  
  FragmentBlankBinding binding;
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      // Inflate the layout for this fragment  
      //return inflater.inflate(R.layout.fragment_blank, container, false);
      binding = FragmentBlankBinding.inflate(inflater);
      return binding.getRoot();
  }
  
  
  
和findViewById的区别
1、Null 安全：由于视图绑定会创建对视图的直接引用，因此不存在因视图 ID 无效而引发 Null 指针异常的风险。
此外，如果视图仅出现在布局的某些配置中，则绑定类中包含其引用的字段会使用 @Nullable 标记。
2、类型安全：每个绑定类中的字段均具有与它们在 XML 文件中引用的视图相匹配的类型。这意味着不存在发生类转换
异常的风险。
数据绑定的区别
视图绑定和数据绑定均会生成可用于直接引用视图的绑定类。但是，视图绑定旨在处理更简单的用例，与数据绑定相比，具有以下优势：

更快的编译速度：视图绑定不需要处理注释，因此编译时间更短。
易于使用：视图绑定不需要特别标记的 XML 布局文件，因此在应用中采用速度更快。在模块中启用视图绑定后，它会自动应用于该模块的所有布局。
反过来，与数据绑定相比，视图绑定也具有以下限制：

视图绑定不支持布局变量或布局表达式，因此不能用于直接在 XML 布局文件中声明动态界面内容。
视图绑定不支持双向数据绑定。


