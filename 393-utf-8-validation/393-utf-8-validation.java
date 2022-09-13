class Solution {
    public boolean validUtf8(int[] data) {
        int nextByte = 0;
        for(int x : data){
            if(nextByte == 0){
                if((x >>> 5) == 0b110) 
                    nextByte = 1;
                else if((x >>> 4) == 0b1110) 
                    nextByte = 2;
                else if((x >>> 3) == 0b11110) 
                    nextByte = 3;
                else if((x >>> 7) != 0b0) 
                    return false;
            } 
            else {
                if((x >>> 6) != 0b10) 
                    return false;
                nextByte--;
            }
        }
        return nextByte == 0;
    }
}