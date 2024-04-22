package src.sec01.chap07;

public class HadoonChicken {
    protected static final String CREED = "우리의 튀김옷은 얄팍하다";

    private final int no;
    public String name;

    public HadoonChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /*public void changeFinalFields() {
        this.no++;
    }*/

    public final void fryChicken() {
        System.out.println("염지, 반죽입히기, 튀김");
    }

}
