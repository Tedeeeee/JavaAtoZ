package src.sec02.chap02.pkg2;

import src.sec02.chap02.pkg1.Parent;

// pkg1 에 있던 parent 사용해보기
public class Child extends Parent {

    // private 사용 불가
    //int aa = a;

    // default 사용 불가
    //int bb = b;

    // protect 상속 사용 가능
    int cc = c;

    int dd = d;
}
