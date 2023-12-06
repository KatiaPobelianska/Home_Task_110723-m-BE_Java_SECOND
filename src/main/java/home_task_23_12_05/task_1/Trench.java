package home_task_23_12_05.task_1;

import lombok.Getter;

/*1 Создайте класс Траншея. У траншеи есть целевая длина
и текущая длина. Создайте класс Землекоп, объекты
которого копают траншею (увеличивают текущую длину),
пока не будет достигнута целевая длина. Каждый
землекоп может прокопать 1 м траншеи, а затем он
отдыхает 10 секунд. В программе создайте траншею и
двух землекопов. Измерьте, за какое время траншею
прокопает один землекоп и за какое время с такой же
траншеей управятся двое.*/
@Getter
public class Trench {
    private final int targetLength;
    private int currentLength;

    public Trench(int targetLength) {
        this.targetLength = targetLength;
        this.currentLength = 0;
    }
    public synchronized void dig(int amount){
        currentLength += amount;
        if (currentLength > targetLength){
            currentLength = targetLength;
        }
    }
}
