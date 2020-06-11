package de.unistuttgart.vis.dsass2020.ex06.p4;

import static org.junit.Assert.*;


import org.junit.Test;

import de.unistuttgart.vis.dsass2020.ex06.p4.ISimpleList;
import de.unistuttgart.vis.dsass2020.ex06.p4.Sorter;

public class SorterTest {

    @Test
    public void createHeapProperties(){
        SimpleList<Integer> list = new SimpleList<>();
        list.append(2);
        list.append(4);
        list.append(1);
        list.append(5);
        list.append(6);
        list.append(7);
        list.append(-8);
        list.append(3);
        list.append(3);

        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i) + "\t");
        }

       Sorter.heapSort(list);
        System.out.println("");

        for(int i = 0 ; i < list.size(); i++){
            System.out.print(list.get(i) + "\t");
        }


    }
	
	
}
