class SparseVector {
    
    // index : value
    Map<Integer, Integer> vals = new HashMap<>();
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val != 0) {
                vals.put(i, val);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int dotProduct = 0;
        for (Map.Entry<Integer, Integer> entry : vals.entrySet()) {
            if (vec.vals.containsKey(entry.getKey())) {
                dotProduct += vec.vals.get(entry.getKey()) * vals.get(entry.getKey());
            }
        }
        return dotProduct;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
