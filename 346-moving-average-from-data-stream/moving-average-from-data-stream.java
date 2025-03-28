class MovingAverage {

    Queue<Integer> q;
    int sz;


    public MovingAverage(int size) {
        q = new LinkedList();
        sz = size;
    }
    
    public double next(int val) {

        if(q.size() == sz){
            q.poll();
        }

        q.offer(val);
        double res = 0;

        for(int each: q){
            res += (double)each;
        }

        res = res / q.size();

        return res;
        
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */