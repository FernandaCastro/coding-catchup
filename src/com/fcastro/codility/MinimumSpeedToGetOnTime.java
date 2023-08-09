package com.fcastro.codility;

/*
You are given a floating-point number hour, representing the amount of time you have to reach the office.
To commute to the office, you must take n trains in sequential order.
You are also given an integer array dist of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.

Each train can only depart at an integer hour, so you may need to wait in between each train ride.

For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you can depart on the 2nd train ride at the 2 hour mark.
Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for you to reach the office on time, or -1 if it is impossible to be on time.

Tests are generated such that the answer will not exceed 107 and hour will have at most two digits after the decimal point.

 */
public class MinimumSpeedToGetOnTime {

    public static void main(String[] args) {
        var o = new MinimumSpeedToGetOnTime();
//        System.out.println("Expected 1 => " + o.minSpeedOnTime(new int[]{1,3,2}, 6));
//        System.out.println("Expected 3 => " + o.minSpeedOnTime(new int[]{1,3,2}, 2.7));
//        System.out.println("Expected -1 => " + o.minSpeedOnTime(new int[]{1,3,2}, 1.9));
//        System.out.println("Expected 10000000 => " + o.minSpeedOnTime(new int[]{1,1,100000}, 2.01));
//        System.out.println("Expected -1 => " + o.minSpeedOnTime(new int[]{1,2,4,4,9}, 3.17));
        System.out.println("Expected 50 => " + o.minSpeedOnTime(new int[]{1,9}, 1.18));

    }

    public int minSpeedOnTime(int[] dist, double hour) {

        int minSpeed = 1, maxSpeed = (int) Math.pow(10,7), low = 1, high = maxSpeed;

        while (low <= high){

            int mid = (high - low) / 2 + low;

            if (isFeasibleJourney(dist, mid, hour, minSpeed, maxSpeed))
                high = mid - 1;
            else
                low = mid + 1;
        }

        return low > maxSpeed ? -1 : low;
    }

    public boolean isFeasibleJourney(int[] dist, int speed, double hour, int minSpeed, int maxSpeed) {

        if (speed < minSpeed) return false;
        if (speed > maxSpeed) return false;

        double commuteTime = 0;
        double waitTime = 0;

        for (int i = 0; i < dist.length; i++){

            var rideTime = (double) dist[i]/speed;

            commuteTime = commuteTime + waitTime + rideTime;
            if (commuteTime > hour){
                return false;
            }

            int intPart = (int) rideTime;
            double decimalPart = (intPart > 0) ? rideTime - intPart : rideTime;
            waitTime = (decimalPart > 0) ? 1 - decimalPart : 0;
        }

        return true;
    }
}
