package com.example.rxtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import android.view.View;

import com.trello.rxlifecycle2.android.ActivityEvent;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        Subscriber<String> subscriber = new Subscriber<String>() {


            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {
                Log.e("Rx-->", s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("1");
                emitter.onNext("1");
                emitter.onComplete();
            }
        });


//        Schedulers.immediate(): 直接在当前线程运行，相当于不指定线程。这是默认的 Scheduler。//
//        Schedulers.newThread(): 总是启用新线程，并在新线程执行操作。//
//        Schedulers.io(): I/O 操作（读写文件、读写数据库、网络信息交互等）所使用的 Scheduler。行为模式和 newThread() 差不多，区别在于 io() 的内部实现是是用一个无数量上限的线程池，可以重用空闲的线程，因此多数情况下 io() 比 newThread() 更有效率。不要把计算工作放在 io() 中，可以避免创建不必要的线程。

//        Schedulers.computation(): 代表CPU计算密集型的操作, 例如需要大量计算的操作 ，计算所使用的 Scheduler。这个计算指的是 CPU 密集型计算，即不会被 I/O 等操作限制性能的操作，例如图形的计算。这个 Scheduler 使用的固定的线程池，大小为 CPU 核数。不要把 I/O 操作放在 computation() 中，否则 I/O 操作的等待时间会浪费 CPU。

//        另外， Android 还有一个专用的 AndroidSchedulers.mainThread()，它指定的操作将在 Android 主线程运行。

//        observerOn 指定上游发送事件的线程  Observable  多次指定只有第一次有效
//        ovserveOn 下游接受事件的线程  Observer  多次指定均有效
        observable.subscribe((Observer) subscriber);


//        map适用于一对一转换，当然也可以配合flatmap进行适用
//        flatmap适用于一对多，多对多的场景

//        Observable<T>	能够发射0或n个数据，并以成功或错误事件终止。
//        Flowable<T>	能够发射0或n个数据，并以成功或错误事件终止。 支持Backpressure，可以控制数据源发射的速度。
//        Single<T>	只发射单个数据或错误事件。
//        Completable	它从来不发射数据，只处理 onComplete 和 onError 事件。可以看成是Rx的Runnable。
//        Maybe<T>	能够发射0或者1个数据，要么成功，要么失败。有点类似于Optional


        Observable<String> observable1=new Observable<String>() {
            @Override
            protected void subscribeActual(Observer<? super String> observer) {

            }
        };

    }

    @Override
    protected void onPause() {
        super.onPause();
//        thread.stop();
    }

//    Thread thread=new Thread(new Runnable() {
//        @Override
//        public void run() {
//            while (true) {
//                Log.e("MainActivity-->", System.currentTimeMillis() + "");
//
//            }
//        }
//    });
}
