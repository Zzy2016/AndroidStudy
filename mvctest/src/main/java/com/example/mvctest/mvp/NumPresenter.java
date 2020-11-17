package com.example.mvctest.mvp;

public class NumPresenter implements Ipresenter, SecondModel.CallBack {

    private SecondModel secondModel;
    private IView iView;

    public NumPresenter(IView iView) {
        this.iView = iView;
        secondModel = new SecondModel();
    }

    @Override
    public void add() {
        secondModel.add(this);
    }

    @Override
    public void onSuccess(int num) {
        iView.updateUI(String.valueOf(num));
    }

    @Override
    public void onFail(String error) {
        iView.updateUI("error");
    }
}
