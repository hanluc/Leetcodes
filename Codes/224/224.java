class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ","");
        
        Stack<String> stack = new Stack<>();
        String intbase = "";
        
        for(char c: s.toCharArray()){
            //int: 
            if( 0 <= (c-'0') && (c-'0')  < 10 ) //int
            {
                intbase = intbase + c;
                continue;
            }
            
            // op or parenthese
            else{  
                // DEAL WITH THE REMAINING INT FIRST
                if(intbase.length() > 0){
                    int lastint = Integer.parseInt(intbase);
                    //deal with this int
                    String op = "";
                    if (!stack.empty()){
                        op = stack.peek();  //peek the op or parentheses
                    }
                    if( op.equals("-")){
                        stack.pop(); 
                        int left = Integer.parseInt(stack.pop());
                        left -= lastint;
                        stack.push(Integer.toString(left));
                    }
                    else if( op.equals("+") ){
                        stack.pop();
                        int left = Integer.parseInt(stack.pop());
                        left += lastint;
                        stack.push(Integer.toString(left));
                    }
                    else{    //open parentheses
                        stack.push(intbase);  //do nothing and push
                    }
                    intbase = "";
                }
                // THEN FOCUS ON THIS CHAR
                if( c == ')' ){   //closing parentheses: calc done inside of the parenthese
                    String innerRes = stack.pop();
                    stack.pop();  //pop the "(" --> it must be "("
                    
                    //deal with the outside 
                    int right = Integer.parseInt(innerRes);
                    String op = "";
                    if (!stack.empty()){
                        op = stack.peek();  //peek the op or parentheses
                    }
                    if( op.equals("-") ){
                        stack.pop(); 
                        int left = Integer.parseInt(stack.pop());
                        left -= right;
                        stack.push(Integer.toString(left));
                    }
                    else if( op.equals("+") ){
                        stack.pop();
                        int left = Integer.parseInt(stack.pop());
                        left += right;
                        stack.push(Integer.toString(left));
                    }
                    else{    //open parentheses or nothing
                        stack.push(innerRes);  //do nothing and push
                    }                    
                }
                else{     //[ +, -, ( ]
                    stack.push(Character.toString(c));
                }

            }
            
        }
        System.out.println(stack.toString());
        if(intbase.length() > 0){
            int lastint = Integer.parseInt(intbase);
            //deal with this int
            String op = "";
            if (!stack.empty()){
                op = stack.peek();  //peek the op or parentheses
            }
            System.out.println(op);
            if( op.equals("-")){
                stack.pop(); 
                int left = Integer.parseInt(stack.pop());
                left -= lastint;
                stack.push(Integer.toString(left));
            }
            else if( op.equals("+")){
                stack.pop();
                int left = Integer.parseInt(stack.pop());
                left += lastint;
                //System.out.printf("left: %d, right: %d\n",left, lastint);
                stack.push(Integer.toString(left));
            }
            else{    //open parentheses
                stack.push(intbase);  //do nothing and push
            }
            intbase = "";
        }
        
        return Integer.parseInt(stack.pop());
        
    }
}