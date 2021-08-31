fun maxProfit(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE;
    var maxProfit = 0;
    prices.forEach {
        if(it<minPrice){
            minPrice=it;
        }else{
            maxProfit = kotlin.math.max(maxProfit, it - minPrice);
        }
    };
    return maxProfit;
}

fun main(){
    print(maxProfit(intArrayOf(1,2,3,4)))
}