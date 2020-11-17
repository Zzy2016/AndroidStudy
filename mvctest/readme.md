//1.View接受用户的请求，然后将请求传递给Controller。
//        2.Controller进行业务逻辑处理后，通知Model去更新。
//        3.Model数据更新后，通知View去更新界面显示。
一个模型可以有多个视图，一个视图可以有多个控制器，一个控制器也可以有多个模型。
xml -->View
View层在Android中对应的就是布局的XML文件。
Activity  --> Controller
Android中一般由Activity来充当Controller。Controller一方面接收来自View的事件，一方面通知Model处理数据。


MVC的优点
视图层（View）与模型层（Model）解偶，通过Controller来进行联系。
模块职责划分明确。主要划分层M,V,C三个模块，利于代码的维护。

MVC的缺点
Android中使用了Activity来充当Controller，但实际上一些UI也是由Activity来控制的，比如进度条等。因此部分视图就会跟Controller捆绑在同一个类了。同时，由于Activity的职责过大，Activity类的代码也会迅速膨胀。
MVC还有一个重要的缺陷就是View跟Model是有交互的，没有做到完全的分离，这就会产生耦合。

<!--******************************-->
Model：模型层，负责处理数据的加载或存储。与MVP中的M一样。
View：视图层，负责界面数据的展示，与用户进行交互。与MVP中的V一样。
Presenter：负责逻辑业务的处理。跟MVC中的C有所区别。

1.View接受用户的请求，然后将请求传递给Presenter。 view不和model直接交互
2.Presenter进行业务逻辑处理，修改Model。
3.Presenter通知View去更新界面显示。

MVP的优点
View与Model完全分离，我们可以修改视图而不影响模型。
可以更高效地使用模型，因为所有的交互都发生Presenter中。
Presenter与View的交互是通过接口来进行的，有利于添加单元测试。
5. 存在的问题
页面逻辑复杂的话，相应的接口也会变多，增加维护成本。可以定义一些基类去分离一些公共的逻辑。
系统内存不足时，系统会回收Activity。一般我们都是用OnSaveInstanceState()去保存状态，用OnRestoreInstanceState()去恢复状态。但是在我们的MVP中，View层是不应该去直接操作Model的，所以这样做不合理，同时也增大了M与V的耦合。解决办法是不要将Activity作为View层，可以把Activity当Presenter来处理。具体实现这里就不分析了，有兴趣的可以研究一下。
UI改变的话，比如TextView 替换 EditText，可能导致Presente的一些更新UI的接口也跟着需要更改，存在一定的耦合。


<!--**********************-->
Model：模型层，负责处理数据的加载或存储。与MVP中的M一样。
View：视图层，负责界面数据的展示，与用户进行交互。与MVP中的V一样。
ViewModel：视图模型，负责完成View于Model间的交互,负责业务逻辑。


1.View与ViewModel进行绑定，能够实现双向的交互。ViewModel数据改变时，View会相应变动UI，反之亦然。
2.ViewModel进行业务逻辑处理，通知Model去更新。
3.Model数据更新后，把新数据传递给ViewModel。




链接：https://www.jianshu.com/p/54f82b17c4d3



