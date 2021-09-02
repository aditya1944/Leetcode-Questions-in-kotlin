import java.util.*

fun finalPrices(prices: IntArray): IntArray{
    val discountedPrice = IntArray(prices.size){idx -> prices[idx]};
    val stack = Stack<Int>();
    for(index in prices.indices){
        if(stack.empty() || (prices[stack.peek()]<prices[index])){
            stack.add(index);
        }else if(prices[index]<=prices[stack.peek()]){
            //we found a discounted price for the element at the top of stack
            while(stack.isNotEmpty() && prices[index]<=prices[stack.peek()]){
                discountedPrice[stack.peek()] = prices[stack.peek()] - prices[index];
                stack.pop();
            }
            stack.push(index);
        }
    }
    return discountedPrice;
}

fun main(){
    val discountedPrice = finalPrices(intArrayOf(1));
    for(price in discountedPrice){
        println(price);
    }
}