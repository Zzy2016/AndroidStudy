BaseObservable  
BaseObservable 提供了 notifyChange() 和 notifyPropertyChanged() 两个方法，  
前者会刷新所有的值域，后者则只更新对应 BR 的 flag，该 BR 的生成通过注释 @Bindable  
生成，可以通过 BR notify 特定属性关联的视图


ObservableField
        ObservableField 可以理解为官方对 BaseObservable 中字段的注解和刷新等操  
        作的封装，官方原生提供了对基本数据类型的封装，例如 ObservableBoolean、  
        ObservableByte、ObservableChar、ObservableShort、ObservableInt、  
        ObservableLong、ObservableFloat、ObservableDouble 以及  
        ObservableParcelable ，也可通过 ObservableField 泛型来申明其他类型


ObservableCollection

dataBinding 也提供了包装类用于替代原生的 List 和 Map，分别是 ObservableList 和  
ObservableMap,当其包含的数据发生变化时，绑定的视图也会随之进行刷新