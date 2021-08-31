import java.util.Stack
import kotlin.text.StringBuilder

fun removeKdigits(num: String, k: Int): String {
    if(num.length==k){
        return "0";
    }
    var popRemaining = k;
    val stack = Stack<Char>();
    for(char in num){
        if(stack.empty() || stack.peek()<=char){
            stack.push(char);
        }else{
            //top element in stack is greater than the current element.
            while(!stack.empty() && stack.peek()>char && popRemaining>0){
                stack.pop();
                --popRemaining;
            }
            stack.push(char);
        }
    }
    while(popRemaining>0 && !stack.empty()){
        stack.pop();
        --popRemaining;
    }
    var returnString = StringBuilder();
    while(!stack.empty()){
        returnString.append(stack.peek())
       stack.pop();
    }
    while(returnString.isNotEmpty() && returnString.last()=='0'){
        returnString.deleteCharAt(returnString.length-1);
    }
    if(returnString.isEmpty()){
        return "0";
    }

    returnString = returnString.reverse();

    return returnString.toString();
};


fun main(){
    print(removeKdigits("10", 1));
}

/**
 * "1234567890"
9
 */