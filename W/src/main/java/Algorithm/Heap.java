package Algorithm;

import java.io.IOException;

/**
 * Created by Dayu Wang on 07/23/2016.
 */
public class Heap {
    public void heapify(String[] arr, int root) throws IOException {

        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int best = root;

        String temp = "";
        Restaurant r1 = null;

        if(left < arr.length) {
            r1 = new Restaurant(arr[left]);
        }

        Restaurant r2 = new Restaurant(arr[root]);

        if(left < arr.length && r2.is_better_than(r1)) {
            best = left;
        }
        else {
            best = root;
        }

        Restaurant r3 = null;

        if(right < arr.length) {
            r3 = new Restaurant(arr[right]);
        }

        Restaurant r4 = new Restaurant(arr[best]);

        if(right < arr.length && r4.is_better_than(r3)) {
            best = right;
        }

        if(best != root) {
            temp = arr[root];
            arr[root] = arr[best];
            arr[best] = temp;

            heapify(arr, best);
        }
    }

    public void buildHeap(String[] arr, int root) throws IOException {

        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if(left < arr.length) {
            buildHeap(arr, left);
        }

        if(right < arr.length) {
            buildHeap(arr, right);
        }

        heapify(arr, root);
    }
}