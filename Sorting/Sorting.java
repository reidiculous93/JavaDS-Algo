// Bubble Sort O(N^2) "bubble" up larger elements starting from end
public void bubbleSort(int[]arr){
        boolean noSwaps;
        for(int i=arr.length;i>0;i--){
            noSwaps=true;
            for(int j=0;j<i -1;j++){
                if(arr[j]>arr[j+1]){
                    noSwaps=false;
                    swap(j,j+1,arr);
                }
            }
        if(noSwaps)break;
        }
}

public void swap(int j,int i,int[]arr){
        int tmp=arr[j];
        arr[j]=arr[i];
        arr[i]=tmp;
}

// Selection Sort O(N^2) : always moves minimum element to beginning of loop i
public void selectionSort(int[]arr){

        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j
                }
            }
            if(min!=i){
                int tmp=nums[i];
                nums[i]=nums[min];
                nums[min]=tmp;
            }
        }
}

// Insertion Sort  : take element one at a time and insert in correct spot. start with second element
public void insertionSort(int[]arr){
        for(int i=1;i<arr.length;i++){
            int curr=nums[i];
            int index=i;
            for(int j=i-1;j>=0&&arr[j]>curr;j--){
                arr[j+1]=arr[j];
                index=j;
            }
        arr[index+1]=curr;
        }
}

//Merge Sort : O(n log n)
public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
}

public static void merge(
        int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
}

// Quick Sort O(n^2)
public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
}

private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
}

// Radix Sort
static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
}

static void countSort(int arr[], int n, int exp){
        int output[]=new int[n]; // output array
        int i;
        int count[]=new int[10];
        Arrays.fill(count,0);

        // Store count of occurrences in count[]
        for(i=0;i<n; i++)
            count[(arr[i]/exp)%10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for(i=1;i< 10;i++)
            count[i]+=count[i-1];

        // Build the output array
        for(i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current digit
        for(i=0;i<n; i++)
            arr[i]=output[i];
        }

static void radixsort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
        }