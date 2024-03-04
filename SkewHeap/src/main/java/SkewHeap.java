class SkewHeap {
    private int key;
    private SkewHeap right;
    private SkewHeap left;


    public SkewHeap(int key) {
        this.key = key;
        right = null;
        left = null;
    }

    private static SkewHeap merge(SkewHeap h1, SkewHeap h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;

        if (h1.key > h2.key) {
            SkewHeap temp = h1;
            h1 = h2;
            h2 = temp;
        }
            SkewHeap temp = h1.left;
            h1.left = h1.right;
            h1.right = temp;


        h1.left = merge(h2, h1.left);
        return h1;
    }

    private static int getDepth(SkewHeap skew, int currentDepth, int maxDepth){
        if(skew == null)
            return maxDepth;
        maxDepth = Math.max(maxDepth, currentDepth);
        maxDepth = getDepth(skew.left, currentDepth + 1, maxDepth);
        maxDepth = getDepth(skew.right, currentDepth + 1, maxDepth);
        return maxDepth;
    }
    private static void getHeap(SkewHeap root, Integer[] array, int index) {
        if (root == null)
            return;

        array[index] = root.key;
        getHeap(root.left, array, 2 * index + 1);
        getHeap(root.right, array, 2 * index + 2);
    }


    public static Integer[] getPoppedHeap(int[] pushList){
        SkewHeap skew = null;
        for(int i = 0; i < pushList.length; i++){
            skew = merge(skew, new SkewHeap(pushList[i]));
        }

        SkewHeap h1 = skew.left;
        SkewHeap h2 = skew.right;
        skew = SkewHeap.merge(h1, h2);

        int maxDepth = getDepth(skew, 0, 0);
        double len = Math.pow(2, maxDepth+1) - 1.0;

        Integer[] heapArr = new Integer[(int)len];
        SkewHeap.getHeap(skew, heapArr, 0);

        return heapArr;
    }



    public static Integer[] buildHeapArr(int[] pushList){
        SkewHeap skew = null;
        for(int i = 0; i < pushList.length; i++){
            skew = SkewHeap.merge(skew, new SkewHeap(pushList[i]));
        }
        int maxDepth = getDepth(skew, 0, 0);
        double len = Math.pow(2, maxDepth+1) - 1.0;

        Integer[] heapArr = new Integer[(int)len];
        SkewHeap.getHeap(skew, heapArr, 0);
        return heapArr;
    }
}