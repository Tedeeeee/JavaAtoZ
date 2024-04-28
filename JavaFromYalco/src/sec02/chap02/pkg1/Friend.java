package src.sec02.chap02.pkg1;

public class Friend {
    Parent parent = new Parent();

    // private 한 a 는 사용 불가
    //int aa = new Parent().a;

    int bb = parent.b;
    int cc = parent.c;
    int dd = parent.d;
}
