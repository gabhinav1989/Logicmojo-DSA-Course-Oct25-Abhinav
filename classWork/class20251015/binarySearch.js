function binarySearch(nums, search){

    var start = 0;
    var end = nums.length - 1;

    
    while (start <= mid) {
        var mid = Math.floor((start + end) / 2);
                if (nums[mid] == search) {
            return mid;
        } else if (nums[mid] > search) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return -1;
}

console.log(binarySearch([1, 2, 3, 4, 5, 6, 7, 8, 9, 10], 6));
