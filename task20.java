public class task20 {
    public static void main(String[] args) {
        int[] array = {5,2,9,1,5,6};
        int n= array.length;
        for(int i=0; i<(n-1); i++){
            for (int j=0; j<(n-1-i) ; j++){
                if (array[j]> array[j+1]){
                    int temp= array[j];
                    array[j] =array[j+1];
                    array[j+1] =temp;
                    System.out.println(array[j]);
                }

            }
        }
    }
}
