package Lab4;

import java.util.Random;

public class ArrayBubble{
    public int[] a;   //������ �� ������

    public ArrayBubble(int max){    //����������� ������
        a = new int[max];          //�������� ������� �������� max
        Random rnd = new Random();
        for(int i=0; i<a.length; i++)
        {
            a[i] = rnd.nextInt();
        }
    }

    private void toSwap(int first, int second){ //����� ������ ������� ���� ����� �������
        int dummy = a[first];      //�� ��������� ���������� �������� ������ �������
        a[first] = a[second];       //�� ����� ������� ������ ������ �������
        a[second] = dummy;          //������ ������� �������� ����� ������ �� ��������� ������
    }

    public void bubbleSorter(){     //����� ����������� ����������
        for (int out = a.length - 1; out >= 1; out--){  //������� ����
            for (int in = 0; in < out; in++){       //���������� ����
                if(a[in] > a[in + 1])               //���� ������� ��������� �������
                    toSwap(in, in + 1);             //������� �����, �������� �������
            }
        }
    }
}
